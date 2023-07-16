package org.acme.service.logiclayer;

import org.acme.entity.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getAll();
    public Person getById(Long id);
    public void add(Person person);
    public void deleteById(Long id);
    public void update(Long id, Person person);
}
