package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.Person;
import org.acme.repository.PersonRepository;
import org.acme.service.MassProcessingPersonService;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class MassProcessingPersonServiceImpl implements MassProcessingPersonService {

    @Inject
    PersonRepository personRepository;

    @Override
    public void add(int count) {
        for (int i = 0; i < count; i++) {
            Person person = new Person();
            person.setName("testusername#" + i);
            person.setSurname("testusersurname#" + i);
            person.setAge(25);
            person.setPhone("89234" + i);
         //   person.setOwnersDocuments(new HashSet<>());
            personRepository.persist(person);
        }
    }

    @Override
    public void updateAllAddYear() {
        List<Person> personList = personRepository.findAll().list();
        for(Person person: personList){
            if(person.getAge() < 109){
                person.setAge(person.getAge() + 1);
            }
        }
    }
}
