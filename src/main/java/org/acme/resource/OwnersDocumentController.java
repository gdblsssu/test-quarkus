package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.OwnersDocumentDTO;
import org.acme.entity.OwnersDocument;
import org.acme.entity.Person;
import org.acme.service.OwnersDocumentService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;


@Path("/ownersdocument")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OwnersDocumentController {

    @Inject
    OwnersDocumentService ownersDocumentService;

    @GET
    @Counted(name = "performedGetAllOwnersDocument", description = "How many times was the list of documents about ownership received.")
    @Timed(name = "getAllOwnersDocumentTimer", description = "A measure of how long it takes to get the list of owner's document.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Get list of owner's documents", description = "Lists all available owner's documents")
    @APIResponse(
            responseCode = "200",
            description = "List of owner's documents",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)))
    public Response getAll(){
        return Response.ok(ownersDocumentService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    @Counted(name = "performedGetByIdOwnersDocument", description = "How many times was the owner's document received.")
    @Timed(name = "getByIdOwnersDocumentTimer", description = "A measure of how long it takes to get a owner's document.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Get owner's document by id", description = "Available owner's document")
    @APIResponse(
            responseCode = "200",
            description = "The person.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)))
    public Response getById(
            @Parameter(description = "The id that needs to be fetched", required = true)
            @PathParam("id") Long id
    ){
        return Response.ok(ownersDocumentService.getById(id)).build();
    }

    @POST
    @Transactional
    @Counted(name = "performedAddOwnersDocument", description = "How many owner's document have been added.")
    @Timed(name = "addOwnersDocumentTimer", description = "A measure of how long it takes to add a owner's document.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Add new owner's document", description = "Add new owner's document")
    @APIResponse(
            responseCode = "200",
            description = "Owner's document is added.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)))
    public Response add(
            @Parameter(description = "Owner's document to add", required = true)
            OwnersDocumentDTO ownersDocumentDTO
    ){
        ownersDocumentService.add(ownersDocumentDTO);
        return Response.status(Response.Status.CREATED)
                .entity(ownersDocumentService.getAll()).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Counted(name = "performedDeleteOwnersDocument", description = "How many owner's document have been deleted.")
    @Timed(name = "deleteOwnersDocumentTimer", description = "A measure of how long it takes to delete a owner's document.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Delete available owner's document", description = "Delete available owner's document")
    @APIResponse(
            responseCode = "204",
            description = "Owner's document is deleted",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)))
    public Response delete(
            @Parameter(description = "Id required for deletion", required = true)
            @PathParam("id") Long id
    ){
        ownersDocumentService.deleteById(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Counted(name = "performedUpdateOwnersDocument", description = "How many owner's document have been updated.")
    @Timed(name = "updateOwnersDocumentTimer", description = "A measure of how long it takes to update a owner's document.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Update available owner's document", description = "Update available owner's document")
    @APIResponse(
            responseCode = "200",
            description = "Owner's document is updated.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)))
    public Response update(
            @Parameter(description = "ID needed to find the owner's document to be updated", required = true)
            @PathParam("id") Long id,
            @Parameter(description = "Owner's document with data to update", required = true)
            OwnersDocumentDTO ownersDocumentDTO
    ){
        ownersDocumentService.update(id, ownersDocumentDTO);
        return Response.ok(ownersDocumentService.getAll()).build();
    }
}
