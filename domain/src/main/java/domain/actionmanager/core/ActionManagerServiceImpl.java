package domain.actionmanager.core;

import domain.actionmanager.api.ActionManagerService;
import domain.actionmanager.api.entity.Action;
import domain.actionmanager.api.entity.OperationType;
import domain.actionmanager.api.exception.AccessDeniedException;
import domain.actionmanager.api.exception.ActionNotFoundException;
import domain.actionmanager.spi.ActionRepository;

import java.util.List;
import java.util.Optional;

public class ActionManagerServiceImpl implements ActionManagerService {
    private final ActionRepository actionRepository;

    public ActionManagerServiceImpl(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public Optional<List<Action>> getAllActions(String userIdRequesting) {
        List<Action> actions = actionRepository.findActionsByUserId(userIdRequesting);
        return Optional.ofNullable(actions);
    }

    @Override
    public Optional<Action> getAction(String actionId, String ownerId) {
        Optional<Action> actionToGet = actionRepository.findById(actionId);
        if (!actionToGet.isPresent()) throw new ActionNotFoundException();
        if (actionToGet.get().getOwner() != ownerId) throw new AccessDeniedException();
        return actionToGet;
    }

    @Override
    public Optional<Action> addAction(String actionName, OperationType type, String ownerId) {
        Optional<Action> actionToAdd = actionRepository.addAction(actionName, type, ownerId);
        return actionToAdd;
    }


    @Override
    public void deleteAction(String actionId, String ownerId) {
        Optional<Action> actionToDelete = actionRepository.findById(actionId);
        if (!actionToDelete.isPresent()) throw new ActionNotFoundException();
        if (actionToDelete.get().getOwner() != ownerId) throw new AccessDeniedException();
        actionRepository.deleteAction(actionId);
    }
}
