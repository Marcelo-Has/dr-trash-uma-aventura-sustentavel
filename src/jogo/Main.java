package jogo;

import javax.swing.*;
import jogo.Cenario.*;
import jplay.*;

public class Main {

    public static void main(String args[]) {

        Window janela = new Window(800, 600);
        GameImage plano = new GameImage(URL.sprite("TelaInicial.jpg"));
        Keyboard teclado = janela.getKeyboard();
        Som.play("menu.mid");

        while (true) {
            plano.draw();
            janela.update();

            if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                Som.stop();
                Som.playUma("opcao.mid");
                new CenarioPergaminho(janela);
            }

            if (teclado.keyDown(Keyboard.ESCAPE_KEY)) {
                if (JOptionPane.showConfirmDialog(null, "Você deseja mesmo sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/recursos/sprites/jogador-img.png")) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
            
            if (teclado.keyDown(Keyboard.M_KEY)) {
                new CenarioCreditos(janela);
            }

        }
    }

}
