package domain.actionmanager.api;

import domain.actionmanager.api.entity.Action;
import domain.actionmanager.api.entity.OperationType;

import java.util.List;
import java.util.Optional;

public interface ActionManagerService {
    Optional<List<Action>> getAllActions(String userIdRequesting);

    Optional<Action> getAction(String actionId, String userIdRequesting);

    Optional<Action> addAction(String actionName, OperationType type, String userIdRequesting);

    void deleteAction(String actionId, String userIdRequesting);
}
