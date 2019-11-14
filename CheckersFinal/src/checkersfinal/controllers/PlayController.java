package checkersfinal.controllers;

import checkersfinal.models.Color;
import checkersfinal.models.Coordinate;
import checkersfinal.models.Error;
import checkersfinal.models.Game;
import checkersfinal.models.Piece;
import checkersfinal.models.State;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }

    public Error move(Coordinate origin, Coordinate target) {
        assert origin != null;
        assert target != null;
        Error error = this.game.move(origin, target);
        if (this.game.hasNoPieces()) {
            this.endGame();
        }
        return error;
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.game.getPiece(coordinate);
    }

    public Color getColor() {
        return this.game.getColor();
    }

    public boolean hasNoPieces() {
        return this.game.hasNoPieces();
    }

    public void endGame() {
        this.game = new Game();
        this.state.next();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
