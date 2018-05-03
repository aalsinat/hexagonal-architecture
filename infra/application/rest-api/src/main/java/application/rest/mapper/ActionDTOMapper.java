package application.rest.mapper;

import application.rest.dto.ActionDTO;
import domain.actionmanager.api.entity.Action;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ActionDTOMapper {
    ActionDTOMapper INSTANCE = Mappers.getMapper(ActionDTOMapper.class);

    ActionDTO actionToActionDTO(Action action);
    List<ActionDTO> actionsToActionsDTO(List<Action> action);
}
