package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CarDTO;
import org.acme.dto.PersonDTO;
import org.acme.service.controllerlayer.AddPersonCarService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/personcars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddPersonCarController {

    @Inject
    AddPersonCarService addPersonCarService;

    @POST
    @Transactional
    @Counted(name = "performedAddPersonAndCar", description = "How many person and car have been added.")
    @Timed(name = "addCarTimer", description = "A measure of how long it takes to add the person and car.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Add new person and car", description = "Add new person and car")
    @APIResponse(
            responseCode = "201",
            description = "Person and car is added",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarDTO.class)))
    public Response add(
            @Parameter(description = "Person and car to add", required = true)
            PersonDTO personDTO
    ){
        addPersonCarService.add(personDTO);
        return Response.status(Response.Status.CREATED).build();
    }
}
