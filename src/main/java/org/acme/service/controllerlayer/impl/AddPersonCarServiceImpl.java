package org.acme.service.controllerlayer.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.CarDTO;
import org.acme.dto.PersonDTO;
import org.acme.entity.Car;
import org.acme.entity.Person;
import org.acme.entity.VehicleType;
import org.acme.mappers.CarMapper;
import org.acme.mappers.PersonMapper;
import org.acme.mappers.VehicleTypeMapper;
import org.acme.repository.CarRepository;
import org.acme.repository.PersonRepository;
import org.acme.repository.VehicleTypeRepository;
import org.acme.service.controllerlayer.AddPersonCarService;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class AddPersonCarServiceImpl implements AddPersonCarService {

    @Inject
    PersonRepository personRepository;
    @Inject
    CarRepository carRepository;
    @Inject
    PersonMapper personMapper;
    @Inject
    CarMapper carMapper;
    @Inject
    VehicleTypeMapper vehicleTypeMapper;
    @Inject
    VehicleTypeRepository vehicleTypeRepository;

    @Override
    public void add(PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        Set<CarDTO> carDTOSet = personDTO.getCarDTOSet();
        System.out.println(carDTOSet);
        if(carDTOSet.isEmpty()){
           personRepository.persist(person);
           return;
        }
        Set<Car> carSet = new HashSet<>();
        for (CarDTO carDTO: carDTOSet) {
            Car car = carMapper.toEntity(carDTO);
            VehicleType vehicleType = vehicleTypeMapper.toEntity(carDTO.getVehicleTypeDTO());
            car.setVehicleType(vehicleType);
            vehicleTypeRepository.persist(vehicleType);
            carRepository.persist(car);
            System.out.println(car);
            carSet.add(car);
            person.addCar(car);
        }

    }
}
