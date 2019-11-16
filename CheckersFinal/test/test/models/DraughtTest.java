package test.models;

import checkersfinal.models.Color;
import checkersfinal.models.Coordinate;
import checkersfinal.models.Draught;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DraughtTest {

    @Test
    public void testGivenPawnWhenIsAdvancedThenTrue() {
        assertTrue(new Draught(Color.WHITE).isAdvanced(new Coordinate(2, 3), new Coordinate(3, 4)));
        assertTrue(new Draught(Color.BLACK).isAdvanced(new Coordinate(4, 1), new Coordinate(5, 2)));
        assertTrue(new Draught(Color.BLACK).isAdvanced(new Coordinate(6, 1), new Coordinate(2, 4)));
    }
}
