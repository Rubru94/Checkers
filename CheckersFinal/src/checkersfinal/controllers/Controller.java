package checkersfinal.controllers;

import checkersfinal.models.Color;
import checkersfinal.models.Coordinate;
import checkersfinal.models.Game;
import checkersfinal.models.State;

public abstract class Controller {

    protected Game game;
    protected State state;

    protected Controller(Game game, State state) {
        assert game != null;
        assert state != null;
        this.game = game;
        this.state = state;
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;
        return this.game.getColor(coordinate);
    }

    abstract public void accept(ControllersVisitor controllersVisitor);
}
