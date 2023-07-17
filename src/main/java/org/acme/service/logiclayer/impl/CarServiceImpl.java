package org.acme.service.logiclayer.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.acme.entity.Car;
import org.acme.entity.VehicleType;
import org.acme.repository.CarRepository;
import org.acme.repository.VehicleTypeRepository;
import org.acme.service.logiclayer.CarService;

import java.util.List;

@ApplicationScoped
public class CarServiceImpl implements CarService {

    @Inject
    CarRepository carRepository;
    @Inject
    VehicleTypeRepository vehicleTypeRepository;

    @Override
    public List<Car> getAll() {
        List<Car> carList = carRepository.findAll().list();
        if(carList.isEmpty()){
            throw new NotFoundException();
        }
        return carList;
    }

    @Override
    public Car getById(Long id) {
        Car existingCar = carRepository.findById(id);
        if(existingCar == null){
            throw new NotFoundException();
        }
        return existingCar;
    }

    @Override
    public void add(Car car, VehicleType vehicleType) {
        vehicleTypeRepository.persist(vehicleType);
        car.setVehicleType(vehicleType);
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
    public void update(Long id, Car car) {
        Car existingCar = carRepository.findById(id);
        if(existingCar == null){
            throw new NotFoundException();
        }
        existingCar.setName(car.getName());
        existingCar.setColor(car.getColor());
        existingCar.setMaxSpeed(car.getMaxSpeed());
        existingCar.setVehicleType(car.getVehicleType());
    }

    @Override
    public String getStatisticColor() {
        return carRepository.getCountColor();
    }
}
