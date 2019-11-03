package models;

import checkerstest.models.Board;
import checkerstest.models.Coordinate;
import checkerstest.types.Color;
import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {

    private Board board;

    public BoardTest() {
        this.board = new Board();
    }

    @Test
    public void testGivenNewBoardThenGoodPiecesLocation() {

        for (int i = 0; i < Board.EMPTY_PIECES_START_ROW; i++) {
            for (int j = i % 2; j < Board.DIMENSION; j = j + 2) {
                Coordinate coordinate = new Coordinate(i, j);
                Color color = board.getColor(coordinate);
                assertTrue(coordinate.isBlack());
                assertNotNull(color);
                assertEquals(Color.BLACK, color);
            }
        }
        for (int i = Board.EMPTY_PIECES_FINISH_ROW; i < Board.DIMENSION; i++) {
            for (int j = i % 2; j < Board.DIMENSION; j = j + 2) {
                Coordinate coordinate = new Coordinate(i, j);
                Color color = board.getColor(coordinate);
                assertTrue(coordinate.isBlack());
                assertNotNull(color);
                assertEquals(Color.WHITE, color);
            }
        }

    }
}
