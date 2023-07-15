package org.acme.service.controllerlayer.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.acme.dto.CarDTO;
import org.acme.dto.VehicleTypeDTO;
import org.acme.entity.Car;
import org.acme.entity.VehicleType;
import org.acme.mappers.CarMapper;
import org.acme.mappers.VehicleTypeMapper;
import org.acme.repository.CarRepository;
import org.acme.repository.VehicleTypeRepository;
import org.acme.service.controllerlayer.CarService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarServiceImpl implements CarService {

    @Inject
    CarRepository carRepository;
    @Inject
    CarMapper carMapper;
    @Inject
    VehicleTypeMapper vehicleTypeMapper;
    @Inject
    VehicleTypeRepository vehicleTypeRepository;

    @Override
    public List<CarDTO> getAll() {
        List<Car> carList = carRepository.findAll().list();
        if(carList.isEmpty()){
            throw new NotFoundException();
        }
        List<CarDTO> carDTOList = new ArrayList<>();
        for(Car car: carList){
            CarDTO carDTO = carMapper.toDTO(car);
            VehicleTypeDTO vehicleTypeDTO = vehicleTypeMapper.toDTO(car.getVehicleType());
            carDTO.setVehicleTypeDTO(vehicleTypeDTO);
            carDTOList.add(carDTO);
        }
        return carDTOList;
        //return carMapper.toDTOList(carRepository.findAll().list());
    }

    @Override
    public CarDTO getById(Long id) {
        Car existingCar = carRepository.findById(id);
        if(existingCar == null){
            throw new NotFoundException();
        }
        return carMapper.toDTO(existingCar);
    }

    @Override
    public void add(CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        VehicleType vehicleType = vehicleTypeMapper.toEntity(carDTO.getVehicleTypeDTO());
        car.setVehicleType(vehicleType);
        vehicleTypeRepository.persist(vehicleType);
        carRepository.persist(car);
    }

    @Override
    public void delete(Long id) {
        Car existingCar = carRepository.findById(id);
        if(existingCar == null){
            throw new NotFoundException();
        }
        carRepository.deleteById(id);
    }

    @Override
    public void update(Long id, CarDTO carDTO) {
        Car carFromDTO = carMapper.toEntity(carDTO);
        Car existingCar = carRepository.findById(id);
        if(existingCar == null){
            throw new NotFoundException();
        }
        existingCar.setName(carFromDTO.getName());
        existingCar.setColor(carFromDTO.getColor());
        existingCar.setMaxSpeed(carFromDTO.getMaxSpeed());
        existingCar.setVehicleType(carFromDTO.getVehicleType());
    }
}
