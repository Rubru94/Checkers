package checkerstest.models;

import checkerstest.types.Color;

public class Board {

    private Square[][] squares;
    public static final int DIMENSION = 8;
    public static final int EMPTY_PIECES_START_ROW = 3;
    public static final int EMPTY_PIECES_FINISH_ROW = 5;

    public Board() {
        this.squares = new Square[Board.DIMENSION][Board.DIMENSION];
        for (int i = 0; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                this.squares[i][j] = new Square(new Coordinate(i, j));
            }
        }
        for (int i = 0; i < Board.EMPTY_PIECES_START_ROW; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                if (new Coordinate(i, j).isBlack()) {
                    this.squares[i][j].put(new Piece(Color.BLACK));
                }
            }
        }
        for (int i = Board.EMPTY_PIECES_FINISH_ROW; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                if (new Coordinate(i, j).isBlack()) {
                    this.squares[i][j].put(new Piece(Color.WHITE));
                }
            }
        }
    }

    public Color getColor(Coordinate coordinate) {
        return this.squares[coordinate.getRow()][coordinate.getColumn()].getColor();
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.squares[coordinate.getRow()][coordinate.getColumn()].getPiece();
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.squares[coordinate.getRow()][coordinate.getColumn()].isEmpty();
    }

    public void move(Coordinate origin, Coordinate target) {
        Piece piece = this.squares[origin.getRow()][origin.getColumn()].remove();
        this.squares[target.getRow()][target.getColumn()].put(piece);
    }

    public void remove(Coordinate coordinate) {
        assert coordinate != null;
        assert this.getPiece(coordinate) != null;
        this.squares[coordinate.getRow()][coordinate.getColumn()].remove();
    }

    public int calcPieceNumber(Color color) {
        int number = 0;
        for (int i = 0; i < this.squares.length; i++) {
            for (int j = 0; j < this.squares[0].length; j++) {
                if (this.squares[i][j].getPiece() != null && this.getColor(new Coordinate(i, j)) == color) {
                    number++;
                }
            }
        }
        return number;
    }

    @Override
    public String toString() {
        String string = " ";
        for (int j = 0; j < Board.DIMENSION; j++) {
            string += j;
        }
        string += "\n";
        for (int i = 0; i < Board.DIMENSION; i++) {
            string += i;
            for (int j = 0; j < Board.DIMENSION; j++) {
                Piece piece = this.squares[i][j].getPiece();
                if (piece == null) {
                    string += " ";
                } else if (piece.isBlack()) {
                    string += "n";
                } else {
                    string += "b";
                }
            }
            string += i + "\n";
        }
        string += " ";
        for (int j = 0; j < Board.DIMENSION; j++) {
            string += j;
        }
        return string;
    }

}
