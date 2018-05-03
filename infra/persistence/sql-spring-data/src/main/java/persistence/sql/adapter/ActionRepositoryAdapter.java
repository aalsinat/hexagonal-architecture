package persistence.sql.adapter;

import domain.actionmanager.api.entity.OperationType;
import org.springframework.stereotype.Service;
import persistence.sql.entity.Action;
import persistence.sql.factory.ActionFactory;
import persistence.sql.mapper.ActionMapper;
import persistence.sql.repository.ActionRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActionRepositoryAdapter implements domain.actionmanager.spi.ActionRepository {

    @Inject
    private ActionRepository actionRepository;
    @Inject
    private ActionFactory actionFactory;
    @Inject
    private ActionMapper actionMapper;


    @Override
    public Optional<domain.actionmanager.api.entity.Action> findById(String actionId) {
        Action action = actionRepository.findOne(Long.valueOf(actionId));
        return Optional.ofNullable(actionMapper.actionToActionDTO(action));
    }

    @Override
    public List<domain.actionmanager.api.entity.Action> findActionsByUserId(String ownerId) {
        List<Action> actions = actionRepository.findActionsByOwner(ownerId);
        return actions.stream()
                .map(action -> actionMapper.actionToActionDTO(action))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<domain.actionmanager.api.entity.Action> addAction(String actionName, OperationType type, String ownerId) {
        Action actionToSave = actionFactory.createAction(actionName, type.name(), ownerId);
        Action actionSaved = actionRepository.save(actionToSave);
        return Optional.ofNullable(actionMapper.actionToActionDTO(actionSaved));
    }

    @Override
    public void deleteAction(String actionId) {
        actionRepository.delete(Long.valueOf(actionId));
    }
}
