package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acme.dto.PersonDTO;
import org.acme.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class PersonServiceTest {
    /*@Inject
    PersonService personService;
    @Test
    public void testGetPersonByIdEndpoint(){
        PersonDTO personDTO = personService.getById(1L);
        Assertions.assertEquals("testuser1", personDTO.getName());
        Assertions.assertEquals("testuser1", personDTO.getSurname());
        Assertions.assertEquals(21, personDTO.getAge());
        Assertions.assertEquals("21", personDTO.getPhone());
    }

     */
}
