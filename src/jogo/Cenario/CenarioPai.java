package jogo.Cenario;

import java.awt.Point;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import jogo.Personagem.Jogador;
import jplay.*;

public abstract class CenarioPai {

    protected boolean tileCollision(int value, Jogador jogador, Scene cena) {

        Point min = new Point((int) jogador.x, (int) jogador.y);
        Point max = new Point((int) jogador.x + jogador.width, (int) jogador.y + jogador.height);

        Vector<?> tiles = cena.getTilesFromPosition(min, max);

        for (int i = 0; i < tiles.size(); i++) {
            TileInfo tile = (TileInfo) tiles.elementAt(i);

            if (tileCollision(jogador, tile, value) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean tileCollision(GameObject object, TileInfo tile, int value) {
        if ((tile.id == value) && object.collided(tile)) {
            return true;
        }
        return false;
    }

    protected abstract void criaNPC();

    public void lerTeclado(Keyboard teclado) {
        if (teclado.keyDown(Keyboard.ESCAPE_KEY)) {
            if (JOptionPane.showConfirmDialog(null, "Você deseja mesmo sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/recursos/sprites/jogador-img.png")) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
