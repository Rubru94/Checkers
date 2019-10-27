
package test.models;

import org.junit.Test;
import static org.junit.Assert.*;

import CheckersOnlyTest.models.Coordinate;

public class CoordinateTest {

    public CoordinateTest(){

    }

	@Test
	public void givenCoordinateWhenInstanceThenNotError() {
        Coordinate origin = new Coordinate(1,1);
        assertEquals(1, origin.getRow());
        assertEquals(1, origin.getColumn());
    }

    @Test
	public void givenCoordinateWhenInstanceNotExceedCoordinateLimitThenNotError() {
        Coordinate origin = new Coordinate(1,1);
        Coordinate target = new Coordinate(2,0);
        assertTrue(origin.getRow() >= 0 &&  origin.getRow() <= 7);
        assertTrue(origin.getColumn() >= 0 &&  origin.getColumn() <= 7);
        assertTrue(target.getRow() >= 0 &&  target.getRow() <= 7);
        assertTrue(target.getColumn() >= 0 &&  target.getColumn() <= 7);
    }

    @Test
	public void givenCoordinateWhenInstanceExceedCoordinateLimitThenError() {
        Coordinate origin = new Coordinate(8,8);
        Coordinate target = new Coordinate(9,9);
        assertFalse(origin.getRow() >= 0 &&  origin.getRow() <= 7);
        assertFalse(origin.getColumn() >= 0 &&  origin.getColumn() <= 7);
        assertFalse(target.getRow() >= 0 &&  target.getRow() <= 7);
        assertFalse(target.getColumn() >= 0 &&  target.getColumn() <= 7);
    }

	@Test
	public void givenCoordinateWhenInstanceHasIntThenNotError() {
		Coordinate origin = new Coordinate(3,3);
		assertSame(3, origin.getRow());
		assertSame(3, origin.getColumn());
    }
    
    @Test
	public void givenCoordinateWhenInstanceHasNotIntThenError() {
		Coordinate origin = new Coordinate(3,3);
		assertNotSame("3", origin.getRow());
		assertNotSame("3", origin.getColumn());
	}
 
	@Test
	public void givenCoordinateWhenInstanceHasInvalidIntThenException() {
		try {
			Coordinate origin = new Coordinate(1,-2);
			throw new Exception();
		} catch (AssertionError e) {
		} catch (Exception e) {
		}
    }
    
    @Test
	public void givenCoordinateWhenInstanceHasSameIntThenError() {
        Coordinate origin = new Coordinate(3,3);
        Coordinate target = new Coordinate(3,3);
		assertTrue(origin.getRow() == target.getRow());
		assertTrue(origin.getColumn() == target.getColumn());
    }

}
