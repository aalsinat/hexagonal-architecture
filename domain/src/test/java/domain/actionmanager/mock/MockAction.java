package domain.actionmanager.mock;

import domain.actionmanager.api.entity.Action;
import domain.actionmanager.api.entity.OperationType;

public class MockAction implements Action {
    private final String id;
    private final String taskName;
    private final OperationType type;
    private final String ownerId;

    public MockAction(String id, String taskName, OperationType type, String ownerId) {
        this.id = id;
        this.taskName = taskName;
        this.type = type;
        this.ownerId = ownerId;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.taskName;
    }

    @Override
    public OperationType getOperationType() {
        return this.type;
    }

    @Override
    public String getOwner() {
        return this.ownerId;
    }
}
