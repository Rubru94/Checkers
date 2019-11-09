package checkersrefactor.views;

import checkersrefactor.controllers.PlayController;
import checkersrefactor.models.Coordinate;
import checkersrefactor.models.Error;

public class PlayView extends SubView {

    private static final String[] COLORS = {"blancas", "negras"};

    public PlayView() {
        super();
    }

    public void interact(PlayController playController) {
        String color = PlayView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();
        do {
            try {
                String command = this.console.readString("Mueven las " + color + ": ");
                String[] input = command.split("\\.|\\n");
                error = playController.move(
                        new Coordinate(input[0]),
                        new Coordinate(input[1]));
                if (error != null) {
                    console.writeln("Error!!!" + error.name());
                }
                gameView.write(playController);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                this.console.writeln(MessageView.INVALID_FORMAT.getMessage());
            }

        } while (error != null);
        if (playController.hasNoPieces()) {
            this.console.write(MessageView.NOT_MOVE_DEFEAT.getMessage());
        }
    }

}
