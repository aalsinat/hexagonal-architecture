package domain.actionmanager.spi;

import domain.actionmanager.api.entity.Action;
import domain.actionmanager.api.entity.OperationType;

import java.util.List;
import java.util.Optional;

public interface ActionRepository {
    Optional<Action> findById(String actionId);

    List<Action> findActionsByUserId(String ownerId);

    Optional<Action> addAction(String actionName, OperationType type, String ownerId);

    void deleteAction(String actionId);
}
