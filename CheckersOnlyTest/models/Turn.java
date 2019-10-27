package CheckersOnlyTest.models;

import CheckersOnlyTest.types.Color;

public class Turn {

    private Color color;

    public Turn(Color color){
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public void switchTurn(){
        
        if(this.color.ordinal()==0)
            this.color=Color.values()[this.color.ordinal() + 1];
        else 
            this.color=Color.values()[this.color.ordinal() - 1];
    }
}