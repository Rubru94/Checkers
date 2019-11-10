package test.controllers;

import checkersrefactor.controllers.StartController;
import checkersrefactor.models.Game;
import checkersrefactor.models.State;
import checkersrefactor.models.StateValue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StartControllerTest {

    @Test
    public void givenStartControllerWhenStartGameThenChangeState() {
        State state = new State();
        StartController startController = new StartController(new Game(), state);
        assertEquals(StateValue.INITIAL, state.getValueState());
        startController.start();
        assertEquals(StateValue.IN_GAME, state.getValueState());
    }

}
