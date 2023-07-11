package org.acme.service;

import org.acme.dto.CarDTO;
import org.acme.entity.Car;

import java.util.List;

public interface CarService {

    public List<CarDTO> getAll();
    public CarDTO getById(Long id);
    public void add(CarDTO carDTO);
    public void delete(Long id);
    public void update(Long id, CarDTO carDTO);
}
