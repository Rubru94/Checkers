package test.controllers;

import static org.junit.Assert.*;

import CheckersOnlyTest.controllers.StartController;
import CheckersOnlyTest.models.Game;
import CheckersOnlyTest.models.State;

public class StartControllerTest {

    public StartControllerTest() {

    }

    @Test
    public void givenStartControllerWhenStartThenNotError() {
        StartController startController = new StartController(new Game(), new State());
        assertNull(startController.start());
    }

}