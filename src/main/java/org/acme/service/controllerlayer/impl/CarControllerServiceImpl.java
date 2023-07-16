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
import org.acme.service.controllerlayer.CarControllerService;
import org.acme.service.logiclayer.CarService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarControllerServiceImpl implements CarControllerService {

    @Inject
    CarService carService;
    @Inject
    CarMapper carMapper;
    @Inject
    VehicleTypeMapper vehicleTypeMapper;


    @Override
    public List<CarDTO> getAll() {
        List<Car> carList = carService.getAll();
        List<CarDTO> carDTOList = new ArrayList<>();
        for(Car car: carList){
            CarDTO carDTO = carMapper.toDTO(car);
            VehicleTypeDTO vehicleTypeDTO = vehicleTypeMapper.toDTO(car.getVehicleType());
            carDTO.setVehicleTypeDTO(vehicleTypeDTO);
            carDTOList.add(carDTO);
        }
        return carDTOList;
    }

    @Override
    public CarDTO getById(Long id) {
        Car existingCar = carService.getById(id);
        return carMapper.toDTO(existingCar);
    }

    @Override
    public void add(CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        VehicleType vehicleType = vehicleTypeMapper.toEntity(carDTO.getVehicleTypeDTO());
        carService.add(car, vehicleType);
    }

    @Override
    public void delete(Long id) {
        carService.delete(id);
    }

    @Override
    public void update(Long id, CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        carService.update(id, car);
    }

    @Override
    public String getStatisticsColor() {
        return carService.getStatisticColor();
    }
}
