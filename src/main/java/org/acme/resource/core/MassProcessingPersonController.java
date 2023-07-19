package org.acme.resource.core;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.service.controllerlayer.MassPersonControllerService;
import org.acme.service.controllerlayer.PersonControllerService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MassProcessingPersonController {

    @Inject
    MassPersonControllerService massPersonControllerService;
    @Inject
    PersonControllerService personControllerService;


    @Transactional
    @Counted(name = "performedAddMassPerson", description = "How many mass add was called.")
    @Timed(name = "addMassPersonTimer", description = "A measure of how long it takes to add the persons.", unit = MetricUnits.MILLISECONDS)
    public Response add(
            @Parameter(description = "The number of new persons", required = true)
            @PathParam("count") int count
    ){
        massPersonControllerService.add(count);
        return Response.status(Response.Status.CREATED).entity(personControllerService.getAll()).build();
    }


    @Transactional
    @Counted(name = "performedUpdateMassPerson", description = "How many mass update was called.")
    @Timed(name = "updateMassPersonTimer", description = "A measure of how long it takes to update the persons.", unit = MetricUnits.MILLISECONDS)
    public Response add(){
        massPersonControllerService.updateAllAddYear();
        return Response.status(Response.Status.CREATED).entity(personControllerService.getAll()).build();
    }
}
