package test.models;

import checkersfinal.models.Color;
import checkersfinal.models.Coordinate;
import checkersfinal.models.Draught;
import checkersfinal.models.Game;
import checkersfinal.models.GameBuilder;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameWithDraughtsTest {

    @Test
    public void testGivenGameWhenWhitePawnReachLimitThenNewDraugts() {
        Coordinate origin = new Coordinate(1, 0);
        Coordinate target = new Coordinate(0, 1);
        Game game = new GameBuilder()
                .row("        ")
                .row("b       ")
                .row("   n    ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("        ")
                .build();
        game.move(origin, target);
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.WHITE, game.getPiece(target).getColor());
    }

    @Test
    public void testGivenGameWhenWhitePawnReachLimitAndEatingThenNewDraugts() {
        Coordinate origin = new Coordinate(2, 0);
        Coordinate target = new Coordinate(0, 2);
        Game game = new GameBuilder()
                .row("        ")
                .row(" n      ")
                .row("b       ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("        ")
                .build();
        game.move(origin, target);
        assertEquals(null, game.getPiece(origin.betweenDiagonal(target)));
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.WHITE, game.getPiece(target).getColor());
    }

    @Test
    public void testGivenGameWhenBlackPawnReachLimitThenNewDraugts() {
        Coordinate origin = new Coordinate(6, 3);
        Coordinate target = new Coordinate(7, 2);
        Game game = new GameBuilder()
                .row("        ")
                .row(" n      ")
                .row("b       ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("   n    ")
                .row("        ")
                .build();
        game.getTurn().change();
        game.move(origin, target);
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.BLACK, game.getPiece(target).getColor());
    }

    @Test
    public void testGivenGameWhenBlackPawnReachLimitAndEatingThenNewDraugts() {
        Coordinate origin = new Coordinate(5, 4);
        Coordinate target = new Coordinate(7, 2);
        Game game = new GameBuilder()
                .row("        ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("    n   ")
                .row("   b    ")
                .row("        ")
                .build();
        game.getTurn().change();
        game.move(origin, target);
        assertEquals(null, game.getPiece(origin.betweenDiagonal(target)));
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.BLACK, game.getPiece(target).getColor());
    }

    @Test
    public void testGivenGameWhenWhiteDraughtMoveAnyDiagonalDirectionThenNotError() {
        Coordinate origin = new Coordinate(0, 1);
        Coordinate target = new Coordinate(2, 3);
        Game game = new GameBuilder()
                .row(" B      ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("    n   ")
                .row("        ")
                .row("        ")
                .build();
        game.getBoard().remove(origin);
        game.getBoard().put(origin, new Draught(Color.WHITE));
        game.move(origin, target);
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.WHITE, game.getPiece(target).getColor());
    }

    @Test
    public void testGivenGameWhenBlackDraughtMoveAnyDiagonalDirectionThenNotError() {
        Coordinate origin = new Coordinate(5, 4);
        Coordinate target = new Coordinate(1, 0);
        Game game = new GameBuilder()
                .row(" B      ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("    N   ")
                .row("        ")
                .row("        ")
                .build();
        game.getBoard().remove(origin);
        game.getBoard().put(origin, new Draught(Color.BLACK));
        game.getTurn().change();
        game.move(origin, target);
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.BLACK, game.getPiece(target).getColor());
    }
}
