package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.entity.Car;
import org.acme.entity.Person;
import org.acme.entity.VehicleType;
import org.acme.repository.VehicleTypeRepository;
import org.acme.service.logiclayer.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@QuarkusTest
public class CarServiceTest {
    @Inject
    CarService carService;

    @Inject
    VehicleTypeRepository vehicleTypeRepository;

    @Test
    @Transactional
    public void testAddCar(){
        List<VehicleType> vehicleTypes = vehicleTypeRepository.findAll().list();
        String testName = "TestTypeName";
        Assertions.assertNotEquals(testName, vehicleTypes.get(vehicleTypes.size() - 1).getTypeName());

        VehicleType vehicleType = new VehicleType();
        vehicleType.setTypeName("TestTypeName");
        vehicleType.setCode(228);

        Car car = new Car();
        car.setName("Lada Granta");
        car.setColor("dark blue");
        car.setMaxSpeed(20);

        carService.add(new Car(), vehicleType);
        vehicleTypes = vehicleTypeRepository.findAll().list();
        Assertions.assertEquals(testName, vehicleTypes.get(vehicleTypes.size() - 1).getTypeName());

    }
}
