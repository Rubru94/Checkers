package checkersrefactor.controllers;

import checkersrefactor.models.Color;
import checkersrefactor.models.Coordinate;
import checkersrefactor.models.Error;
import checkersrefactor.models.Game;
import checkersrefactor.models.Piece;
import checkersrefactor.models.State;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }

    public Error move(Coordinate origin, Coordinate target) {
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
