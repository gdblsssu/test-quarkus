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
    public String add(Person person) {
        personRepository.persist(person);
        return "Added: " + person.getName();
    }

    @Override
    public String deleteById(Long id) {
        Person existingPerson = personRepository.findById(id);
        personRepository.deleteById(id);
        return "Deleted: " + existingPerson.getName();
    }

    @Override
    public String update(Long id, Person person) {
        Person existingPerson = personRepository.findById(id);
        existingPerson.setName(person.getName());
        existingPerson.setSurname(person.getSurname());
        existingPerson.setAge(person.getAge());
        existingPerson.setPhone(person.getPhone());
        return "Updated: " + existingPerson.getName();
    }
}
