package checkerstest.views;

import checkerstest.controllers.PlayController;
import checkerstest.models.Coordinate;
import checkerstest.types.Color;
import checkerstest.utils.Console;
import checkerstest.types.Error;

public class CommandView {

    private Console console;

    private PlayController playController;

    private static final String[] COLORS = {"blancas", "negras"};

    public CommandView(PlayController playController) {
        this.playController = playController;
        this.console = new Console();
    }

    public void interact() {
        String color = null;
        int numPieces = -1;
        Error error = null;
        String command = "";
        do {
            color = CommandView.COLORS[playController.getColor().ordinal()];
            numPieces = this.playController.getNumberOfPieces(playController.getColor());
            this.playController.printBoard();
            System.out.println("Piezas " + color + " disponibles:" + numPieces);
            command = this.console.readString("Mueven las " + color + ": ");
            System.out.println("Entro:" + command + ":");
            if (!command.equals("-1")) {
                try {
                    int origin = Integer.parseInt(command.substring(0, 2));
                    int target = Integer.parseInt(command.substring(3, 5));
                    error = playController.move(new Coordinate(origin / 10, origin % 10), new Coordinate(target / 10, target % 10));
                    if (error != null) {
                        console.write("Error!!!" + error.name() + "\n");
                    }
                } catch (NumberFormatException e) {
                    console.write("Error!!! Formato incorrecto\n");
                } catch (StringIndexOutOfBoundsException e) {
                    console.write("Error!!! Formato incorrecto\n");
                }

            }
        } while (error != null || !command.equals("-1") && numPieces != 0);
        if (numPieces == 0) {
            System.out.println("Las " + color + " pierden.  No tienen fichas!!!");
        } else if (command.equals("-1")) {
            System.out.println("Las " + color + " se rinden!!");
        }
    }

}
