package checkerstest.models;

import checkerstest.types.Color;

public class Turn {

    private Color color;

    public Turn() {
        this.color = Color.WHITE;
    }

    public void change() {
        this.color = Color.values()[(this.color.ordinal() + 1) % 2];
    }

    public boolean isColor(Color color) {
        return this.color == color;
    }
    
    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return this.color.name();
    }

}
