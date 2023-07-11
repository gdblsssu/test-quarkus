package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
        return OwnersDocumentMapper.INSTANCE.toListDTO(ownersDocumentList);
    }

    @Override
    public OwnersDocumentDTO getById(Long id) {
        OwnersDocument existingOwnersDocument = ownersDocumentRepository.findById(id);
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
        ownersDocumentRepository.deleteById(id);
    }

    @Override
    public void update(Long id, OwnersDocumentDTO ownersDocumentDTO) {
        OwnersDocument ownersDocumentFromDTO = OwnersDocumentMapper
                .INSTANCE.toEntity(ownersDocumentDTO);
        OwnersDocument existingOwnersDocument = ownersDocumentRepository.findById(id);
        existingOwnersDocument.setCar(ownersDocumentFromDTO.getCar());
        existingOwnersDocument.setNote(ownersDocumentFromDTO.getNote());
        existingOwnersDocument.setPerson(ownersDocumentFromDTO.getPerson());
    }
}
