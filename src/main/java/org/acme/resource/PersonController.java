package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.PersonDTO;
import org.acme.service.controllerlayer.PersonControllerService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

    @Inject
    PersonControllerService personControllerService;

    @GET
    @Counted(name = "performedGetAllPersons", description = "How many requests were made for the list of persons")
    @Timed(name = "getAllPersonTimer", description = "A measure of how long it takes to get a list of persons", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Get list of person", description = "Lists all available persons")
    @APIResponse(
            responseCode = "200",
            description = "List of persons.",
            content = @Content(mediaType = "application/json"))
    public Response getAll(){
        return Response.ok(personControllerService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    @Counted(name = "performedGetByIdPerson", description = "How many requests were completed for a particular person.")
    @Timed(name = "getByIdPersonTimer", description = "A measure of the time required for a particular person.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Get person by id", description = "Available person")
    @APIResponse(
            responseCode = "200",
            description = "The person",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class)))
    public Response getById(
            @Parameter(description = "The id that needs to be fetched", required = true)
            @PathParam("id") Long id
    ){
        return Response.ok(personControllerService.getById(id)).build();
    }

    @POST
    @Transactional
    @Counted(name = "performedAddPerson", description = "How many person have been added.")
    @Timed(name = "addPersonTimer", description = "A measure of how long it takes to add a person.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Add new person", description = "Add new person")
    @APIResponse(
            responseCode = "201",
            description = "Person is added",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class)))
    public Response add(
            @Valid
            @Parameter(description = "Person to add", required = true)
            PersonDTO personDTO){
        personControllerService.add(personDTO);
        return Response.ok(Response.status(Response.Status.CREATED)).entity(personControllerService.getAll()).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Counted(name = "performedDeletePerson", description = "How many person have been deleted.")
    @Timed(name = "deletePersonTimer", description = "A measure of how long it takes to delete a person.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Delete available person", description = "Delete available person")
    @APIResponse(
            responseCode = "204",
            description = "Person is deleted",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class)))
    public Response delete(
            @Parameter(description = "Id required for deletion", required = true)
            @PathParam("id") Long id
    ){
        personControllerService.deleteById(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Counted(name = "performedUpdatePerson", description = "How many person have been updated.")
    @Timed(name = "updatePersonTimer", description = "A measure of how long it takes to update a person.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Update available person", description = "Update available person")
    @APIResponse(
            responseCode = "200",
            description = "Person is updated.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class)))
    public Response update(
            @Parameter(description = "ID needed to find the person to be updated", required = true)
            @PathParam("id") Long id,
            @Valid
            @Parameter(description = "Person with data to update", required = true)
            PersonDTO personDTO
    ){
        personControllerService.update(id, personDTO);
        return Response.ok(personControllerService.getById(id)).build();
    }
}
