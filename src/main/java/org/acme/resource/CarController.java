package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.entity.Car;
import org.acme.service.CarService;

import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarController {

    @Inject
    CarService carService;

    @GET
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GET
    @Path("/{id}")
    public Car getById(
            @PathParam("id") Long id
    ){
        return carService.getById(id);
    }

    @POST
    @Transactional
    public List<Car> add(
            Car car
    ){
        carService.add(car);
        return carService.getAll();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void delete(
            @PathParam("id") Long id
    ){
        carService.delete(id);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void update(
            @PathParam("id") Long id,
            Car car
    ){
        carService.update(id, car);
    }
}
