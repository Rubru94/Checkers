package test.controllers;

import checkersrefactor.controllers.PlayController;
import checkersrefactor.models.Color;
import checkersrefactor.models.Coordinate;
import checkersrefactor.models.Game;
import checkersrefactor.models.Piece;
import checkersrefactor.models.State;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PlayControllerTest {

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        PlayController playController = new PlayController(new Game(), new State());
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }
}
