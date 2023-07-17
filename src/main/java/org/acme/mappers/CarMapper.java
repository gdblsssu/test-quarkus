package org.acme.mappers;

import org.acme.dto.CarDTO;
import org.acme.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "jakarta",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {VehicleTypeMapper.class})
public interface CarMapper {

    @Mapping(target = "vehicleTypeDTO", source = "vehicleType")
    CarDTO toDTO(Car car);
    @Mapping(target = "vehicleType", source = "vehicleTypeDTO")
    Car toEntity(CarDTO carDTO);

    List<Car> toEntityList(List<CarDTO> carDTOList);
    List<CarDTO> toDTOList(List<Car> carList);
}
