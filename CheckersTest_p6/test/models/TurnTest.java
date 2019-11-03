package models;

import checkerstest.models.Turn;
import checkerstest.types.Color;
import static org.junit.Assert.*;
import org.junit.Test;

public class TurnTest {
    
    @Test
    public void testGivenTurnWhenInstanciateThenTurnColorWhite() {
        assertEquals(Color.WHITE, new Turn().getColor());
    }
    
    @Test
    public void testGivenTurnWhenOneTurnChangesThenTurnChanges() {
        Turn turn = new Turn();
        assertEquals(Color.WHITE, turn.getColor());
        turn.change();
        assertEquals(Color.BLACK, turn.getColor());
    }
    
    @Test
    public void testGivenTurnWhenTwoTurnChangesThenTurnChanges() {
        Turn turn = new Turn();
        assertEquals(Color.WHITE, turn.getColor());
        turn.change();
        assertEquals(Color.BLACK, turn.getColor());
        turn.change();
        assertEquals(Color.WHITE, turn.getColor());
    }
    
    @Test
    public void testGivenTurnWhenIsColorThenCorrectTurnColor() {
        Turn turn = new Turn();
        assertTrue(turn.isColor(Color.WHITE));
        turn.change();
        assertTrue(turn.isColor(Color.BLACK));
    }
}
