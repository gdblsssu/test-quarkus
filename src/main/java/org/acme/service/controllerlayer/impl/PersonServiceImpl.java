package org.acme.service.controllerlayer.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.acme.dto.PersonDTO;
import org.acme.entity.Person;
import org.acme.mappers.PersonMapper;
import org.acme.repository.PersonRepository;
import org.acme.service.controllerlayer.PersonService;

import java.util.List;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {

    @Inject
    PersonRepository personRepository;
    @Inject
    PersonMapper personMapper;

    @Override
    public List<PersonDTO> getAll() {
        List<Person> personList = personRepository.findAll().list();
        if(personList.isEmpty()){
            throw new NotFoundException();        }
        return personMapper.toListDTO(personList);
    }

    @Override
    public PersonDTO getById(Long id) {
        Person existingPerson = personRepository.findById(id);
        if(existingPerson == null){
            throw new NotFoundException();        }
        return personMapper.toDTO(existingPerson);
    }

    @Override
    public void add(PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
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
        Person personFromDTO = personMapper.toEntity(personDTO);
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
