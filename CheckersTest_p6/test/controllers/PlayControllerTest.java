package controllers;

import checkerstest.models.Coordinate;
import checkerstest.models.Game;
import checkerstest.controllers.PlayController;
import checkerstest.models.Piece;
import checkerstest.types.Color;
import checkerstest.types.Error;
import static org.junit.Assert.*;
import org.junit.Test;

public class PlayControllerTest {

    public PlayControllerTest() {

    }

    @Test
    public void givenPlayControllerWhenMovementRequireCorrectThenNotError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(5, 1);
        Coordinate target = new Coordinate(4, 2);
        PlayController playController = new PlayController(game);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    @Test
    public void givenPlayControllerWhenMovementIsOnSameSquareThenError() {
        PlayController playController = new PlayController(new Game());
        Error error = playController.move(new Coordinate(5, 1), new Coordinate(5, 1));
        assertNotNull(error);
        assertEquals(Error.NOT_ADVANCED, error);
    }
    
    @Test
    public void givenPlayControllerWhenMoveFromOrToOuterSquareThenError() {
        PlayController playController = new PlayController(new Game());
        Error error = playController.move(new Coordinate(8, 2), new Coordinate(9, 4));
        assertNotNull(error);
        assertEquals(Error.OUT_COORDINATE, error);
    }

    @Test
    public void givenPlayControllerWhenMoveIncorrectPieceThenError() {
        PlayController playController = new PlayController(new Game());
        Error error = playController.move(new Coordinate(2, 2), new Coordinate(3, 3));
        assertNotNull(error);
        assertEquals(Error.OPPOSITE_PIECE, error);
    }
}
