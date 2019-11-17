package test.models;

import checkersfinal.models.Board;
import checkersfinal.models.Color;
import checkersfinal.models.Coordinate;
import checkersfinal.models.Game;
import checkersfinal.models.Error;
import checkersfinal.models.GameBuilder;
import checkersfinal.models.Piece;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GameTest {

    private Game game;

    public GameTest() {
        game = new Game();
    }

    @Test
    public void testGivenNewGameThenBoardHasGoodLocations() {
        for (int i = 0; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Piece piece = game.getInitialPiece(coordinate);
                if (piece != null) {
                    Color color = game.getColor(coordinate);
                    if (coordinate.getRow() < Game.EMPTY_SQUARES_START_ROW) {
                        assertEquals(Color.BLACK, color);
                    } else if (coordinate.getRow() > Game.EMPTY_SQUARES_FINISH_ROW) {
                        assertEquals(Color.WHITE, color);
                    }
                }
            }
        }
    }

    @Test
    public void testGivenGameWhenConstructThenInitialDistribution() {
        assertEquals(Color.WHITE, game.getColor(new Coordinate(5, 0)));
        assertEquals(Color.BLACK, game.getColor(new Coordinate(2, 1)));
    }

    @Test
    public void testGivenGameWhenMoveEmptySquareThenEmptySquareError() {
        Coordinate origin = new Coordinate(4, 3);
        Coordinate target = new Coordinate(3, 4);
        Game game = new GameBuilder()
                .row(" n n n n")
                .row("n n n n ")
                .row(" n n n n")
                .row("        ")
                .row("        ")
                .row("b b b b ")
                .row(" b b b b")
                .row("b b b b ")
                .build();
        assertEquals(Error.EMPTY_ORIGIN, game.isCorrect(origin, target));  
    }

    @Test
    public void testGivenGameWhenMoveOppositePieceThenError() {
        Coordinate origin = new Coordinate(3, 6);
        Coordinate target = new Coordinate(2, 7);
        Game game = new GameBuilder()
                .row(" n n n n")
                .row("n n n n ")
                .row(" n n n  ")
                .row("      n ")
                .row("       b")
                .row("b b b   ")
                .row(" b b b b")
                .row("b b b b ")
                .build();
        assertEquals(Error.OPPOSITE_PIECE, game.isCorrect(origin, target));
    }

    @Test
    public void testGivenGameWhenNotDiagonalMovementThenError() {
        Coordinate origin = new Coordinate(5, 2);
        Coordinate target = new Coordinate(4, 2);
        Game game = new GameBuilder()
                .row(" n n n n")
                .row("n n n n ")
                .row(" n n n n")
                .row("        ")
                .row("        ")
                .row("b b b b ")
                .row(" b b b b")
                .row("b b b b ")
                .build();
        assertEquals(Error.NOT_DIAGONAL, game.isCorrect(origin, target));
    }

    @Test
    public void testGivenGameWhenMoveWithNotAdvancedThenError() {
        Coordinate origin = new Coordinate(3, 4);
        Coordinate target = new Coordinate(4, 5);
        Game game = new GameBuilder()
                .row(" n n n  ")
                .row("n n n n ")
                .row(" n n n n")
                .row("    b n ")
                .row("       b")
                .row("b b     ")
                .row(" b b b b")
                .row("b b b b ")
                .build();
        assertEquals(Error.NOT_ADVANCED, game.isCorrect(origin, target));
    }

    @Test
    public void testGivenGameWhenNotEmptyTargeThenError() {
        Coordinate origin = new Coordinate(4, 7);
        Coordinate target = new Coordinate(3, 6);
        Game game = new GameBuilder()
                .row(" n n n n")
                .row("n n n n ")
                .row(" n n n  ")
                .row("      n ")
                .row("       b")
                .row("b b b   ")
                .row(" b b b b")
                .row("b b b b ")
                .build();
        assertEquals(Error.NOT_EMPTY_TARGET, game.isCorrect(origin, target));
    }

    @Test
    public void testGivenGameWhenCorrectMovementThenOk() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        this.game.move(origin, target);
        assertNull(this.game.getColor(origin));
        assertEquals(Color.WHITE, this.game.getColor(target));
        origin = new Coordinate(2, 3);
        target = new Coordinate(3, 4);
        this.game.move(origin, target);
        assertNull(this.game.getColor(origin));
        assertEquals(Color.BLACK, this.game.getColor(target));
    }

    @Test
    public void testGivenGameWhenMovementThenEatPiece() {
        Coordinate origin = new Coordinate(3, 0);
        Coordinate target = new Coordinate(5, 2);
        Game game = new GameBuilder()
                .row(" n n n n")
                .row("n n n n ")
                .row("   n n n")
                .row("n       ")
                .row(" b b    ")
                .row("    b b ")
                .row(" b b b b")
                .row("b b b b ")
                .build();
        game.getTurn().change();
        game.move(origin, target);
        assertNull(game.getColor(new Coordinate(3, 0)));
        assertNull(game.getColor(new Coordinate(4, 1)));
        assertEquals(Color.BLACK, game.getColor(new Coordinate(5, 2)));
    }

    @Test
    public void testGivenGameWhenEatEmptyPieceThenError() {
        Coordinate origin = new Coordinate(5, 4);
        Coordinate target = new Coordinate(3, 2);
        Game game = new GameBuilder()
                .row(" n n n n")
                .row("n n n n ")
                .row(" n n n n")
                .row("        ")
                .row("        ")
                .row("b b b b ")
                .row(" b b b b")
                .row("b b b b ")
                .build();
        assertEquals(Error.EATING_EMPTY, game.isCorrect(origin, target));
    }

    @Test
    public void testGivenGameWhenMoveBadDistanceThenError() {
        Coordinate origin = new Coordinate(1, 6);
        Coordinate target = new Coordinate(4, 3);
        Game game = new GameBuilder()
                .row(" n n n n")
                .row("n n n n ")
                .row("      n ")
                .row("  n     ")
                .row(" b     b")
                .row("  b b   ")
                .row(" b b b b")
                .row("b b b b ")
                .build();
        game.getTurn().change();
        assertEquals(Error.BAD_DISTANCE, game.isCorrect(origin, target));
    }

    @Test
    public void testGivenGameWhenWhitePiecesAreBlockedThenIsBlockedTrue() {
        Game game = new GameBuilder()
                .row(" n n    ")
                .row("n b n   ")
                .row("        ")
                .row("  n     ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("        ")
                .build();
        assertEquals(Color.WHITE, game.getTurn().getColor());
        assertTrue(game.isBlocked());
    }

    @Test
    public void testGivenGameWhenBlackPiecesAreBlockedThenIsBlockedTrue() {
        Game game = new GameBuilder()
                .row("        ")
                .row("        ")
                .row("        ")
                .row("  b     ")
                .row("        ")
                .row("        ")
                .row("n n     ")
                .row(" b b    ")
                .build();
        game.getTurn().change();
        assertEquals(Color.BLACK, game.getTurn().getColor());
        assertTrue(game.isBlocked());
    }
}
