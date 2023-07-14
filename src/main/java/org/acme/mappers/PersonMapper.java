package org.acme.mappers;

import org.acme.dto.PersonDTO;
import org.acme.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = "jakarta",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {

    PersonDTO toDTO(Person person);
    List<PersonDTO> toListDTO(List<Person> personList);
    Person toEntity(PersonDTO personDTO);
}
