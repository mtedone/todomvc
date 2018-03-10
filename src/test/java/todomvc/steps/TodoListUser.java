package todomvc.steps;

import net.thucydides.core.annotations.Step;
import todomvc.ui.HomePage;
import todomvc.ui.TodoList;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TodoListUser {

    HomePage todomvcApplicationHomePage;

    TodoList todoList;

    @Step
    public void startWithAnEmptyTodoList() {
        todomvcApplicationHomePage.open();
    }

    @Step
    public void addATask(String taskName) {
        todoList.addTodo(taskName);
    }

    @Step
    public void shoudSeeATaskWithName(String taskName) {
        assertThat(todoList.getTodos()).contains(taskName);
    }
}
