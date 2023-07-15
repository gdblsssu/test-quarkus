package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.PersonDTO;
import org.acme.service.AddPersonCar;

@ApplicationScoped
public class AddPersonCarImpl implements AddPersonCar {
    @Override
    public void add(PersonDTO personDTO) {

    }
   /* @Inject
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
    }*/
}
