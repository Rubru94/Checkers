package checkersfinal.views;

import checkersfinal.controllers.StartController;

public class StartView extends SubView {

    public StartView() {
        super();
    }

    public void interact(StartController startController) {
        MessageView.TITLE.writeln();
        new GameView().write(startController);
        startController.start();
    }
}
