package jogo;

import jplay.Sprite;

public class Lixo extends Sprite{
    
    public Lixo(String fileName, int numFrames) {
        super(fileName, numFrames);
        
        this.setTotalDuration(2000);
    }
    
    public void definePosicao(int x, int y){
        this.x = x;
        this.y = y;
    }

}