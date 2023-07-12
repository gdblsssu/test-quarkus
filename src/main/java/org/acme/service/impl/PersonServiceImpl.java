package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.acme.dto.PersonDTO;
import org.acme.entity.Person;
import org.acme.mappers.PersonMapper;
import org.acme.repository.PersonRepository;
import org.acme.service.PersonService;

import java.util.List;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {

    @Inject
    PersonRepository personRepository;


    @Override
    public List<PersonDTO> getAll() {
        List<Person> personList = personRepository.findAll().list();
        if(personList.isEmpty()){
            throw new NotFoundException();        }
        return PersonMapper.INSTANCE.toListDTO(personList);
    }

    @Override
    public PersonDTO getById(Long id) {
        Person existingPerson = personRepository.findById(id);
        if(existingPerson == null){
            throw new NotFoundException();        }
        return PersonMapper.INSTANCE.toDTO(existingPerson);
    }

    @Override
    public void add(PersonDTO personDTO) {
        Person person = PersonMapper.INSTANCE.toEntity(personDTO);
        personRepository.persist(person);
    }

    @Override
    public void deleteById(Long id) {
        Person existingPerson = personRepository.findById(id);
        if(existingPerson == null){
            throw new NotFoundException();        }
        personRepository.deleteById(id);
    }

    @Override
    public void update(Long id, PersonDTO personDTO) {
        Person personFromDTO = PersonMapper.INSTANCE.toEntity(personDTO);
        Person existingPerson = personRepository.findById(id);
        if(existingPerson == null){
            throw new NotFoundException();
        }
        existingPerson.setName(personFromDTO.getName());
        existingPerson.setSurname(personFromDTO.getSurname());
        existingPerson.setAge(personFromDTO.getAge());
        existingPerson.setPhone(personFromDTO.getPhone());
    }
}
