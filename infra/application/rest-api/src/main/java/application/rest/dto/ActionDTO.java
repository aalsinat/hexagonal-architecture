package application.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import domain.actionmanager.api.entity.OperationType;

import java.util.Objects;

public class ActionDTO {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String ownerId;
    @JsonProperty
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public OperationType getType() {
        return OperationType.valueOf(type);
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionDTO actionDTO = (ActionDTO) o;
        return Objects.equals(id, actionDTO.id) &&
                Objects.equals(name, actionDTO.name) &&
                Objects.equals(ownerId, actionDTO.ownerId) &&
                Objects.equals(type, actionDTO.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, ownerId, type);
    }

    @Override
    public String toString() {
        return "ActionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
