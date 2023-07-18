package org.acme.service.logiclayer.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.acme.entity.Car;
import org.acme.entity.Person;
import org.acme.entity.VehicleType;
import org.acme.repository.CarRepository;
import org.acme.repository.PersonRepository;
import org.acme.repository.VehicleTypeRepository;
import org.acme.service.logiclayer.PersonService;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {
    @Inject
    PersonRepository personRepository;
    @Inject
    CarRepository carRepository;
    @Inject
    VehicleTypeRepository vehicleTypeRepository;
    @Override
    public List<Person> getAll() {
        List<Person> personList = personRepository.findAll().list();
        if(personList.isEmpty()){
            throw new NotFoundException();
        }
        return personList;
    }

    @Override
    public Person getById(Long id) {
        Person existingPerson = personRepository.findById(id);
        if(existingPerson == null){
            throw new NotFoundException();
        }
        return existingPerson;
    }

    @Override
    public void add(Person person) {
        Set<Car> carSet = person.getCarSet();
        for(Car car: carSet){
            car.setVehicleType(vehicleTypeRepository.saveOrSelect(car.getVehicleType()));
            carRepository.persist(car);
            person.addCar(car);
        }
    }

    @Override
    public void deleteById(Long id) {
        Person existingPerson = personRepository.findById(id);
        if(existingPerson == null){
            throw new NotFoundException();
        }
        personRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Person person) {
        Person existingPerson = personRepository.findById(id);
        if(existingPerson == null){
            throw new NotFoundException();
        }
        existingPerson.setName(person.getName());
        existingPerson.setSurname(person.getSurname());
        existingPerson.setAge(person.getAge());
        existingPerson.setPhone(person.getPhone());
    }
}
