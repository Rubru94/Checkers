package checkersrefactor.controllers;

import checkersrefactor.models.Game;
import checkersrefactor.models.State;

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
