package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Person;

import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
}
