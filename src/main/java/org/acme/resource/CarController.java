package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.CarDTO;
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
    public List<CarDTO> getAll(){
        return carService.getAll();
    }

    @GET
    @Path("/{id}")
    public CarDTO getById(
            @PathParam("id") Long id
    ){
        return carService.getById(id);
    }

    @POST
    @Transactional
    public List<CarDTO> add(
            CarDTO carDTO
    ){
        carService.add(carDTO);
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
            CarDTO carDTO
    ){
        carService.update(id, carDTO);
    }
}
