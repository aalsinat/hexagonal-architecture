package persistence;

import domain.actionmanager.api.entity.Action;
import domain.actionmanager.api.entity.OperationType;
import domain.actionmanager.spi.ActionRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import persistence.sql.SQLPersistence;

import java.util.Optional;

public class SQLActionRepositoryTest {

    private ActionRepository sqlActionRepository;

    @Before
    public void setUp() throws Exception {
        sqlActionRepository = SQLPersistence.get();
    }

    @Test
    public void testGet() throws Exception {
        Optional<Action> action = sqlActionRepository.addAction("Ask for approval", OperationType.INSERTED, "Alex");
        Assertions.assertThat(sqlActionRepository.findById(action.get().getId())).isNotNull();
    }
}
