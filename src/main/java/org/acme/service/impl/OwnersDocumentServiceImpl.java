package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.OwnersDocument;
import org.acme.repository.OwnersDocumentRepository;
import org.acme.service.OwnersDocumentService;

import java.util.List;

@ApplicationScoped
public class OwnersDocumentServiceImpl implements OwnersDocumentService {

    @Inject
    OwnersDocumentRepository ownersDocumentRepository;

    @Override
    public List<OwnersDocument> getAll() {
        return ownersDocumentRepository.findAll().list();
    }

    @Override
    public OwnersDocument getById(Long id) {
        return ownersDocumentRepository.findById(id);
    }

    @Override
    public void add(OwnersDocument ownersDocument) {
        ownersDocumentRepository.persist(ownersDocument);
    }

    @Override
    public void deleteById(Long id) {
        ownersDocumentRepository.deleteById(id);
    }

    @Override
    public void update(Long id, OwnersDocument ownersDocument) {
        OwnersDocument ownersDocumentOld = ownersDocumentRepository.findById(id);
        ownersDocumentOld.setCar(ownersDocument.getCar());
        ownersDocumentOld.setNote(ownersDocument.getNote());
        ownersDocumentOld.setPerson(ownersDocument.getPerson());
    }
}
