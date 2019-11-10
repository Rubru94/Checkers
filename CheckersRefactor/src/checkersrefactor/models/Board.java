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

    public Piece remove(Coordinate coordinate) {
        assert this.getPiece(coordinate) != null;
        return this.getSquare(coordinate).remove();
    }

    public void move(Coordinate origin, Coordinate target) {
        this.put(target, this.remove(origin));
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.getSquare(coordinate).getPiece();
    }

    public boolean isEmpty(Coordinate coordinate) {
        return this.getSquare(coordinate).isEmpty();
    }

    public Color getColor(Coordinate coordinate) {
        return this.getSquare(coordinate).getColor();
    }

    public List<Piece> getPieces(Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                if (this.squares[i][j].getColor() == color) {
                    pieces.add(this.squares[i][j].getPiece());
                }
            }
        }
        return pieces;
    }

    @Override
    public String toString() {
        String string = "";
        string += this.toStringHorizontalNumbers();
        for (int i = 0; i < Board.DIMENSION; i++) {
            string += this.toStringHorizontalPiecesWithNumbers(i);
        }
        string += this.toStringHorizontalNumbers();
        return string;
    }

    private String toStringHorizontalNumbers() {
        String string = " ";
        for (int j = 0; j < Board.DIMENSION; j++) {
            string += j;
        }
        return string + "\n";
    }

    private String toStringHorizontalPiecesWithNumbers(int row) {
        String string = "" + row;
        for (int j = 0; j < Board.DIMENSION; j++) {
            Piece piece = this.getPiece(new Coordinate(row, j));
            if (piece == null) {
                string += " ";
            } else {
                final String[] letters = {"b", "n"};
                string += letters[piece.getColor().ordinal()];
            }
        }
        return string + row + "\n";
    }
}
