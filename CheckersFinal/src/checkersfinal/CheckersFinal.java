package checkersfinal;

import checkersfinal.controllers.Controller;
import checkersfinal.controllers.Logic;
import checkersfinal.views.View;

class CheckersFinal {

    private View view;

    private Logic logic;

    private CheckersFinal() {
        this.view = new View();
        this.logic = new Logic();
    }

    private void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new CheckersFinal().play();
    }

}
