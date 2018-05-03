package persistence.sql.adapter;

import domain.actionmanager.api.entity.Action;
import domain.actionmanager.api.entity.OperationType;

import java.util.Objects;

public class ActionAdapter implements Action {
    private String id;
    private String name;
    private String owner;
    private OperationType type;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type.name();
    }

    public void setType(String type) {
        this.type = OperationType.valueOf(type);
    }

    @Override
    public OperationType getOperationType() {
        return this.type;

    }

    @Override
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionAdapter that = (ActionAdapter) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(owner, that.owner) &&
                type == that.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, owner, type);
    }

    @Override
    public String toString() {
        return "ActionAdapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", type=" + type +
                '}';
    }
}

