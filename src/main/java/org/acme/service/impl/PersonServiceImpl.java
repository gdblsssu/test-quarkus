package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
        return PersonMapper.INSTANCE.toListDTO(personRepository.findAll().list());
    }

    @Override
    public PersonDTO getById(Long id) {
        Person personFromDTO = personRepository.findById(id);
        return PersonMapper.INSTANCE.toDTO(personFromDTO);
    }

    @Override
    public void add(PersonDTO personDTO) {
        Person person = PersonMapper.INSTANCE.toEntity(personDTO);
        personRepository.persist(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void update(Long id, PersonDTO personDTO) {
        Person personFromDTO = PersonMapper.INSTANCE.toEntity(personDTO);
        Person existingPerson = personRepository.findById(id);
        existingPerson.setName(personFromDTO.getName());
        existingPerson.setSurname(personFromDTO.getSurname());
        existingPerson.setAge(personFromDTO.getAge());
        existingPerson.setPhone(personFromDTO.getPhone());
    }
}
