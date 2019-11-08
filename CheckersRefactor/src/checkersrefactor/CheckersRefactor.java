package checkersrefactor;

import checkersrefactor.controllers.Controller;
import checkersrefactor.controllers.Logic;
import checkersrefactor.views.View;

class CheckersRefactor {

    private View view;

    private Logic logic;

    private CheckersRefactor() {
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
        new CheckersRefactor().play();
    }

}
