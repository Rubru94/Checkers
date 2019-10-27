package CheckersOnlyTest.views;

import CheckersOnlyTest.controllers.Controller;
import CheckersOnlyTest.controllers.ControllersVisitor;

public abstract class View implements ControllersVisitor {

    public void interact(Controller controller) {
        controller.accept(this);
    }

}
