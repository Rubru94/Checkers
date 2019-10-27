package CheckersOnlyTest.models;

import CheckersOnlyTest.types.Color;

public class Square {

    private Piece piece;
    private Color color;

    protected Square(Piece piece, Color color){
        this.piece = piece;
        this.color = color;
    }

	public Coordinate getCoordinate(Coordinate coordinate) {
		return coordinate.getCoordinate();
	}

}
