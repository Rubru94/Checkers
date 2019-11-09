package checkersrefactor.models;

public class Session {

    private State state;

    private Game game;

    public Session() {
        this.reset();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void next() {
        this.state.next();
    }

    public void reset() {
        this.state = new State();
        this.game = new Game();
        this.state.reset();
    }

    public Error move(Coordinate origin, Coordinate target) {
        return this.game.move(origin, target);
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.game.getPiece(coordinate);
    }

    public Color getColor() {
        return this.game.getColor();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public boolean hasNoPieces() {
        return this.game.hasNoPieces();
    }

}
