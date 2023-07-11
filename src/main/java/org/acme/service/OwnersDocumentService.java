package org.acme.service;

import org.acme.entity.OwnersDocument;

import java.util.List;

public interface OwnersDocumentService {
    public List<OwnersDocument> getAll();
    public OwnersDocument getById(Long id);
    public void add(OwnersDocument ownersDocument);
    public void deleteById(Long id);
    public void update(Long id, OwnersDocument ownersDocument);
}
