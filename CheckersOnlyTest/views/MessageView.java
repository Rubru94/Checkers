package CheckersOnlyTest.views;

public enum MessageView {
    RESUME("Desea continuar"),
    PROPOSED_MOVE("Mueven las #color: "),
    TITLE("----- Damas -----"),
    WINNER("Has gando!!! ;-)"),
    LOOSER_NOPIECE("Derrota!!! Te has quedado sin fichas!!! :-("),
    LOOSER_LOCK("Derrota!!! No puedes mover tus fichas!!! :-(");

    private String message;

    private MessageView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
