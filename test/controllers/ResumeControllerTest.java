package test.controllers;

import static org.junit.Assert.*;

import CheckersOnlyTest.controllers.ResumeController;
import CheckersOnlyTest.models.Game;
import CheckersOnlyTest.models.State;

public class ResumeControllerTest {

    public ResumeControllerTest() {

    }

    @Test
    public void givenResumeControllerWhenResumeThenNotError() {
        ResumeController resumeController = new ResumeController(new Game(), new State());
        assertNull(resumeController.resume(false));
    }

}