package org.acme.health;

import jakarta.inject.Inject;
import org.acme.entity.Person;
import org.acme.repository.PersonRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class PersonCheckById implements HealthCheck {
    @Inject
    PersonRepository personRepository;
    @ConfigProperty(name = "person.check.id", defaultValue = "123")
    Long personId;

    @Override
    public HealthCheckResponse call() {

        Person existingPerson = personRepository.findById(personId);

        if (existingPerson != null) {
            return HealthCheckResponse.named("Person Check with id = " + personId).up().build();
        } else {
            return HealthCheckResponse.named("Person Check with id = " + personId).down().build();
        }
    }
}
