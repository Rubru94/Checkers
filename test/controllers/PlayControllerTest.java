package test.controllers;

import static org.junit.Assert.*;
import CheckersOnlyTest.controllers.PlayController;
import CheckersOnlyTest.models.Coordinate;
import CheckersOnlyTest.models.Game;
import CheckersOnlyTest.models.King;
import CheckersOnlyTest.models.Pawn;
import CheckersOnlyTest.models.Piece;
import CheckersOnlyTest.models.State;
import CheckersOnlyTest.types.Color;

public class PlayControllerTest {

    public PlayControllerTest() {

    }

    @Test
    public void givenPlayControllerWhenMovementRequireCorrectThenNotError() {
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        PlayController playController = new PlayController(game, state);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    @Test
    public void givenPlayControllerWhenIncorrectPieceMovementThenError() {
        Game game = new Game();
        State state = new State();
        PlayController playController = new PlayController(game, state);

        Coordinate origin = new Coordinate(2, 2);
        Coordinate target = new Coordinate(1, 1);

        Piece pieceOrigin = playController.getPiece(origin);
        
        assertNull(playController.move(origin, target));
        assertNull(pieceOrigin);
        assertSame(new Pawn(Color.BLACK), pieceOrigin);
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    @Test
	public void givenPlayControllerWhenMoveToAlreadyUsedCoordinateThenError() {
        Game game = new Game();
        State state = new State();
        PlayController playController = new PlayController(game, state);
        Coordinate origin = new Coordinate(0, 2);
        Coordinate target = new Coordinate(2, 2);
		Piece blackPiece = new Piece(Color.BLACK, origin);
        Piece whitePiece = new Piece(Color.WHITE, target);
        assertNull(playController.move(origin, target));
	}

    @Test
	public void givenPlayControllerWhenIncorrectMoveThenError() {
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(1, 1);
        Coordinate target = new Coordinate(2, 1);
        PlayController playController = new PlayController(game, state);
        assertTrue(playController.isValidCoordinate(origin));
        assertTrue(playController.isValidCoordinate(target));
	}

    @Test
	public void givenPlayControllerWhenPieceArrivesLastRowThenConvertToKing() {
        Game game = new Game();
        State state = new State();
        PlayController playController = new PlayController(game, state);

        Coordinate origin = new Coordinate(6, 0);
        Coordinate target = new Coordinate(7, 1);

        Piece piece = playController.getPiece(origin);
        
        assertSame(new Pawn(piece.getColor(),origin), piece);
        assertNull(playController.move(origin, target));
        assertSame(new King(piece.getColor(),origin), piece);  
	}
}