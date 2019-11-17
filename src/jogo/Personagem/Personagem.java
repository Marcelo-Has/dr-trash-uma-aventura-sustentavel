package jogo.Personagem;

import jplay.*;

public class Personagem extends Sprite {

    protected int direcao = 3;
    protected boolean movendo = false;
    protected double velocidade = 1;
    
    public Personagem(String fileName, int numFrames) {
        super(fileName, numFrames);
    }

    boolean colisaoVertical(GameObject obj, GameObject obj2) {
        
        if (obj2.x + obj2.width <= obj.x) {
            return false;
        }
        if (obj.x + obj.width <= obj2.x) {
            return false;
        }
        return true;
    }

    boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
        
        if (obj2.y + obj2.height <= obj.y) {
            return false;
        }
        if (obj.y + obj.height <= obj2.y) {
            return false;
        }
        return true;
    }

}
