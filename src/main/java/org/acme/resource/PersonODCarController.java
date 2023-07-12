package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.PersonDTO;
import org.acme.service.PersonODCarService;
import org.acme.service.PersonService;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

@Path("/add_person_od_car")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonODCarController {

    @Inject
    PersonODCarService personODCarService;
    @POST
    @Transactional
    public Response add(
            PersonDTO personDTO){
        System.out.println("Person __________________________________ name:" + personDTO.getName());
        personODCarService.add(personDTO);
        return Response.ok().build();
    }
}
