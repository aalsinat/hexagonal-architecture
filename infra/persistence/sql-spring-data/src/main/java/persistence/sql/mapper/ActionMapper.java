package persistence.sql.mapper;

import org.mapstruct.Mapper;
import persistence.sql.adapter.ActionAdapter;
import persistence.sql.entity.Action;

@Mapper(componentModel = "spring")
public interface ActionMapper {

    ActionAdapter actionToActionDTO(Action action);
}
