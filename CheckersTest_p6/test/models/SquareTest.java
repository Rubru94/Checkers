package models;

import checkerstest.models.Coordinate;
import checkerstest.models.Piece;
import checkerstest.models.Square;
import checkerstest.types.Color;
import static org.junit.Assert.*;
import org.junit.Test;

public class SquareTest {

    @Test
    public void testGivenSquareWhenInstanciateThenSquareIsEmpty() {
        Square square = new Square(new Coordinate(0, 0));
        assertNull(square.getPiece());
    }

    @Test
    public void testGivenSquareWhenPutPieceThenSquareReturnPiece() {
        Square square = new Square(new Coordinate(2, 2));
        Piece piece = new Piece(Color.WHITE);
        square.put(piece);
        assertEquals(piece, square.getPiece());
    }

    @Test
    public void testGivenSquareWhenRemovePieceThenSquareReturnNull() {
        Square square = new Square(new Coordinate(2, 0));
        Piece piece = new Piece(Color.WHITE);
        square.put(piece);
        assertEquals(piece, square.getPiece());
        square.remove();
        assertNull(square.getPiece());
    }
    
    @Test
        public void testGivenSquareWhenIsEmptyThenReturnBoolean() {
        Square square = new Square(new Coordinate(2, 0));
        assertTrue(square.isEmpty());
        Piece piece = new Piece(Color.WHITE);
        square.put(piece);
        assertFalse(square.isEmpty());
    }
}
