package org.acme.service;

import org.acme.dto.OwnersDocumentDTO;
import org.acme.entity.OwnersDocument;

import java.util.List;

public interface OwnersDocumentService {
    public List<OwnersDocumentDTO> getAll();
    public OwnersDocumentDTO getById(Long id);
    public void add(OwnersDocumentDTO ownersDocument);
    public void deleteById(Long id);
    public void update(Long id, OwnersDocumentDTO ownersDocument);
}
