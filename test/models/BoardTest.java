package test.models;

import static org.junit.Assert.*;
import CheckersOnlyTest.models.Board;
import CheckersOnlyTest.models.Coordinate;
import CheckersOnlyTest.models.Piece;
import CheckersOnlyTest.types.Color;

public class BoardTest {

    public BoardTest(){
        
    }
	
	@Test
	public void givenBoardWhenObtainDimensionThenNotError() {
        final Coordinate[] DIMENSION = new Coordinate[64];
		assertEquals(DIMENSION, Board.DIMENSION);
    }
    
    @Test
	public void givenBoardWhenEmptyCoordinateHasPieceThenError() {
        Board board = new Board(new Piece(Color.WHITE, new Coordinate(0, 0)));
        assertFalse(board.isEmptyCoordinate(new Coordinate(0,1)));
	}

}