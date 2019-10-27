package CheckersOnlyTest.models;

public class Game {

    private Turn turn;
    private Board board;

    public Game(Turn turn, Board board) {
        this.turn = turn;
        this.board = board;
    }

	public Game() {
	}

	public boolean isLooser() {
        return false;
    }

    public boolean isWinner() {
        return false;
    }

    public Turn getTurn(){
        return this.turn;
    }

    public void switchTurn(){
        this.getTurn().switchTurn();
    }

}