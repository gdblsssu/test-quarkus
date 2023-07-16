package org.acme.service.logiclayer;

import org.acme.entity.Car;
import org.acme.entity.VehicleType;

import java.util.List;

public interface CarService {
    public List<Car> getAll();
    public Car getById(Long id);
    public void add(Car car, VehicleType vehicleType);
    public void delete(Long id);
    public void update(Long id, Car car);
    public String getStatisticColor();
}
