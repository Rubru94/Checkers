package checkersrefactor.models;

public class Game {

    private Board board;

    private Turn turn;

    public static final int EMPTY_SQUARES_START_ROW = 3;
    public static final int EMPTY_SQUARES_FINISH_ROW = 4;

    public Game() {
        this.turn = new Turn();
        this.board = new Board();
        for (int i = 0; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Piece piece = this.getInitialPiece(coordinate);
                if (piece != null) {
                    this.board.put(coordinate, piece);
                }
            }
        }
    }

    public Piece getInitialPiece(Coordinate coordinate) {
        if (coordinate.isBlack()) {
            if (coordinate.getRow() < EMPTY_SQUARES_START_ROW) {
                return new Piece(Color.BLACK);
            } else if (coordinate.getRow() > EMPTY_SQUARES_FINISH_ROW) {
                return new Piece(Color.WHITE);
            }
        }
        return null;
    }

    public Error move(Coordinate origin, Coordinate target) {

        PawnMoveValidator pawnMoveValidator = new PawnMoveValidator(origin, target, this.board, this.turn);
        Error error = pawnMoveValidator.validateErrors();
        if (error != null) {
            return error;
        }

        this.board.move(origin, target);
        this.turn.change();
        return null;
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    @Override
    public String toString() {
        return this.board + "\n" + this.turn;
    }

    public Color getColor() {
        return this.turn.getColor();
    }

    Board getBoard() {
        return this.board;
    }

    Turn getTurn() {
        return this.turn;
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.board.getPiece(coordinate);
    }

    public boolean hasNoPieces() {
        return this.board.getPieces(this.turn.getColor()).isEmpty();
    }

}
