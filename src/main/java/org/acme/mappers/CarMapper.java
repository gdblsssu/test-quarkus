package org.acme.mappers;

import org.acme.dto.CarDTO;
import org.acme.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "jakarta",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CarMapper {
    CarDTO toDTO(Car car);
    Car toEntity(CarDTO carDTO);
}
