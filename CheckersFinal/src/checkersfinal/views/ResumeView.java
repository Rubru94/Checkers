package checkersfinal.views;

import checkersfinal.controllers.ResumeController;
import checkersfinal.utils.YesNoDialog;

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
