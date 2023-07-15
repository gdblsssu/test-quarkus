package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.PersonDTO;
import org.acme.service.AddPersonCar;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/add_person_od_car")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonODCarController {

    @Inject
    AddPersonCar personODCarService;
    @POST
    @Transactional
    @Counted(name = "performedAddPersonODCar", description = "How many person, od, car have been added.")
    @Timed(name = "addPersonODCarTimer", description = "A measure of how long it takes to add the person, od, car.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Add new person, document, car", description = "Add new person, document, ca")
    @APIResponse(
            responseCode = "200",
            description = "Person, OD, Car is added",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class)))

    public Response add(
            @Parameter(description = "Person to add", required = true)
            PersonDTO personDTO){
        personODCarService.add(personDTO);
        return Response.ok(Response.Status.CREATED).build();
    }
}
