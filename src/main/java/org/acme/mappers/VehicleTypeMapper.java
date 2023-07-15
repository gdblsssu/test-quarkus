package org.acme.mappers;

import org.acme.dto.CarDTO;
import org.acme.dto.VehicleTypeDTO;
import org.acme.entity.Car;
import org.acme.entity.VehicleType;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "jakarta",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface VehicleTypeMapper {
    VehicleTypeDTO toDTO(VehicleType vehicleType);
    VehicleType toEntity(VehicleTypeDTO vehicleTypeDTO);
}
