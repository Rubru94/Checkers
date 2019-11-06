package checkerstest;

import checkerstest.controllers.PlayController;
import checkerstest.models.Game;
import checkerstest.views.CommandView;
import java.util.Scanner;

public class ConsoleCheckers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer = "";
        do {
            new CommandView(new PlayController(new Game())).interact();
            System.out.println("¿Queréis jugar otra? (s/n):");
            answer = input.nextLine();
        } while (!answer.toLowerCase().equals("n"));
    }
}
