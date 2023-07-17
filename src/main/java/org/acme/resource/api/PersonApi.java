package org.acme.resource.api;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.dto.PersonDTO;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/persons")
@Tag(name = "Person Resource", description = "Person REST APIs")
public interface PersonApi {
    @GET
    @Operation(summary = "Get list of person", description = "Lists all available persons")
    @APIResponse(
            responseCode = "200",
            description = "List of persons.",
            content = @Content(mediaType = "application/json"))
    public Response getAll();

    @GET
    @Path("/{id}")
    @Operation(summary = "Get person by id", description = "Available person")
    @APIResponse(
            responseCode = "200",
            description = "The person",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class)))
    public Response getById(
            @Parameter(description = "The id that needs to be fetched", required = true)
            @PathParam("id") Long id
    );

    @POST
    @Operation(summary = "Add new person", description = "Add new person")
    @APIResponse(
            responseCode = "201",
            description = "Person is added"
    )
    public Response add(
            @Valid
            @RequestBody(
                    description = "Person to add",
                    required = true,
                    content = @Content(schema = @Schema(implementation = PersonDTO.class))
            )
            PersonDTO personDTO);

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete available person", description = "Delete available person")
    @APIResponse(
            responseCode = "204",
            description = "Person is deleted"
    )
    public Response delete(
            @Parameter(description = "Id required for deletion", required = true)
            @PathParam("id") Long id
    );

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update available person", description = "Update available person")
    @APIResponse(
            responseCode = "200",
            description = "Updated person",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class)))
    public Response update(
            @Parameter(description = "ID needed to find the person to be updated", required = true)
            @PathParam("id") Long id,
            @Valid
            @RequestBody(
                    description = "Person with data to update",
                    required = true,
                    content = @Content(schema = @Schema(implementation = PersonDTO.class))
            )
            PersonDTO personDTO
    );
}
