package checkersrefactor.models;

public class PawnMoveValidator {

    private Coordinate origin;
    private Coordinate target;
    private Board board;
    private Turn turn;

    public static final int VALID_PAWN_MOVE_DISTANCE = 2;
    public static final int VALID_EATING_DISTANCE = 2;

    PawnMoveValidator(Coordinate origin, Coordinate target, Board board, Turn turn) {
        this.origin = origin;
        this.target = target;
        this.board = board;
        this.turn = turn;
    }

    Error validateErrors() {
        return validateOUT_COORDINATE();
    }

    private Error validateOUT_COORDINATE() {
        assert this.origin != null && target != null;
        if (!this.origin.isValid() || !target.isValid()) {
            return Error.OUT_COORDINATE;
        }
        return this.validateEMPTY_ORIGIN();
    }

    private Error validateEMPTY_ORIGIN() {
        if (this.board.isEmpty(this.origin)) {
            return Error.EMPTY_ORIGIN;
        }
        return this.validateOPPOSITE_PIECE();
    }

    private Error validateOPPOSITE_PIECE() {
        if (this.turn.getColor() != this.board.getPiece(this.origin).getColor()) {
            return Error.OPPOSITE_PIECE;
        }
        return this.validateNOT_DIAGONAL();
    }

    private Error validateNOT_DIAGONAL() {
        if (!this.origin.isDiagonal(this.target)) {
            return Error.NOT_DIAGONAL;
        }
        return this.validateNOT_ADVANCED();
    }

    private Error validateNOT_ADVANCED() {
        if (!this.board.getPiece(this.origin).isAdvanced(origin, target)) {
            return Error.NOT_ADVANCED;
        }
        return this.validateBAD_DISTANCE();
    }

    private Error validateBAD_DISTANCE() {
        if (origin.diagonalDistance(target) > VALID_PAWN_MOVE_DISTANCE) {
            return Error.BAD_DISTANCE;
        }
        return this.validateNOT_EMPTY_TARGET();
    }

    private Error validateNOT_EMPTY_TARGET() {
        if (!this.board.isEmpty(target)) {
            return Error.NOT_EMPTY_TARGET;
        }
        return this.validateEATING_EMPTY();
    }

    private Error validateEATING_EMPTY() {
        if (this.origin.diagonalDistance(this.target) == VALID_EATING_DISTANCE) {
            Coordinate between = this.origin.betweenDiagonal(target);
            if (this.board.getPiece(between) == null) {
                return Error.EATING_EMPTY;
            }
            this.board.remove(between);
        }
        return null;
    }
}
