package checkersrefactor.models;

public class Game {

    private Board board;

    private Turn turn;

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
            if (coordinate.getRow() <= 2) {
                return new Piece(Color.BLACK);
            } else if (coordinate.getRow() >= 5) {
                return new Piece(Color.WHITE);
            }
        }
        return null;
    }

    public Error move(Coordinate origin, Coordinate target) {
        Error error = null;
        assert origin != null && target != null;
        if (!origin.isValid() || !target.isValid()) {
            return Error.OUT_COORDINATE;
        }
        if (board.isEmpty(origin)) {
            return Error.EMPTY_ORIGIN;
        }

        error = this.board.getPiece(origin).getError(origin, target, this.turn);
        if (error != null) {
            return error;
        }

        if (!this.board.isEmpty(target)) {
            return Error.NOT_EMPTY_TARGET;
        }
        if (origin.diagonalDistance(target) == 2) {
            Coordinate between = origin.betweenDiagonal(target);
            if (this.board.getPiece(between) == null) {
                return Error.EATING_EMPTY;
            }
            this.board.remove(between);
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

    Color getColor() {
        return this.turn.getColor();
    }
    
    Board getBoard() {
        return this.board;
    }

    Piece getPiece(Coordinate coordinate) {
        return this.board.getPiece(coordinate);
    }

    boolean hasNoPieces() {
        return this.board.getPieces(this.turn.getColor()).isEmpty();
    }
    
}
