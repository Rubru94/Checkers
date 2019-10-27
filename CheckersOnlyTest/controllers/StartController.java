package CheckersOnlyTest.controllers;

import CheckersOnlyTest.models.Game;
import CheckersOnlyTest.models.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public void start() {
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
