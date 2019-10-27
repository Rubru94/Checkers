package test.models;

import static org.junit.Assert.*;
import CheckersOnlyTest.models.Board;
import CheckersOnlyTest.models.Coordinate;
import CheckersOnlyTest.models.Game;
import CheckersOnlyTest.models.Piece;
import CheckersOnlyTest.models.Turn;
import CheckersOnlyTest.types.Color;

public class GameTest {

    public GameTest(){

    }

	@Test
	public void givenGameWhenInstanceThenNotError() {
        Game game = new Game(new Turn(Color.BLACK), new Board(new Piece(Color.BLACK, new Coordinate(0,0))));
        assertNull(game);
	}
	
	@Test
	public void givenGameWhenSwitchTurnThenNotError() {
		Game game = new Game(new Turn(Color.BLACK), new Board(new Piece(Color.BLACK, new Coordinate(0,0))));
		assertEquals(game.switchTurn(), Color.BLACK);
		game.getTurn().switchTurn();
		assertEquals(game.switchTurn(), Color.WHITE);
	}

}