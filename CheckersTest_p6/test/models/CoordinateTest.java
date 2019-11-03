package models;

import checkerstest.models.Coordinate;
import static org.junit.Assert.*;
import org.junit.Test;

public class CoordinateTest {

    @Test
    public void testGivenTwoCoordinatesWhenBetweenDiagonalThenOk() {
        assertEquals(new Coordinate(1, 1), new Coordinate(2, 2).betweenDiagonal(new Coordinate(0, 0)));
        assertEquals(new Coordinate(3, 1), new Coordinate(2, 2).betweenDiagonal(new Coordinate(4, 0)));
        assertEquals(new Coordinate(3, 3), new Coordinate(2, 2).betweenDiagonal(new Coordinate(4, 4)));
        assertEquals(new Coordinate(1, 3), new Coordinate(2, 2).betweenDiagonal(new Coordinate(0, 4)));
    }

    @Test
    public void testGivenTwoCoordinatesThenDiagonalDistance() {
        assertEquals(3, new Coordinate(3, 4).diagonalDistance(new Coordinate(0, 7)));
        assertEquals(5, new Coordinate(1, 3).diagonalDistance(new Coordinate(6, 0)));
    }

}
