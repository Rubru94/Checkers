package CheckersOnlyTest.controllers;

import CheckersOnlyTest.models.Game;
import CheckersOnlyTest.models.State;
import CheckersOnlyTest.models.StateValue;
import java.util.HashMap;
import java.util.Map;


public class Logic {

    private State state;
    private Game game;

    public Map<StateValue, AcceptController> acceptControllers;
    public Logic() {
        this.acceptControllers = new HashMap<StateValue, AcceptController>();
    }

    public AcceptController getController() {
        return this.acceptControllers.get(this.state.getValueState());
    }

}
