package checkersrefactor.controllers;

import checkersrefactor.models.Color;
import checkersrefactor.models.Coordinate;
import checkersrefactor.models.Session;
import checkersrefactor.models.Board;

public abstract class Controller {

    protected Session session;

    protected Controller(Session session) {
        this.session = session;
    }

    public Color getColor(Coordinate coordinate) {
        return this.session.getColor(coordinate);
    }

    abstract public void accept(ControllersVisitor controllersVisitor);

}
