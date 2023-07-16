package org.acme.service.controllerlayer.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.acme.dto.CarDTO;
import org.acme.dto.PersonDTO;
import org.acme.entity.Car;
import org.acme.entity.Person;
import org.acme.entity.VehicleType;
import org.acme.mappers.CarMapper;
import org.acme.mappers.PersonMapper;
import org.acme.mappers.VehicleTypeMapper;
import org.acme.repository.PersonRepository;
import org.acme.service.controllerlayer.PersonControllerService;
import org.acme.service.logiclayer.PersonService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class PersonControllerServiceImpl implements PersonControllerService {


    @Inject
    PersonMapper personMapper;

    @Inject
    PersonService personService;
    @Inject
    CarMapper carMapper;
    @Inject
    VehicleTypeMapper vehicleTypeMapper;

    @Override
    public List<PersonDTO> getAll() {
        List<Person> personList = personService.getAll();
        return personMapper.toListDTO(personList);
    }

    @Override
    public PersonDTO getById(Long id) {
        Person existingPerson = personService.getById(id);
        return personMapper.toDTO(existingPerson);
    }

    @Override
    public void add(PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        Set<CarDTO> carDTOSet = personDTO.getCarDTOSet();
        Set<Car> carSet = new HashSet<>();
        for (CarDTO carDTO: carDTOSet) {
            Car car = carMapper.toEntity(carDTO);
            VehicleType vehicleType = vehicleTypeMapper.toEntity(carDTO.getVehicleTypeDTO());
            car.setVehicleType(vehicleType);
            carSet.add(car);
        }
        person.setCarSet(carSet);
        personService.add(person);
    }

    @Override
    public void deleteById(Long id) {
        personService.deleteById(id);
    }

    @Override
    public void update(Long id, PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        personService.update(id, person);
    }
}
