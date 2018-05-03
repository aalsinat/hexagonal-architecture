package application.commandline;

import domain.actionmanager.api.ActionManagerService;
import domain.actionmanager.api.entity.Action;
import domain.actionmanager.api.entity.OperationType;
import domain.actionmanager.core.ActionManagerServiceImpl;
import domain.actionmanager.spi.ActionRepository;
import persistence.sql.SQLPersistence;

import java.util.List;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws Exception {
        /***** Init *****/
        // Repository
        ActionRepository actionRepository = SQLPersistence.get();
        //ActionRepository actionRepository = new InMemoryRepository();

        // Action Manager
        ActionManagerService actionManagerService = new ActionManagerServiceImpl(actionRepository);

        /***** Run *****/
        // Action manage
        Optional<Action> action = actionManagerService.addAction("Read article", OperationType.INSERTED, "Toni");
        System.out.println("Add new action   -> " + action);

        action = actionManagerService.getAction(action.get().getId(), "Toni");
        System.out.println("Get action id: " + action.get().getId() + " -> " + action);

        action = actionManagerService.addAction("Ask for approval", OperationType.UPDATED, "Toni");
        System.out.println("Add new action   -> " + action);

        Optional<List<Action>> actions = actionManagerService.getAllActions("Toni");
        System.out.println("Get all actions: " + actions.get());

        actionManagerService.deleteAction("1", "Toni");
        System.out.println("Delete action id: " + 1);

        actions = actionManagerService.getAllActions("Toni");
        System.out.println("Get all actions: " + actions.get());
    }
}
