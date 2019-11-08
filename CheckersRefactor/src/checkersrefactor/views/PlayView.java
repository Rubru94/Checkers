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
            String command = this.console.readString("Mueven las " + color + ": ");
            int origin = Integer.parseInt(command.substring(0, 2));
            int target = Integer.parseInt(command.substring(3, 5));
            error = playController.move(new Coordinate(origin / 10 - 1, origin % 10 - 1), new Coordinate(target / 10 - 1, target % 10 - 1));
            if (error != null) {
                console.writeln("Error!!!" + error.name());
                gameView.write(playController);
            }
        } while (error != null);
        if (playController.isBlocked()) {
            this.console.write(MessageView.NOT_MOVE_DEFEAT.getMessage());
        }
    }

}
