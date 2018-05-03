package application.rest;

import application.rest.configuration.CORSResponseFilter;
import application.rest.configuration.RestConfiguration;
import application.rest.mapper.ActionDTOMapper;
import application.rest.resource.ActionManagerResource;
import domain.actionmanager.api.ActionManagerService;
import domain.actionmanager.core.ActionManagerServiceImpl;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import persistence.inmemory.repository.InMemoryRepository;

public class RestApplication extends Application<RestConfiguration> {

    public static void main(String[] args) throws Exception {
        new RestApplication().run(args);
    }

    @Override
    public String getName() {
        return "rest-api";
    }

    @Override
    public void initialize(Bootstrap<RestConfiguration> bootstrap) {
    }

    @Override
    public void run(RestConfiguration configuration, Environment environment) {
        // Default Rest configuration
        environment.jersey().register(CORSResponseFilter.class);

        // Init Domain
        InMemoryRepository actionRepository = new InMemoryRepository();

        // Action Manager
        ActionManagerService actionManagerService = new ActionManagerServiceImpl(actionRepository);

        // REST Dependency injection
        ActionDTOMapper actionDTOMapper = ActionDTOMapper.INSTANCE;
        ActionManagerResource actionManagerResource = new ActionManagerResource(actionManagerService, actionDTOMapper);

        // Register controller
        environment.jersey().register(actionManagerResource);
    }
}
