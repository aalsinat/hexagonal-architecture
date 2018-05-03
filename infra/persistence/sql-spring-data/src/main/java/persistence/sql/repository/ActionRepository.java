package persistence.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.sql.entity.Action;

import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Long> {
    List<Action> findActionsByOwner(String owner);
}
