package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.OwnersDocumentDTO;
import org.acme.dto.PersonDTO;
import org.acme.entity.Car;
import org.acme.entity.OwnersDocument;
import org.acme.entity.Person;
import org.acme.mappers.OwnersDocumentMapper;
import org.acme.mappers.PersonMapper;
import org.acme.repository.CarRepository;
import org.acme.repository.OwnersDocumentRepository;
import org.acme.repository.PersonRepository;
import org.acme.service.PersonODCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class PersonODCarServiceImpl implements PersonODCarService {
    @Inject
    PersonRepository personRepository;
    @Inject
    CarRepository carRepository;
    @Inject
    OwnersDocumentRepository ownersDocumentRepository;
    @Inject
    PersonMapper personMapper;
    @Inject
    OwnersDocumentMapper ownersDocumentMapper;

    @Override
    public void add(PersonDTO personDTO) {
        Set<OwnersDocumentDTO> ownersDocumentsDTO = personDTO.getOwnersDocuments();
        Set<OwnersDocument> ownersDocuments = new HashSet<>();
        for (OwnersDocumentDTO ownersDocumentDTO: ownersDocumentsDTO) {
            OwnersDocument ownersDocument = ownersDocumentMapper.toEntity(ownersDocumentDTO);
            ownersDocuments.add(ownersDocument);
        }
        Person person = personMapper.toEntity(personDTO);
        for(OwnersDocument ownersDocument: ownersDocuments){
            Car car = ownersDocument.getCar();
            carRepository.persist(car);
            ownersDocument.setPerson(person);
            ownersDocument.setCar(car);
            person.addOwnersDocument(ownersDocument);
            ownersDocumentRepository.persist(ownersDocument);
        }
    }
}
