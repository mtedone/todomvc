package todomvc;



import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import todomvc.questions.TheItems;
import todomvc.tasks.AddATodoItem;
import todomvc.tasks.Start;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class AddNewTasksStepDefinitions {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) has an empty todo list$")
    public void that_an_actor_has_an_empty_todo_list(String actorName) throws Exception {
        OnStage.theActorCalled(actorName).attemptsTo(Start.withAnEmptyList());
    }


    @When("^s?he adds '(.*)' to (?:his|her) list$")
    public void he_adds_to_his_list(String taskName) throws Exception {
        OnStage.theActorInTheSpotlight().attemptsTo(AddATodoItem.called(taskName));
    }

    @Then("^'(.*)' should be recorded in (?:his|her) list$")
    public void buy_some_milk_should_be_recorded_in_his_list(String taskName) throws Exception {
        OnStage.theActorInTheSpotlight().should(seeThat(
                "the items displayed", TheItems.displayed(), hasItem(taskName)
        ));
    }

}
