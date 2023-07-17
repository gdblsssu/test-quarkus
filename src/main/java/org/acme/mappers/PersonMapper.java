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
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {CarMapper.class})
public interface PersonMapper {

    @Mapping(target = "carDTOSet", source = "carSet")
    PersonDTO toDTO(Person person);
    @Mapping(target = "carSet", source = "carDTOSet")
    Person toEntity(PersonDTO personDTO);
    List<PersonDTO> toListDTO(List<Person> personList);
    List<Person> toListEntity(List<PersonDTO> personList);

}
