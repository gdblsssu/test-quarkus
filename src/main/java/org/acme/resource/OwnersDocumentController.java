package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.entity.OwnersDocument;
import org.acme.service.OwnersDocumentService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import java.util.List;


@Path("/ownersdocument")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OwnersDocumentController {

    @Inject
    OwnersDocumentService ownersDocumentService;

    @GET
    @Counted(name = "performedGetAllOwnersDocument", description = "How many times was the list of documents about ownership received.")
    @Timed(name = "getAllOwnersDocumentTimer", description = "A measure of how long it takes to get the list of owner's document.", unit = MetricUnits.MILLISECONDS)
    public List<OwnersDocument> getAll(){
        return ownersDocumentService.getAll();
    }

    @GET
    @Path("/{id}")
    @Counted(name = "performedGetByIdOwnersDocument", description = "How many times was the owner's document received.")
    @Timed(name = "getByIdOwnersDocumentTimer", description = "A measure of how long it takes to get a owner's document.", unit = MetricUnits.MILLISECONDS)
    public OwnersDocument getById(
            @PathParam("id") Long id
    ){
        return ownersDocumentService.getById(id);
    }

    @POST
    @Transactional
    @Counted(name = "performedAddOwnersDocument", description = "How many owner's document have been added.")
    @Timed(name = "addOwnersDocumentTimer", description = "A measure of how long it takes to add a owner's document.", unit = MetricUnits.MILLISECONDS)
    public String add(OwnersDocument ownersDocument){
        return ownersDocumentService.add(ownersDocument);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Counted(name = "performedDeleteOwnersDocument", description = "How many owner's document have been deleted.")
    @Timed(name = "deleteOwnersDocumentTimer", description = "A measure of how long it takes to delete a owner's document.", unit = MetricUnits.MILLISECONDS)
    public String delete(
            @PathParam("id") Long id
    ){
        return ownersDocumentService.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Counted(name = "performedUpdateOwnersDocument", description = "How many owner's document have been updated.")
    @Timed(name = "updateOwnersDocumentTimer", description = "A measure of how long it takes to update a owner's document.", unit = MetricUnits.MILLISECONDS)
    public String update(
            @PathParam("id") Long id,
            OwnersDocument ownersDocument
    ){
        return ownersDocumentService.update(id, ownersDocument);
    }
}
