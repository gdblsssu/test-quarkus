package org.acme.service.controllerlayer;

import org.acme.dto.PersonDTO;

import java.util.List;


public interface PersonService {

    public List<PersonDTO> getAll();
    public PersonDTO getById(Long id);
    public void add(PersonDTO personDTO);
    public void deleteById(Long id);
    public void update(Long id, PersonDTO personDTO);
}
