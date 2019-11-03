package checkerstest.controllers;

import checkerstest.models.Coordinate;
import checkerstest.models.Game;
import checkerstest.models.Piece;
import checkerstest.types.Color;
import checkerstest.types.Error;
import checkerstest.utils.Console;

public class PlayController {

    private Game game;
    private Console console;

    public PlayController(Game game) {
        this.game = game;
        this.console = new Console();
    }

    public Error move(Coordinate origin, Coordinate target) {
        return game.move(origin, target);
    }

    public Piece getPiece(Coordinate origin) {
        return game.getBoard().getPiece(origin);
    }

    public Color getColor() {
        return game.getTurnColor();
    }

    public void printBoard() {
        this.console.writeln("\n" + this.game.getBoard().toString());
    }

    public int getNumberOfPieces(Color color) {
        return this.game.getBoard().calcPieceNumber(color);
    }

    public Game getGame() {
        return this.game;
    }
}
