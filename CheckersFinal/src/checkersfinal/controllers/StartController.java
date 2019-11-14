package checkersfinal.controllers;

import checkersfinal.models.Game;
import checkersfinal.models.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

    public void start() {
        this.game = new Game();
        this.state.next();
    }

}
