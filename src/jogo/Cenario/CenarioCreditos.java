package jogo.Cenario;

import javax.swing.*;
import jogo.Som;
import jplay.*;

public class CenarioCreditos {

    private final Window janela;
    private final Scene cena;
    private final Keyboard teclado;

    //Construtor
    public CenarioCreditos(Window window) {

        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("CenarioCreditos.scn"));
        teclado = janela.getKeyboard();

        Som.play("creditos.mid");

        run();

    }

    private void run() {
        while (true) {

            cena.draw();
            janela.update();
            lerTeclado();

            if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                Som.play("menu.mid");
                CenarioPergaminho.creditos = true;
                break;
            }
        }
    }

    public void lerTeclado() {
        if (teclado.keyDown(Keyboard.ESCAPE_KEY)) {
            if (JOptionPane.showConfirmDialog(null, "Você deseja mesmo sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/recursos/sprites/jogador-img.png")) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
