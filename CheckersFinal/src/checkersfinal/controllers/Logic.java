package checkersfinal.controllers;

import checkersfinal.models.Game;
import checkersfinal.models.State;
import checkersfinal.models.StateValue;
import java.util.HashMap;
import java.util.Map;

public class Logic {

    private Game game;
    private State state;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;
    private Map<StateValue, Controller> controllers;

    public Logic() {
        this.game = new Game();
        this.state = new State();
        this.controllers = new HashMap<StateValue, Controller>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
        this.controllers.put(StateValue.FINAL, new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.state.getValueState());
    }

}
