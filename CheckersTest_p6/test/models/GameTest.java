package models;

import checkerstest.models.Coordinate;
import checkerstest.models.Game;
import checkerstest.types.Color;
import checkerstest.types.Error;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Mock
    Game gameMock;

    private Game game;

    public GameTest() {
        game = new Game();
    }

    @Test
    public void testGivenGameWhenMoveWithOuterCoordinateThenOutCoordinateError() {
        Error error = null;
        assertNull(error);
        error = game.move(new Coordinate(4, 7), new Coordinate(3, 8));
        assertEquals(Error.OUT_COORDINATE, error);
    }

    @Test
    public void testGivenGameWhenMoveFromEmptySquareThenEmptySquareError() {
        assertEquals(Error.EMPTY_ORIGIN, game.move(new Coordinate(4, 3), new Coordinate(3, 4)));
    }

    @Test
    public void testGivenGameWhenMoveOppositePieceThenError() {
        assertTrue(game.turnIsColor(Color.WHITE));
        assertEquals(Error.OPPOSITE_PIECE, game.move(new Coordinate(2, 0), new Coordinate(3, 1)));
    }

    @Test
    public void testGivenGameWhenNotDiagonalMovementThenError() {
        assertEquals(Error.NOT_DIAGONAL, this.game.move(new Coordinate(5, 1), new Coordinate(4, 1)));
    }

    @Test
    public void testGivenGameWhenMoveWithNotAdvancedThenError() {
        assertEquals(Error.NOT_ADVANCED, game.move(new Coordinate(5, 1), new Coordinate(5, 1)));
    }

    @Test
    public void testGivenGameWhenNotEmptyTargeThenError() {

        Coordinate[][] coordinates = new Coordinate[][]{{new Coordinate(5, 1), new Coordinate(4, 2)},
        {new Coordinate(2, 4), new Coordinate(3, 3)}, {new Coordinate(4, 2), new Coordinate(3, 3)}};
        Error error = null;
        assertNull(error);
        for (int i = 0; i < coordinates.length; i++) {
            error = game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertEquals(Error.NOT_EMPTY_TARGET, error);
    }
    
    @Test
    public void testWithMockGivenGameWhenNotEmptyTargeThenError() {
        when(gameMock.move(new Coordinate(5, 1), new Coordinate(4, 2))).thenReturn(Error.NOT_EMPTY_TARGET);
    }

    @Test
    public void testGivenGameWhenCorrectMovementThenOk() {
        Coordinate origin = new Coordinate(5, 1);
        Coordinate target = new Coordinate(4, 2);
        this.game.move(origin, target);
        assertNull(this.game.getColor(origin));
        assertEquals(Color.WHITE, this.game.getColor(target));
        origin = new Coordinate(2, 2);
        target = new Coordinate(3, 3);
        this.game.move(origin, target);
        assertNull(this.game.getColor(origin));
        assertEquals(Color.BLACK, this.game.getColor(target));
    }

    @Test
    public void testGivenGameWhenMovementThenEatPiece() {
        Coordinate[][] coordinates = new Coordinate[][]{{new Coordinate(5, 1), new Coordinate(4, 0)},
        {new Coordinate(2, 2), new Coordinate(3, 1)}, {new Coordinate(4, 0), new Coordinate(2, 2)},};
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertNull(error);
        assertNull(game.getColor(new Coordinate(4, 0)));
        assertNull(game.getColor(new Coordinate(3, 1)));
        assertEquals(Color.WHITE, game.getColor(new Coordinate(2, 2)));
    }

    @Test
    public void testGivenGameWhenEatEmptyPieceThenError() {
        assertEquals(Error.EATING_EMPTY, this.game.move(new Coordinate(5, 5), new Coordinate(3, 3)));
    }

    @Test
    public void testGivenGameWhenMoveBadDistanceThenError() {
        assertEquals(Error.BAD_DISTANCE, this.game.move(new Coordinate(5, 1), new Coordinate(2, 4)));
    }

}
