package persistence.inmemory.entity;

import domain.actionmanager.api.entity.OperationType;

import java.util.Objects;

public class Action implements domain.actionmanager.api.entity.Action {
    private final String id;
    private final String taskName;
    private final OperationType type;
    private final String ownerId;

    public Action(String id, String taskName, OperationType type, String ownerId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(id, action.id) &&
                Objects.equals(taskName, action.taskName) &&
                type == action.type &&
                Objects.equals(ownerId, action.ownerId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, taskName, type, ownerId);
    }

    @Override
    public String toString() {
        return "Action{" +
                "id='" + id + '\'' +
                ", taskName='" + taskName + '\'' +
                ", type=" + type +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
