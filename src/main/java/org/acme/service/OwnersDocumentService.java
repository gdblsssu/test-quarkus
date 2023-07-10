package org.acme.service;

import org.acme.entity.OwnersDocument;

import java.util.List;

public interface OwnersDocumentService {
    public List<OwnersDocument> getAll();
    public OwnersDocument getById(Long id);
    public String add(OwnersDocument ownersDocument);
    public String deleteById(Long id);
    public String update(Long id, OwnersDocument ownersDocument);
}
