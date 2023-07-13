package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CarDTO;
import org.acme.entity.Car;
import org.acme.mappers.CarMapper;
import org.acme.repository.CarRepository;
import org.acme.service.CarService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarServiceImpl implements CarService {

    @Inject
    CarRepository carRepository;
    @Inject
    CarMapper carMapper;

    @Override
    public List<CarDTO> getAll() {
        List<Car> carList = carRepository.findAll().list();
        if(carList.isEmpty()){
            throw new NotFoundException();
        }
        List<CarDTO> carDTOList = new ArrayList<>();
        for(Car car: carList){
            carDTOList.add(carMapper.toDTO(car));
        }
        return carDTOList;
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
    }
}
