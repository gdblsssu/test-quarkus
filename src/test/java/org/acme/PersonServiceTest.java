package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acme.dto.PersonDTO;
import org.acme.entity.Car;
import org.acme.entity.Person;
import org.acme.service.logiclayer.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@QuarkusTest
public class PersonServiceTest {
    @Inject
    PersonService personService;

    @Test
    public void testAddPerson(){
        Person John = new Person();
        John.setName("John");
        John.setSurname("John");
        John.setAge(33);
        John.setPhone("4512353");
        personService.add(John);
        List<Person> personList = personService.getAll();
        Assertions.assertEquals("John", personList.get(personList.size() - 1).getName());
        Assertions.assertEquals(33, personList.get(personList.size() - 1).getAge());

        Person Alice = new Person();
        Alice.setName("Alice");
        Alice.setSurname("Alice");
        Alice.setAge(31);
        Alice.setPhone("252352");
        personService.add(Alice);
        personList = personService.getAll();
        Assertions.assertEquals("Alice", personList.get(personList.size() - 1).getName());
        Assertions.assertEquals(31, personList.get(personList.size() - 1).getAge());
    }

    @Test
    public void testDeletePerson(){
        List<Person> personList = personService.getAll();
        int beforeDelete = personList.size();
        Long lastId = personList.get(personList.size() - 1).getId();
        personService.deleteById(lastId);
        personList = personService.getAll();
        int afterDelete = personList.size();
        Assertions.assertNotEquals(afterDelete, beforeDelete);


    }
    @Test
    public void testUpdatePerson(){
        Person person = personService.getById(1L);
        Assertions.assertEquals("testuser1.1", person.getName());
        Assertions.assertEquals(31, person.getAge());

        person.setAge(36);
        personService.update(1L, person);
        Assertions.assertEquals("testuser1.1", person.getName());
        Assertions.assertEquals(36, person.getAge());
    }
    @Test
    public void testGetPersonById(){
        Person person = personService.getById(1L);
        Assertions.assertEquals("testuser1.1", person.getName());
        Assertions.assertEquals("testuser1.1", person.getSurname());
        Assertions.assertEquals(31, person.getAge());
        Assertions.assertEquals("54", person.getPhone());
    }


}
