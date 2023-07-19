package org.acme.resource.core;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CarDTO;
import org.acme.resource.api.CarApi;
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

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarController implements CarApi {

    @Inject
    CarControllerService carControllerService;


    @Counted(name = "performedGetAllCars", description = "How many requests were made for the list of cars")
    @Timed(name = "getAllCarsTimer", description = "A measure of how long it takes to get a list of cars", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response getAll(){
        return Response.ok(carControllerService.getAll()).build();
    }

    @Counted(name = "performedGetByIdCar", description = "How many requests were completed for a particular car.")
    @Timed(name = "getByIdCarTimer", description = "A measure of the time required for a particular car.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response getById(
            @PathParam("id") Long id
    ){
        return Response.ok(carControllerService.getById(id)).build();
    }

    @Counted(name = "performedGetStatisticsColor", description = "How many requests were made to find out the statistics on car colors.")
    @Timed(name = "getStatisticsColorTimer", description = "A measure of the time required for the statistics on car colors.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response getStatisticsColor(){
        return Response.ok(carControllerService.getStatisticsColor()).build();
    }

    @Transactional
    @Counted(name = "performedAddCar", description = "How many car have been added.")
    @Timed(name = "addCarTimer", description = "A measure of how long it takes to add a car.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response add(
            @Valid
            CarDTO carDTO
    ){
        carControllerService.add(carDTO);
        return Response.status(Response.Status.CREATED).entity(carControllerService.getAll()).build();
    }

    @Transactional
    @Counted(name = "performedDeleteCar", description = "How many car have been deleted.")
    @Timed(name = "deleteCarTimer", description = "A measure of how long it takes to delete a car.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response delete(
            @PathParam("id") Long id
    ){
        carControllerService.delete(id);
        return Response.noContent().build();
    }


    @Transactional
    @Counted(name = "performedUpdateCar", description = "How many car have been updated.")
    @Timed(name = "updateCarTimer", description = "A measure of how long it takes to update a car.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response update(
            @PathParam("id") Long id,
            @Valid
            CarDTO carDTO
    ){
        carControllerService.update(id, carDTO);
        return Response.ok(carControllerService.getById(id)).build();
    }
}
