package org.acme.service;

import org.acme.entity.Car;

import java.util.List;

public interface CarService {

    public List<Car> getAll();
    public Car getById(Long id);
    public void add(Car car);
    public void delete(Long id);
    public void update(Long id, Car car);
}
