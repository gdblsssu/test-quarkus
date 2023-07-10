package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.service.CarService;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarController {

   /* @Inject
    CarService carService; //  Unsatisfied dependency*/

   /* @GET
    public List<Car> getAllCars() {
        return carService.getAll();
    }

    @GET
    @Path("{id}")
    public Car getById(
            @PathParam("id") Long id
    ) {
        return carService.getById(id);
    }

    @POST
    @Transactional
    public String addCar(Car car) {
        return carService.add(car);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public String deleteCar(
            @PathParam("id") Long id
    ) {
        return carService.deleteById(id);
    }

    @PUT
    @Path("id")
    @Transactional
    public String updateCar(
            @PathParam("id") Long id,
            Car car
    ) {
        return carService.update(id, car);
    }*/
}
