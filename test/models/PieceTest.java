package test.models;

import static org.junit.Assert.*;
import CheckersOnlyTest.models.Coordinate;
import CheckersOnlyTest.models.Piece;
import CheckersOnlyTest.types.Color;

public class PieceTest {

    public PieceTest(){
        
    }
    
    @Test
	public void givenPieceWhenInstanceThenNotError() {
        Piece piece = new Piece(Color.BLACK, new Coordinate(0, 2));
		assertEquals(Color.BLACK, piece.getColor());
		assertEquals(0, piece.getRow());
		assertEquals(2, piece.getColumn());
	}
	
    

}