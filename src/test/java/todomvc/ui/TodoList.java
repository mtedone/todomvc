package todomvc.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.stream.Collectors;

public class TodoList extends PageObject {

    public static final Target ITEMS = Target.the("Todo items")
            .locatedBy(".todo-list li");
    public static final Target NEW_TODO = Target.the("New Todo Field")
            .locatedBy(".new-todo");




    public List<String> getTodos() {
        return findAll(".todo-list li").stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
