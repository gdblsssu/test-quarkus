package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.Car;
import org.acme.repository.CarRepository;
import org.acme.service.CarService;

import java.util.List;

@ApplicationScoped
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
    public void add(Car car) {
        carRepository.persist(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Car car) {
        Car existingCar = carRepository.findById(id);
        existingCar.setName(car.getName());
        existingCar.setColor(car.getColor());
        existingCar.setMaxSpeed(car.getMaxSpeed());
    }
}
