package persistence.inmemory.repository;

import domain.actionmanager.api.entity.OperationType;
import domain.actionmanager.spi.ActionRepository;
import persistence.inmemory.entity.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryRepository implements ActionRepository {

    /***********************
     *
     * Action Manager
     *
     */

    private final Map<String, Action> actionsInMemory = new HashMap<>();

    public Map<String, Action> getAllActions() {
        return actionsInMemory;
    }

    public Optional<Action> findByName(String actionName) {
        return actionsInMemory.values().stream()
                .filter(mockAction -> hasActionName(mockAction, actionName))
                .findFirst();
    }

    private boolean hasActionName(Action action, String actionName) {
        return actionName.equals(action.getName());
    }


    @Override
    public Optional<domain.actionmanager.api.entity.Action> findById(String actionId) {
        return Optional.ofNullable(actionsInMemory.get(actionId));
    }

    @Override
    public List<domain.actionmanager.api.entity.Action> findActionsByUserId(String ownerId) {
        return actionsInMemory.values().stream()
                .filter(action -> ownerId.equals(action.getOwner()))
                .collect(Collectors.toList());
    }


    @Override
    public Optional<domain.actionmanager.api.entity.Action> addAction(String actionName, OperationType type, String ownerId) {
        Action actionToAdd = new Action(autoGeneratedId(), actionName, type, ownerId);
        actionsInMemory.put(actionToAdd.getId(), actionToAdd);
        return Optional.ofNullable(actionToAdd);
    }


    @Override
    public void deleteAction(String name) {
        actionsInMemory.remove(name);
    }

    private String autoGeneratedId() {
        return String.valueOf(actionsInMemory.size());
    }

}