package CheckersOnlyTest.models;

public class Coordinate {

    private int row;
    private int column;
    
	public Coordinate(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    public Coordinate getCoordinate(){
        return this;
    }

}
