package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.Person;
import org.acme.repository.PersonRepository;
import org.acme.service.PersonService;

import java.util.List;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {

    @Inject
    PersonRepository personRepository;
    @Override
    public List<Person> getAll() {
        return personRepository.findAll().list();
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void add(Person person) {
        personRepository.persist(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Person person) {
        Person existingPerson = personRepository.findById(id);
        existingPerson.setName(person.getName());
        existingPerson.setSurname(person.getSurname());
        existingPerson.setAge(person.getAge());
        existingPerson.setPhone(person.getPhone());
    }
}
