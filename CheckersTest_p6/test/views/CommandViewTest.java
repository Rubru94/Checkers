package views;

import checkerstest.controllers.PlayController;
import checkerstest.models.Coordinate;
import checkerstest.models.Game;
import checkerstest.types.Color;
import checkerstest.types.Error;
import checkerstest.utils.Console;
import checkerstest.views.CommandView;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @Captor
    ArgumentCaptor<Error> result;

    @InjectMocks
    CommandView commandView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInteract() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenReturn("21.30\n");
        commandView.interact();
        verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
    }
    
    @Test(expected = NumberFormatException.class)
    public void testGivenPlayControllerWhenIlegalInteractThenNumberFormatException() {
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenThrow(NumberFormatException.class);
        commandView.interact();
    }

    @Test
    public void testGivenPlayControllerWhenOuterCoordinatesThenError() {
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: ")).thenReturn("99.90\n");
        commandView.interact();
        Coordinate origin = new Coordinate(9, 9);
        Coordinate target = new Coordinate(9, 0);
        verify(playController).move(origin, target);
        assertEquals(Error.OUT_COORDINATE, new PlayController(new Game()).move(origin, target));
    }

    @Test
    public void testGivenPlayControllerWhenMoveFromEmptySquareThenError() {
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: ")).thenReturn("43.34\n");
        commandView.interact();
        Coordinate origin = new Coordinate(4, 3);
        Coordinate target = new Coordinate(3, 4);
        verify(playController).move(origin, target);
        assertEquals(Error.EMPTY_ORIGIN, new PlayController(new Game()).move(origin, target));
    }

    @Test
    public void testGivenPlayControllerWhenMoveOppositePieceThenError() {
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: ")).thenReturn("22.33\n");
        commandView.interact();
        Coordinate origin = new Coordinate(2, 2);
        Coordinate target = new Coordinate(3, 3);
        verify(playController).move(origin, target);
        assertEquals(Error.OPPOSITE_PIECE, new PlayController(new Game()).move(origin, target));
    }
    
    @Test
    public void testGivenPlayControllerWhenNotDiagonalMovementThenError() {
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: ")).thenReturn("53.43\n");
        commandView.interact();
        Coordinate origin = new Coordinate(5, 3);
        Coordinate target = new Coordinate(4, 3);
        verify(playController).move(origin, target);
        assertEquals(Error.NOT_DIAGONAL, new PlayController(new Game()).move(origin, target));
    }
    
    @Test
    public void testGivenPlayControllerWhenMoveWithNotAdvancedThenError() {
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: ")).thenReturn("55.55\n");
        commandView.interact();
        Coordinate origin = new Coordinate(5, 5);
        Coordinate target = new Coordinate(5, 5);
        verify(playController).move(origin, target);
        assertEquals(Error.NOT_ADVANCED, new PlayController(new Game()).move(origin, target));
    }
    
    @Ignore
    public void testGivenPlayControllerWhenNotEmptyTargeThenError() {
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: ")).thenReturn("51.42\n");
        Coordinate origin = new Coordinate(5, 1);
        Coordinate target = new Coordinate(4, 2);
        when(playController.move(origin, target)).thenReturn(Error.NOT_EMPTY_TARGET);
        commandView.interact();
        verify(playController).move(origin, target);
    }
    
    @Test
    public void testGivenPlayControllerWhenEatEmptyPieceThenError() {
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: ")).thenReturn("53.31\n");
        commandView.interact();
        Coordinate origin = new Coordinate(5, 3);
        Coordinate target = new Coordinate(3, 1);
        verify(playController).move(origin, target);
        assertEquals(Error.EATING_EMPTY, new PlayController(new Game()).move(origin, target));
    }
    
    @Test
    public void testGivenPlayControllerWhenMoveBadDistanceThenError() {
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: ")).thenReturn("51.24\n");
        commandView.interact();
        Coordinate origin = new Coordinate(5, 1);
        Coordinate target = new Coordinate(2, 4);
        verify(playController).move(origin, target);
        assertEquals(Error.BAD_DISTANCE, new PlayController(new Game()).move(origin, target));
    }
}
