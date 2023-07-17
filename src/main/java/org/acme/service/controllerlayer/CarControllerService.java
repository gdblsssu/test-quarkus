package org.acme.service.controllerlayer;

import org.acme.dto.CarDTO;

import java.util.List;

public interface CarControllerService {

    List<CarDTO> getAll();
    CarDTO getById(Long id);
    void add(CarDTO carDTO);
    void delete(Long id);
    void update(Long id, CarDTO carDTO);
    String getStatisticsColor();
}
