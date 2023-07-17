package org.acme.resource.api;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/mass_processing_person")
@Tag(name = "Mass processing person Resource", description = "Mass processing person REST APIs")
public interface MassProcessingPersonApi {
    @POST
    @Path("/{count}")
    @Operation(summary = "Add new persons", description = "Add new persons")
    @APIResponse(
            responseCode = "201",
            description = "Persons is added"
    )
    public Response add(
            @Parameter(description = "The number of new persons", required = true)
            @PathParam("count") int count
    );

    @PUT
    @Operation(summary = "Update persons", description = "Update persons")
    @APIResponse(
            responseCode = "200",
            description = "Persons is updated"
    )
    public Response add();
}
