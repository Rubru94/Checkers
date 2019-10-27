package test.models;

import static org.junit.Assert.*;

import CheckersOnlyTest.models.Turn;
import CheckersOnlyTest.types.Color;

public class TurnTest {

    public TurnTest(){
        
    }
    
    @Test
	public void givenTurnWhenInstanceThenExpectedColor() {
		Turn turn = new Turn(Color.BLACK);
		assertEquals(Color.BLACK, turn.getColor());
	}

	@Test
	public void givenTurnWhenOneChangeThenExpectedColor() {
		Turn turn = new Turn(Color.BLACK);
		turn.switchTurn();
		assertEquals(Color.WHITE, turn.getColor());
	}

	@Test
	public void givenTurnWhenTwoChangesThenExpectedColor() {
		Turn turn = new Turn(Color.BLACK);
        turn.switchTurn();
        assertEquals(Color.WHITE, turn.getColor());
        turn.switchTurn();
        assertEquals(Color.BLACK, turn.getColor());
	}

	@Test
	public void givenTurnWhenThreeChangesThenExpectedColor() {
		Turn turn = new Turn(Color.BLACK);
        turn.switchTurn();
        assertEquals(Color.WHITE, turn.getColor());
        turn.switchTurn();
        assertEquals(Color.BLACK, turn.getColor());
        turn.switchTurn();
        assertEquals(Color.WHITE, turn.getColor());
	}
}