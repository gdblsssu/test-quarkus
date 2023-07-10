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
    public String add(OwnersDocument ownersDocument) {
        ownersDocumentRepository.persist(ownersDocument);
        return "Added owners document: " + " - " + ownersDocument.getCar().getName();
    }

    @Override
    public String deleteById(Long id) {
        OwnersDocument ownersDocument = ownersDocumentRepository.findById(id);
        ownersDocumentRepository.deleteById(id);
        return "Deleted owners document: " + ownersDocument.getPerson().getName() + " - " + ownersDocument.getCar().getName();
    }

    @Override
    public String update(Long id, OwnersDocument ownersDocument) {
        OwnersDocument ownersDocumentOld = ownersDocumentRepository.findById(id);
        ownersDocumentOld.setCar(ownersDocument.getCar());
        ownersDocumentOld.setNote(ownersDocument.getNote());
        ownersDocumentOld.setPerson(ownersDocument.getPerson());
        return "Updated owners document: " + ownersDocument.getPerson().getName() + " - " + ownersDocument.getCar().getName();
    }
}
