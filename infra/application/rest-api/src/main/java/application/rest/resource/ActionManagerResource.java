package application.rest.resource;

import application.rest.dto.ActionDTO;
import application.rest.mapper.ActionDTOMapper;
import com.codahale.metrics.annotation.Timed;
import domain.actionmanager.api.ActionManagerService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Path("/action")
@Produces(MediaType.APPLICATION_JSON)
public class ActionManagerResource {

    private final ActionManagerService actionManagerService;
    private final ActionDTOMapper actionDTOMapper;

    public ActionManagerResource(ActionManagerService actionManagerService, ActionDTOMapper actionDTOMapper) {
        this.actionManagerService = actionManagerService;
        this.actionDTOMapper = actionDTOMapper;
    }

    @POST
    @Path("/")
    @Timed
    public Response add(@Valid ActionDTO actionDTO) {
        ActionDTO actionAdded = actionDTOMapper.actionToActionDTO(actionManagerService.addAction(actionDTO.getName(), actionDTO.getType(), "Toni").get());
        return Response.created(UriBuilder.fromResource(ActionManagerResource.class)
                .build(actionAdded))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Timed
    public Response delete(@PathParam("id") Long id) {
        actionManagerService.deleteAction(id.toString(), "Toni");
        return Response.ok(UriBuilder.fromResource(ActionManagerResource.class)
                .build(id))
                .build();
    }

    @GET
    @Path("/{id}")
    @Timed
    public ActionDTO get(@PathParam("id") Long id) {
        return actionDTOMapper.actionToActionDTO(actionManagerService.getAction(id.toString(), "Toni").get());
    }

    @GET
    @Path("/")
    @Timed
    public List<ActionDTO> getAll() {
        return actionDTOMapper.actionsToActionsDTO(actionManagerService.getAllActions("Toni").get());
    }


}