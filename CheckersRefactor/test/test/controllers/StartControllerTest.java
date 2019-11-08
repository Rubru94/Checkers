package test.controllers;

import checkersrefactor.controllers.StartController;
import checkersrefactor.models.Session;
import checkersrefactor.models.StateValue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StartControllerTest {

    @Test
    public void givenStartControllerWhenStartGameThenChangeState() {
        Session session = new Session();
        StartController startController = new StartController(session);
        assertEquals(StateValue.INITIAL, session.getValueState());
        startController.start();
        assertEquals(StateValue.IN_GAME, session.getValueState());
    }

}
