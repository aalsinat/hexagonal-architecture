package persistence.sql.repository;

import domain.actionmanager.api.entity.OperationType;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import persistence.sql.PersistenceConfiguration;
import persistence.sql.entity.Action;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfiguration.class)
public class ActionRepositoryTest {

    @Inject
    private ActionRepository repository;

    private Action action;

    @Before
    public void setUp() {
        action = new Action();
        action.setName("Read Article");
        action.setType(OperationType.INSERTED.name());
        action.setOwner("Toni");
    }

    @Test
    public void findSavedUserById() {

        action = repository.save(action);

        Assertions.assertThat(repository.findOne(action.getId())).isNotNull();
    }
}
