package checkersrefactor.controllers;

import checkersrefactor.models.Color;
import checkersrefactor.models.Coordinate;
import checkersrefactor.models.Game;
import checkersrefactor.models.State;

public abstract class Controller {

    protected Game game;
    protected State state;

    protected Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    abstract public void accept(ControllersVisitor controllersVisitor);

}
