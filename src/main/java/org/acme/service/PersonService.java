package org.acme.service;

import org.acme.entity.Person;

import java.util.List;


public interface PersonService {

    public List<Person> getAll();
    public Person getById(Long id);
    public String add(Person person);
    public String deleteById(Long id);
    public String update(Long id, Person person);
}
