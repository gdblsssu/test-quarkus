package org.acme.service.logiclayer;

import org.acme.entity.Car;
import org.acme.entity.VehicleType;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    Car getById(Long id);
    void add(Car car, VehicleType vehicleType);
    void delete(Long id);
    void update(Long id, Car car);
    String getStatisticColor();
}
