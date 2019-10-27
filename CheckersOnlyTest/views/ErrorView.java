package CheckersOnlyTest.views;

import CheckersOnlyTest.types.Error;

public class ErrorView {

    public static final String[] MESSAGES = {
        "Error!!! No te entiendo",
        "Error!!! No es una coordenada del tablero",
        "Error!!! No hay ficha que mover",
        "Error!!! No es una de tus fichas",
        "Error!!! No vas en diagonal",
        "Error!!! No está vacío el destino",
        "Error!!! No comes contrarias",
        "Error!!! No se puede comer tantas en un movimiento",
        "Error!!! No avanzas",
        "Error!!! No respetas la distancia",
        "Error!!! No se puede comer tantas en un salto"
    };

    protected Error error;

    public ErrorView(Error error) {
        this.error = error;
    }

    public String getMessage() {
        return ErrorView.MESSAGES[this.error.ordinal()];
    }

}
