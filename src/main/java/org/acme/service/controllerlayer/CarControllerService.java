package org.acme.service.controllerlayer;

import org.acme.dto.CarDTO;

import java.util.List;

public interface CarControllerService {

    public List<CarDTO> getAll();
    public CarDTO getById(Long id);
    public void add(CarDTO carDTO);
    public void delete(Long id);
    public void update(Long id, CarDTO carDTO);
}
