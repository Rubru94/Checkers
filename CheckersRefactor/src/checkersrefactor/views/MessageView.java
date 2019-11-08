package checkersrefactor.views;

import checkersrefactor.utils.Console;

public enum MessageView {

    TITLE("Draughts"),
    PLAY_AGAIN("¿Queréis jugar otra"),
    NOT_MOVE_DEFEAT("Derrota!!! No puedes mover tus fichas!!!");

    private String message;
    private static Console console = new Console();

    private MessageView(String message) {
        this.message = message;
    }

    public void write() {
        MessageView.console.write(this.message);
    }

    public void writeln() {
        MessageView.console.write(this.message);
    }
    
    public String getMessage() {
        return this.message;
    }
}
