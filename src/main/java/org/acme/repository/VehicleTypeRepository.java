package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.VehicleType;

import java.util.List;

@ApplicationScoped
public class VehicleTypeRepository implements PanacheRepository<VehicleType> {

    @Override
    public void persist(VehicleType vehicleType) {
        List<VehicleType> vehicleTypeList = findAll().list();
        for (VehicleType existingVehicleType: vehicleTypeList) {
            if(existingVehicleType.getCode().equals(vehicleType.getCode()) &&
            existingVehicleType.getTypeName().equals(vehicleType.getTypeName())){
                vehicleType = existingVehicleType;
                System.out.println("0 - " + vehicleType);
                return;
            } else {
                PanacheRepository.super.persist(vehicleType);
            }
        }

    }
}
