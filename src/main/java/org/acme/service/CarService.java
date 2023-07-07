package org.acme.service;

import org.acme.entity.Car;
import org.acme.entity.Person;

import java.util.List;

public interface CarService {
    public List<Car> getAll();
    public Car getById(Long id);
    public String add(Car car);
    public String deleteById(Long id);
    public String update(Long id, Car car);
}
