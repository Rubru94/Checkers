package test.controllers;

import checkersrefactor.controllers.ResumeController;
import checkersrefactor.models.Game;
import checkersrefactor.models.State;
import checkersrefactor.models.StateValue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ResumeControllerTest {

    @Test
    public void givenResumeControllerWhenResumeGameMoveToInitialStateRequiereCorrectThenNotError() {
        State state = new State();
        ResumeController resumeController = new ResumeController(new Game(), state);
        assertEquals(StateValue.INITIAL, state.getValueState());
        resumeController.next();
        assertEquals(StateValue.IN_GAME, state.getValueState());
        resumeController.next();
        assertEquals(StateValue.FINAL, state.getValueState());
        resumeController.reset();
        assertEquals(StateValue.INITIAL, state.getValueState());
    }

    @Test(expected = AssertionError.class)
    public void givenResumeControllerWhenResumeGameMoveOutThenError() {
        State state = new State();
        ResumeController resumeController = new ResumeController(new Game(), state);
        assertEquals(StateValue.INITIAL, state.getValueState());
        resumeController.next();
        assertEquals(StateValue.IN_GAME, state.getValueState());
        resumeController.next();
        assertEquals(StateValue.FINAL, state.getValueState());
        resumeController.next();
        assertEquals(StateValue.EXIT, state.getValueState());
        resumeController.next();
    }
}
