package checkersrefactor.models;

class Square {

    private Piece piece;

    Square() {
    }

    public void put(Piece piece) {
        this.piece = piece;
    }

    public Piece remove() {
        Piece piece = this.piece;
        this.piece = null;
        return piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public Color getColor() {
        if (piece == null) {
            return null;
        }
        return this.piece.getColor();
    }

}
