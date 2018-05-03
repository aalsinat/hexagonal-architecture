package persistence.sql.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "action")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "owner", length = 100, nullable = false)
    private String owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        Action action = (Action) o;
        return Objects.equals(id, action.id) &&
                Objects.equals(name, action.name) &&
                Objects.equals(type, action.type) &&
                Objects.equals(owner, action.owner);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, type, owner);
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}

