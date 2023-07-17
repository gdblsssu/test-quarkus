package org.acme.service.logiclayer;

import org.acme.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();
    Person getById(Long id);
    void add(Person person);
    void deleteById(Long id);
    void update(Long id, Person person);
}
