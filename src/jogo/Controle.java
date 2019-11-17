package jogo;

import jplay.GameObject;
import jplay.TileInfo;

public class Controle {

    //Verifica colisão com o tile do mapa
    public boolean colisao(GameObject obj, TileInfo tile) {
        if ((tile.id > 100) && obj.collided(tile)) {
            return true;
        }
        return false;
    }
    
    //Verifica Colisão com os NPCs
    public boolean colisao(GameObject obj, GameObject obj2) {
        if (obj.collided(obj2)) {
            return true;
        }
        return false;
    }

}
