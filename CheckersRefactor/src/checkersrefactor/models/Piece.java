package checkersrefactor.models;

public class Piece {

    private Color color;
    
    public static final int VALID_PAWN_MOVE_DISTANCE = 2;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public boolean isAdvanced(Coordinate origin, Coordinate target) {
        int difference = origin.getRow() - target.getRow();
        if (color == Color.WHITE) {
            return difference > 0;
        }
        return difference < 0;
    }

    Error getError(Coordinate origin, Coordinate target, Turn turn) {
        if (turn.getColor() != this.color) {
            return Error.OPPOSITE_PIECE;
        }
        if (!origin.isDiagonal(target)) {
            return Error.NOT_DIAGONAL;
        }
        if (!this.isAdvanced(origin, target)) {
            return Error.NOT_ADVANCED;
        }
        if (origin.diagonalDistance(target) > VALID_PAWN_MOVE_DISTANCE) {
            return Error.BAD_DISTANCE;
        }
        return null;
    }
}
