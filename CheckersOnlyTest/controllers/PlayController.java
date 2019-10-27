package CheckersOnlyTest.controllers;

import CheckersOnlyTest.models.Coordinate;
import CheckersOnlyTest.models.Game;
import CheckersOnlyTest.models.King;
import CheckersOnlyTest.models.Pawn;
import CheckersOnlyTest.models.Piece;
import CheckersOnlyTest.models.State;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }

    public void move(Coordinate origin, Coordinate target) {
        
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

	public Piece getPiece(Coordinate origin) {
		return null;
    }
    
    public boolean isValidCoordinate(Coordinate coordinate){
        return (Math.abs(coordinate.getRow() - coordinate.getColumn())%2==0);
    }

    public Piece convertToKing(Pawn pawn){
        return new King(pawn.getColor(), pawn.getCoordinate());
    }

}
