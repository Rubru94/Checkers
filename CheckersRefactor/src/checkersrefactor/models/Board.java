package checkersrefactor.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int DIMENSION = 8;

    private Square[][] squares;

    Board() {
        this.squares = new Square[Board.DIMENSION][Board.DIMENSION];
        for (int i = 0; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                this.squares[i][j] = new Square();
            }
        }
    }

    private Square getSquare(Coordinate coordinate) {
        assert coordinate != null && coordinate.isValid();
        return this.squares[coordinate.getRow()][coordinate.getColumn()];
    }

    public void put(Coordinate coordinate, Piece piece) {
        assert piece != null;
        this.getSquare(coordinate).put(piece);
    }

    Piece remove(Coordinate coordinate) {
        assert this.getPiece(coordinate) != null;
        return this.getSquare(coordinate).remove();
    }

    void move(Coordinate origin, Coordinate target) {
        this.put(target, this.remove(origin));
    }

    Piece getPiece(Coordinate coordinate) {
        return this.getSquare(coordinate).getPiece();
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.getSquare(coordinate).isEmpty();
    }

    Color getColor(Coordinate coordinate) {
        return this.getSquare(coordinate).getColor();
    }

    List<Piece> getPieces(Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                pieces.add(this.squares[i][j].getPiece());
            }
        }
        return pieces;
    }
}
