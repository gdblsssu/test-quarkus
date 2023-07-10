package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.OwnersDocument;

@ApplicationScoped
public class OwnersDocumentRepository implements PanacheRepository<OwnersDocument> {
}
