package checkersfinal.models;

import java.util.ArrayList;
import java.util.List;

public class Board implements PieceProvider {

    public static final int DIMENSION = 8;
    public static final int INITIAL_LIMIT = 0;
    public static final int FINAL_LIMIT = 7;

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
        assert coordinate != null;
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

    void move(Coordinate origin, Coordinate target) {
        this.put(target, this.remove(origin));
    }

    @Override
    public Piece getPiece(Coordinate coordinate) {
        return this.getSquare(coordinate).getPiece();
    }

    @Override
    public boolean isEmpty(Coordinate coordinate) {
        return this.getSquare(coordinate).isEmpty();
    }

    public Color getColor(Coordinate coordinate) {
        return this.getSquare(coordinate).getColor();
    }

    List<Piece> getPieces(Color color) {
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

    boolean hasPossibleMoves(Color color) {

        boolean hasMoves = false;
        List<Piece> pieces = getPieces(color);
        for (int i = 0; i < pieces.size(); i++) {

            if (pieces.get(i) instanceof Pawn && !hasMoves) {
                for (int a = 0; a < Board.DIMENSION; a++) {
                    for (int b = 0; b < Board.DIMENSION; b++) {
                        if (this.squares[a][b].getColor() == color) {
                            if (this.squares[a][b].getPiece() == pieces.get(i)) {

                                Coordinate origin = new Coordinate(a, b);
                                Coordinate target = new Coordinate(a - 1, b + 1);
                                if (pieces.get(i).isCorrect(origin, target, this) != null) {
                                    target = new Coordinate(a - 1, b - 1);
                                    hasMoves = pieces.get(i).isCorrect(origin, target, this) == null;
                                } else {
                                    hasMoves = true;
                                }
                            }
                        }
                    }
                }
            }
            if (pieces.get(i) instanceof Draught) {

            }
            if(hasMoves){
                return hasMoves;
            }
        }

        return hasMoves;
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
                for (int p = 0; p < Piece.TYPES.length; p++) {
                    if (Piece.TYPES[p].getClass() == piece.getClass() && Piece.TYPES[p].getColor() == piece.getColor()) {
                        string += Piece.IDS[p];
                    }
                }
            }
        }
        return string + row + "\n";
    }
}
