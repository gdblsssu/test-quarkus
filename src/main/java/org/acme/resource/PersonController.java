package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.entity.Person;
import org.acme.service.PersonService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

    @Inject
    PersonService personService;

    @GET
    @Counted(name = "performedGetAllPersons", description = "How many requests were made for the list of persons.")
    @Timed(name = "getAllPersonTimer", description = "A measure of how long it takes to get a list of persons.", unit = MetricUnits.MILLISECONDS)
    public List<Person> getAll(){
        return personService.getAll();
    }

    @GET
    @Path("/{id}")
    @Counted(name = "performedGetByIdPerson", description = "How many requests were completed for a particular person.")
    @Timed(name = "getByIdPersonTimer", description = "A measure of the time required for a particular person.", unit = MetricUnits.MILLISECONDS)
    public Person getById(
            @PathParam("id") Long id
    ){
        return personService.getById(id);
    }

    @POST
    @Transactional
    @Counted(name = "performedAddPerson", description = "How many person have been added.")
    @Timed(name = "addPersonTimer", description = "A measure of how long it takes to add a person.", unit = MetricUnits.MILLISECONDS)
    public String add(Person person){
        return personService.add(person);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Counted(name = "performedDeletePerson", description = "How many person have been deleted.")
    @Timed(name = "deletePersonTimer", description = "A measure of how long it takes to delete a person.", unit = MetricUnits.MILLISECONDS)
    public String delete(
            @PathParam("id") Long id
    ){
        return personService.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Counted(name = "performedUpdatePerson", description = "How many person have been updated.")
    @Timed(name = "updatePersonTimer", description = "A measure of how long it takes to update a person.", unit = MetricUnits.MILLISECONDS)
    public String update(
            @PathParam("id") Long id,
            Person person
    ){
        return personService.update(id, person);
    }
}
