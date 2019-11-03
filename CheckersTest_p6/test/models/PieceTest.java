package models;

import checkerstest.models.Coordinate;
import checkerstest.models.Piece;
import checkerstest.types.Color;
import static org.junit.Assert.*;
import org.junit.Test;

public class PieceTest {

    @Test
    public void testGivenPieceWhenIsAdvancedThenTrue() {
        assertTrue(new Piece(Color.WHITE).isAdvanced(new Coordinate(5, 0), new Coordinate(4, 1)));
        assertTrue(new Piece(Color.BLACK).isAdvanced(new Coordinate(2, 1), new Coordinate(3, 2)));
    }

    @Test
    public void testGivenPieceWhenNotIsAdvancedThenFalse() {
        assertFalse(new Piece(Color.WHITE).isAdvanced(new Coordinate(5, 0), new Coordinate(6, 1)));
        assertFalse(new Piece(Color.BLACK).isAdvanced(new Coordinate(2, 1), new Coordinate(1, 2)));
    }

    @Test
    public void testGivenPieceWhenIsValidColorAdvancedThenTrue() {
        Coordinate origin = new Coordinate(5, 1);
        Coordinate target = new Coordinate(4, 2);
        assertTrue(origin.isBlack());
        assertTrue(target.isBlack());
        assertTrue(new Piece(Color.WHITE).isAdvanced(origin, target));
    }

    @Test
    public void testGivenPieceWhenIsNotValidColorAdvancedThenTrue() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        assertFalse(origin.isBlack());
        assertFalse(target.isBlack());
        assertTrue(new Piece(Color.WHITE).isAdvanced(origin, target));
    }
}
