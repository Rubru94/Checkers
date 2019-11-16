package test.controllers;

import checkersfinal.controllers.PlayController;
import checkersfinal.models.Color;
import checkersfinal.models.Coordinate;
import checkersfinal.models.Game;
import checkersfinal.models.State;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PlayControllerTest {

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        PlayController playController = new PlayController(new Game(), new State());
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        assertNull(playController.isCorrect(origin, target));
        playController.move(origin, target);
        assertNull(playController.getPiece(origin));
        assertEquals(playController.getPiece(target).getColor(), Color.WHITE);
    }
}
