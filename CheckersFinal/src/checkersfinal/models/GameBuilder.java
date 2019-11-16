package checkersfinal.models;

import java.util.ArrayList;
import java.util.List;

public class GameBuilder {

    private List<String> strings;
    private char[] piecesId = new char[]{'b', 'n', 'B', 'N'};
    private Piece[] pieces = new Piece[]{
        new Pawn(Color.WHITE),
        new Pawn(Color.BLACK),
        new Draught(Color.WHITE),
        new Draught(Color.BLACK)
    };

    public GameBuilder() {
        this.strings = new ArrayList<String>();
    }

    public GameBuilder row(String string) {
        this.strings.add(string);
        return this;
    }

    public Game build() {
        Board board = new Board();
        char character;
        for (int i = 0; i < this.strings.size(); i++) {
            for (int j = 0; j < this.strings.size(); j++) {
                character = this.strings.get(i).charAt(j);
                for (int id = 0; id < piecesId.length; id++) {
                    if (piecesId[id] == character) {
                        board.put(new Coordinate(i, j), pieces[id]);
                    }
                }
            }
        }
        return new Game(board);
    }
}
