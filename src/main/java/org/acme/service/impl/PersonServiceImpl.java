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
        return "Add " + person.getName();
    }

    @Override
    public String deleteById(Long id) {
        Person person = personRepository.findById(id);
        personRepository.deleteById(id);
        return "Delete " + person.getName();
    }

    @Override
    public String update(Long id, Person person) {
        Person p = personRepository.findById(id);
        p.setName(person.getName());
        p.setSurname(person.getSurname());
        p.setAge(person.getAge());
        p.setPhone(person.getPhone());
        return "Update " + person.getName();
    }
}
