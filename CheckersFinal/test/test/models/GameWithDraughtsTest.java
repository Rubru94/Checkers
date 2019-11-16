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
}
