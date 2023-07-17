package org.acme.resource.api;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CarDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/cars")
@Tag(name = "Car Resource", description = "Car REST APIs")
public interface CarApi {
    @GET
    @Operation(summary = "Get list of cars", description = "Lists all available cars")
    @APIResponse(
            responseCode = "200",
            description = "List of cars.",
            content = @Content(mediaType = "application/json"))
    Response getAll();

    @GET
    @Path("/{id}")
    @Operation(summary = "Get car by id", description = "Available car")
    @APIResponse(
            responseCode = "200",
            description = "Found car",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarDTO.class)))
    Response getById(
            @Parameter(description = "The ID that is needed to search for a car.", required = true)
            @PathParam("id") Long id
    );

    @GET
    @Path("/statistic-color")
    @Operation(summary = "Get statistics on car colors", description = "Statistics on car colors")
    @APIResponse(
            responseCode = "200",
            description = "Statistics on car colors",
            content = @Content(mediaType = "application/json"))
    Response getStatisticsColor();

    @POST
    @Operation(summary = "Add new car", description = "Add new car")
    @APIResponse(
            responseCode = "201",
            description = "Car is added"
    )
    public Response add(
            @RequestBody(
                    description = "Car to add",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CarDTO.class))
            )
            @Valid
            CarDTO carDTO
    );

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete available car", description = "Delete available car")
    @APIResponse(
            responseCode = "204",
            description = "Car is deleted"
    )
    public Response delete(
            @Parameter(description = "Id required for deletion", required = true)
            @PathParam("id") Long id
    );

    @PUT
    @Path("{id}")
    @Operation(summary = "Update available car", description = "Update available car")
    @APIResponse(
            responseCode = "200",
            description = "Updated car",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarDTO.class)))
    Response update(
            @Parameter(description = "ID needed to find the car to be updated", required = true)
            @PathParam("id") Long id,
            @RequestBody(
                    description = "Car with data to update",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CarDTO.class))
            )
            @Valid
            CarDTO carDTO
    );
}
