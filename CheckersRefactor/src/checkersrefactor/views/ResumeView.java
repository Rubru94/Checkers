package checkersrefactor.views;

import checkersrefactor.controllers.ResumeController;
import checkersrefactor.utils.YesNoDialog;

public class ResumeView extends SubView {

    private YesNoDialog yesNoDialog;

    public ResumeView() {
        super();
        this.yesNoDialog = new YesNoDialog();
    }

    public void interact(ResumeController resumeController) {
        if (this.yesNoDialog.read(MessageView.PLAY_AGAIN.getMessage())) {
            resumeController.reset();
        } else {
            resumeController.next();
        }

    }
}
