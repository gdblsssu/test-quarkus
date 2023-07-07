package org.acme.service.impl;

import jakarta.inject.Inject;
import org.acme.entity.Car;
import org.acme.entity.Person;
import org.acme.repository.CarRepository;
import org.acme.service.CarService;

import java.util.List;

public class CarSeviceImpl implements CarService {

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
        return "Added " + car.getName();
    }

    @Override
    public String deleteById(Long id) {
        Car car = carRepository.findById(id);
        carRepository.deleteById(id);
        return "Deleted + " + car.getName();
    }

    @Override
    public String update(Long id, Car car) {
        Car c = carRepository.findById(id);
        c.setName(car.getName());
        c.setColor(car.getColor());
        c.setMaxSpeed(car.getMaxSpeed());

        return "Updated + " + c.getName();
    }
}
