package CheckersOnlyTest;

import CheckersOnlyTest.controllers.Controller;
import CheckersOnlyTest.controllers.Logic;
import CheckersOnlyTest.views.View;

public abstract class CheckersOnlyTest {

    private Logic logic;
    private View view;

    protected CheckersOnlyTest() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }

}
