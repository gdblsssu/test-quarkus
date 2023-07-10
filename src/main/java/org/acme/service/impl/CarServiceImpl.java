package org.acme.service.impl;

import jakarta.inject.Inject;
import org.acme.entity.Car;
import org.acme.repository.CarRepository;
import org.acme.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Inject
    CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll().list();
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public String add(Car car) {
        carRepository.persist(car);
        return "Added: " + car.getName();
    }

    @Override
    public String deleteById(Long id) {
        Car existingCar = carRepository.findById(id);
        return "Deleted: " + existingCar.getName();
    }

    @Override
    public String update(Long id, Car car) {
        Car existingCar = carRepository.findById(id);
        existingCar.setName(car.getName());
        existingCar.setColor(car.getColor());
        existingCar.setMaxSpeed(car.getMaxSpeed());
        return "Updated: " + existingCar.getName();
    }
}
