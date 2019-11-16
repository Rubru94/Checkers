package test.models;

import checkersfinal.models.Color;
import checkersfinal.models.Coordinate;
import checkersfinal.models.Pawn;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PawnTest {

    @Test
    public void testGivenPawnWhenIsAdvancedThenTrue() {
        assertTrue(new Pawn(Color.WHITE).isAdvanced(new Coordinate(5, 0), new Coordinate(4, 1)));
        assertTrue(new Pawn(Color.BLACK).isAdvanced(new Coordinate(2, 1), new Coordinate(3, 2)));
    }

    @Test
    public void testGivenPawnWhenNotIsAdvancedThenFalse() {
        assertFalse(new Pawn(Color.WHITE).isAdvanced(new Coordinate(5, 0), new Coordinate(6, 1)));
        assertFalse(new Pawn(Color.WHITE).isAdvanced(new Coordinate(5, 0), new Coordinate(5, 2)));
        assertFalse(new Pawn(Color.BLACK).isAdvanced(new Coordinate(2, 1), new Coordinate(2, 3)));
        assertFalse(new Pawn(Color.BLACK).isAdvanced(new Coordinate(2, 1), new Coordinate(1, 2)));
    }
}
