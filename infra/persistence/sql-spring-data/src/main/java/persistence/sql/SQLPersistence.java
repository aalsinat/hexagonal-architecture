package persistence.sql;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import persistence.sql.adapter.ActionRepositoryAdapter;

public final class SQLPersistence {

    private static ApplicationContext applicationContext;

    private SQLPersistence() {}

    public static domain.actionmanager.spi.ActionRepository get() {
        ActionRepositoryAdapter actionRepository = getApplicationContext().getBean(ActionRepositoryAdapter.class);
        return actionRepository;
    }

    private static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            applicationContext = new SpringApplication(PersistenceConfiguration.class).run();
        }
        return applicationContext;
    }
}
