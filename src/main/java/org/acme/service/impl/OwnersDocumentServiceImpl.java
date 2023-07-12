package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.acme.dto.OwnersDocumentDTO;
import org.acme.entity.OwnersDocument;
import org.acme.mappers.OwnersDocumentMapper;
import org.acme.repository.OwnersDocumentRepository;
import org.acme.service.OwnersDocumentService;

import java.util.List;

@ApplicationScoped
public class OwnersDocumentServiceImpl implements OwnersDocumentService {

    @Inject
    OwnersDocumentRepository ownersDocumentRepository;

    @Override
    public List<OwnersDocumentDTO> getAll() {
        List<OwnersDocument> ownersDocumentList = ownersDocumentRepository.findAll().list();
        if(ownersDocumentList.isEmpty()){
            throw new NotFoundException();
        }
        return OwnersDocumentMapper.INSTANCE.toListDTO(ownersDocumentList);
    }

    @Override
    public OwnersDocumentDTO getById(Long id) {
        OwnersDocument existingOwnersDocument = ownersDocumentRepository.findById(id);
        if(existingOwnersDocument == null){
            throw new NotFoundException();
        }
        return OwnersDocumentMapper.INSTANCE.toDTO(existingOwnersDocument);
    }

    @Override
    public void add(OwnersDocumentDTO ownersDocumentDTO) {
        OwnersDocument ownersDocumentFromDTO = OwnersDocumentMapper
                .INSTANCE.toEntity(ownersDocumentDTO);
        ownersDocumentRepository.persist(ownersDocumentFromDTO);
    }

    @Override
    public void deleteById(Long id) {
        OwnersDocument existingOwnersDocument = ownersDocumentRepository.findById(id);
        if(existingOwnersDocument == null){
            throw new NotFoundException();
        }
        ownersDocumentRepository.deleteById(id);
    }

    @Override
    public void update(Long id, OwnersDocumentDTO ownersDocumentDTO) {
        OwnersDocument ownersDocumentFromDTO = OwnersDocumentMapper
                .INSTANCE.toEntity(ownersDocumentDTO);
        OwnersDocument existingOwnersDocument = ownersDocumentRepository.findById(id);
        if(existingOwnersDocument == null){
            throw new NotFoundException();
        }
        existingOwnersDocument.setCar(ownersDocumentFromDTO.getCar());
        existingOwnersDocument.setNote(ownersDocumentFromDTO.getNote());
        existingOwnersDocument.setPerson(ownersDocumentFromDTO.getPerson());
    }
}
