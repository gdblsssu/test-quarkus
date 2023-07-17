package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CarDTO;
import org.acme.service.controllerlayer.CarControllerService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarController {

    @Inject
    CarControllerService carControllerService;

    @GET
    @Counted(name = "performedGetAllCars", description = "How many requests were made for the list of cars")
    @Timed(name = "getAllCarsTimer", description = "A measure of how long it takes to get a list of cars", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Get list of cars", description = "Lists all available cars")
    @APIResponse(
            responseCode = "200",
            description = "List of cars.",
            content = @Content(mediaType = "application/json"))
    public Response getAll(){
        return Response.ok(carControllerService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    @Counted(name = "performedGetByIdCar", description = "How many requests were completed for a particular car.")
    @Timed(name = "getByIdCarTimer", description = "A measure of the time required for a particular car.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Get car by id", description = "Available car")
    @APIResponse(
            responseCode = "200",
            description = "Found car",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarDTO.class)))
    public Response getById(
            @Parameter(description = "The ID that is needed to search for a car.", required = true)
            @PathParam("id") Long id
    ){
        return Response.ok(carControllerService.getById(id)).build();
    }

    @GET
    @Path("/statistic-color")
    @Counted(name = "performedGetStatisticsColor", description = "How many requests were made to find out the statistics on car colors.")
    @Timed(name = "getStatisticsColorTimer", description = "A measure of the time required for the statistics on car colors.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Get statistics on car colors", description = "Statistics on car colors")
    @APIResponse(
            responseCode = "200",
            description = "Statistics on car colors",
            content = @Content(mediaType = "application/json"))
    public Response getStatisticsColor(){
        return Response.ok(carControllerService.getStatisticsColor()).build();
    }

    @POST
    @Transactional
    @Counted(name = "performedAddCar", description = "How many car have been added.")
    @Timed(name = "addCarTimer", description = "A measure of how long it takes to add a car.", unit = MetricUnits.MILLISECONDS)
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
    ){
        carControllerService.add(carDTO);
        return Response.status(Response.Status.CREATED).entity(carControllerService.getAll()).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Counted(name = "performedDeleteCar", description = "How many car have been deleted.")
    @Timed(name = "deleteCarTimer", description = "A measure of how long it takes to delete a car.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Delete available car", description = "Delete available car")
    @APIResponse(
            responseCode = "204",
            description = "Car is deleted"
    )
    public Response delete(
            @Parameter(description = "Id required for deletion", required = true)
            @PathParam("id") Long id
    ){
        carControllerService.delete(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Counted(name = "performedUpdateCar", description = "How many car have been updated.")
    @Timed(name = "updateCarTimer", description = "A measure of how long it takes to update a car.", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "Update available car", description = "Update available car")
    @APIResponse(
            responseCode = "200",
            description = "Updated car",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarDTO.class)))
    public Response update(
            @Parameter(description = "ID needed to find the car to be updated", required = true)
            @PathParam("id") Long id,
            @RequestBody(
                    description = "Car with data to update",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CarDTO.class))
            )
            @Valid
            CarDTO carDTO
    ){
        carControllerService.update(id, carDTO);
        return Response.ok(carControllerService.getById(id)).build();
    }
}
