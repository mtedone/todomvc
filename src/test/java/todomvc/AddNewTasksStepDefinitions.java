package todomvc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import todomvc.steps.TodoListUser;

import java.util.List;

public class AddNewTasksStepDefinitions {

    @Steps
    TodoListUser james;

    @Steps
    TodoListUser jane;

    @Given("^that James has an empty todo list$")
    public void that_James_has_an_empty_todo_list() throws Exception {
        james.startWithAnEmptyTodoList();
    }


    @When("^he adds '(.*)' to his list$")
    public void he_adds_to_his_list(String taskName) throws Exception {
        james.addATask(taskName);
    }

    @Then("^'(.*)' should be recorded in his list$")
    public void buy_some_milk_should_be_recorded_in_his_list(String taskName) throws Exception {
        james.shoudSeeATaskWithName(taskName);
    }

    @Given("^that Jane has a list containing$")
    public void that_Jane_has_a_list_containing(List<String> tasks) throws Exception {
        jane.hasAListContaining(tasks);
    }


    @When("^she adds '(.*)' to her list$")
    public void she_adds(String task) throws Exception {
        jane.addATask(task);
    }

    @Then("^her todo list should contain$")
    public void her_todo_list_should_contain(List<String> allTasks) throws Exception {
        jane.verifyTodoListContains(allTasks);
    }

}
