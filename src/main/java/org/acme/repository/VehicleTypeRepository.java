package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.VehicleType;

@ApplicationScoped
public class VehicleTypeRepository implements PanacheRepository<VehicleType> {
}
