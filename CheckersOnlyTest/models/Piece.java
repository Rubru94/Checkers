package CheckersOnlyTest.models;

import CheckersOnlyTest.types.Color;

public class Piece {

    private Color color;
    private Coordinate coordinate;

    public Piece(Color color, Coordinate coordinate) {
        this.color = color;
        this.coordinate = coordinate;
    }

	public Color getColor() {
		return this.color;
    }

    public Coordinate getCoordinate() {
		return this.coordinate;
    }
    
    public int getRow(){
        return this.coordinate.getRow();
    }

    public int getColumn(){
        return this.coordinate.getColumn();
    }

}