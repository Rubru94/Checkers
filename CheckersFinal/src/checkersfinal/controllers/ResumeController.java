package checkersfinal.controllers;

import checkersfinal.models.Game;
import checkersfinal.models.State;

public class ResumeController extends Controller {

    public ResumeController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

    public void next() {
        this.state.next();
    }

    public void reset() {
        this.state.reset();
    }

}
