package checkersfinal.views;

import checkersfinal.controllers.StartController;

public class StartView extends SubView {

    public StartView() {
        super();
    }

    public void interact(StartController startController) {
        assert startController != null;
        MessageView.TITLE.writeln();
        startController.start();
    }
}
