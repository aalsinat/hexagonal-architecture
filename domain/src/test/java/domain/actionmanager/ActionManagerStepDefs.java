package domain.actionmanager;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.actionmanager.api.ActionManagerService;
import domain.actionmanager.api.entity.Action;
import domain.actionmanager.api.entity.OperationType;
import domain.actionmanager.core.ActionManagerServiceImpl;
import domain.actionmanager.mock.MockInMemoryActionRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class ActionManagerStepDefs {
    private MockInMemoryActionRepository mockActionRepository;
    private ActionManagerService actionManagerService;

    @Before
    public void setUp() {
        mockActionRepository = new MockInMemoryActionRepository();
        actionManagerService = new ActionManagerServiceImpl(mockActionRepository);
    }

    @Given("^'(.*)' add '(.*)' action of type '(.*)' to repository$")
    public void userAddAnAction(String userId, String actionName, String type) {
        // Exercise
        Optional<Action> actionIsSaved = actionManagerService.addAction(actionName, OperationType.valueOf(type), userId);
        // Verify
        assertThat(actionIsSaved.isPresent());
    }

    @Then("^'(.*)' can get '(.*)' action")
    public void userGetAnAction(String userId, String actionId) {
        Optional<Exception> exception = Optional.empty();
        try {
            actionManagerService.getAction(actionId, userId);
        } catch (Exception e) {
            Optional.ofNullable(e);
        }
        assertThat(!exception.isPresent());
    }

    @When("^'(.*)' delete '(.*)' action")
    public void userDeleteAnAction(String userId, String actionName) {
        // Setup
        String actionId = getActionId(actionName);
        // Exercise
        try {
            actionManagerService.deleteAction(actionId, userId);
        } catch (Exception e) {

        }

    }

    @Then("^'(.*)' cannot get '(.*)' action")
    public void userCannotGetAction(String userId, String actionName) {
        // Setup
        String actionId = getActionId(actionName);
        Exception exception = null;

        // Exercise
        try {
            actionManagerService.getAction(actionId, userId);
        } catch (Exception e) {
            exception = e;
        }

        // Verify
        assertThat(exception).isNotNull();
    }

    @And("^'(.*)' action exist")
    public void actionExist(String actionName) {
        // Exercise
        Optional<Action> action = mockActionRepository.findByName(actionName);

        // Verify
        assertThat(action).isPresent();
    }


    @And("^'(.*)' action doesn't exist")
    public void actionNotExist(String actionName) {
        // Exercise
        Optional<Action> action = mockActionRepository.findByName(actionName);

        // Verify
        assertThat(action).isEmpty();
    }


    private String getActionId(String actionName) {
        return mockActionRepository.findByName(actionName)
                .map(Action::getId)
                .orElse(null);
    }
}
