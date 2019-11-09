package checkersrefactor.views;

import checkersrefactor.controllers.Controller;
import checkersrefactor.models.Board;
import checkersrefactor.models.Color;
import checkersrefactor.models.Coordinate;

public class GameView extends SubView {

    private static final String[] COLORS = new String[]{"b", "n", " "};
    
    public void write(Controller controller) {
        this.console.writeln();
        this.writeNumbersLine(Board.DIMENSION);
        for (int i = 0; i < Board.DIMENSION; i++) {
            this.console.write((i + 1) + "");
            for (int j = 0; j < Board.DIMENSION; j++) {
                Color color = controller.getColor(new Coordinate(i, j));
                if (color == null) {
                    this.console.write(GameView.COLORS[2]);
                } else {
                    this.console.write(GameView.COLORS[color.ordinal()]);
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
