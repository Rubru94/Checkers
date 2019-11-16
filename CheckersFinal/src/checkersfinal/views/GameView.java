package checkersfinal.views;

import checkersfinal.controllers.Controller;
import checkersfinal.models.Board;
import checkersfinal.models.Coordinate;
import checkersfinal.models.Piece;

public class GameView extends SubView {

    public void write(Controller controller) {
        assert controller != null;
        this.console.writeln();
        this.writeNumbersLine(Board.DIMENSION);
        for (int i = 0; i < Board.DIMENSION; i++) {
            this.console.write((i + 1) + "");
            for (int j = 0; j < Board.DIMENSION; j++) {
                Piece piece = controller.getPiece(new Coordinate(i, j));
                if (piece == null) {
                    this.console.write(Piece.IDS[Piece.IDS.length - 1]);
                } else {
                    for (int p = 0; p < Piece.TYPES.length; p++) {
                        if (Piece.TYPES[p].getClass() == piece.getClass() && Piece.TYPES[p].getColor() == piece.getColor()) {
                            this.console.write(Piece.IDS[p]);
                        }
                    }
                }
            }
            this.console.writeln((i + 1) + "");
        }
        this.writeNumbersLine(Board.DIMENSION);
        this.console.writeln();
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(" ");
        for (int i = 0; i < DIMENSION; i++) {
            this.console.write((i + 1) + "");
        }
        this.console.writeln();
    }

}
