package CheckersOnlyTest.models;

public class Board {

    private Piece piece;
    public static final Coordinate[] DIMENSION = new Coordinate[64];

    public Board(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmptyCoordinate(Coordinate coordinate){
      return false;
    }

    public void addPiece(Piece piece){

    }

    public Piece getPiece(){
        return this.piece;
    }

}
