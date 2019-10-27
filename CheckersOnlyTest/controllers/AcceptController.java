package CheckersOnlyTest.controllers;

import CheckersOnlyTest.models.Game;
import CheckersOnlyTest.models.State;

public abstract class AcceptController extends Controller {

    AcceptController(Game game, State state) {
        super(game, state);
    }

    @Override
    public abstract void accept(ControllersVisitor controllersVisitor);

}