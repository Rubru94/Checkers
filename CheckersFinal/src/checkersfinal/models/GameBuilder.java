package checkersfinal.models;

import java.util.ArrayList;
import java.util.List;

public class GameBuilder {
    
    private List<String> strings;
    
    GameBuilder(){
        this.strings = new ArrayList<String>();
    }
    
    public GameBuilder row(String string){
        return null;
    }
    
    public Game build(){
        Board board = new Board();
        for(int i=0;i<this.strings.size();i++){
            for(int j=0;j<this.strings.size();j++){
                char character = this.strings.get(i).charAt(j);
                if(character == 'b'){
                   // board.put(new Coordinate(i,j),new Piece());
                }
            }
        }
        return new Game(board);
    }
}
