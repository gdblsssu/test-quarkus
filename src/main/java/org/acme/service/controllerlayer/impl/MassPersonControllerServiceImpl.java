package org.acme.service.controllerlayer.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.Person;
import org.acme.repository.PersonRepository;
import org.acme.service.controllerlayer.MassPersonControllerService;
import org.acme.service.logiclayer.MassPersonService;

import java.util.HashSet;
import java.util.List;

@ApplicationScoped
public class MassPersonControllerServiceImpl implements MassPersonControllerService {

    @Inject
    MassPersonService massPersonService;

    @Override
    public void add(int count) {
        massPersonService.add(count);
    }

    @Override
    public void updateAllAddYear() {
        massPersonService.updateAllAddYear();
    }
}
