package checkersfinal.controllers;

import checkersfinal.models.Game;
import checkersfinal.models.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public void start() {
        this.game = new Game();
        this.state.next();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        assert controllersVisitor != null;
        controllersVisitor.visit(this);
    }
}
