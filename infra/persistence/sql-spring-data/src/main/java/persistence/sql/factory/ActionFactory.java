package persistence.sql.factory;

import org.springframework.stereotype.Service;
import persistence.sql.entity.Action;

@Service
public class ActionFactory {

    public Action createAction(String actionName, String type, String ownerId) {
        Action action = new Action();
        action.setName(actionName);
        action.setOwner(ownerId);
        action.setType(type);
        return action;
    }
}
