package jogo.Cenario;

import javax.swing.*;
import jogo.Personagem.*;
import jplay.*;

public class CenarioCassino extends CenarioPai {

    private final Window janela;
    private final Scene cena;
    private final Jogador jogador;
    private final Keyboard teclado;
    private final NPC[] npc = new NPC[9];
    private final ImageIcon[] imgNPC = new ImageIcon[9];

    //Construtor
    public CenarioCassino(Window window, int jogadorX, int jogadorY, int frame) {

        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("CenarioCassino.scn"));
        jogador = new Jogador(jogadorX, jogadorY);
        jogador.setCurrFrame(frame);
        teclado = janela.getKeyboard();

        criaNPC();
        run();

    }

    private void run() {
        while (true) {
            //System.out.println("X: " + jogador.x + " Y: " + jogador.y);

            cena.moveScene(jogador);
            jogador.caminho(cena);

            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();

            //Falas dos NPCs
            if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                try {
                    npc[0].conversa(jogador, "Este tipo de jogo não é para mim!", "Joana", imgNPC[0]);
                    npc[1].conversa(jogador, "Detetivo, você por aqui?! Aproveite e jogue um pouco.", "Balconista", imgNPC[1]);
                    npc[2].conversa(jogador, "Acredita que ela está me vencendo?!", "Sérgio", imgNPC[2]);
                    npc[3].conversa(jogador, "É muito fácil ganhar dele.", "Fernanda", imgNPC[3]);
                    npc[4].conversa(jogador, "Estou com sorte, não venha tirá-la de mim haha.", "Luana", imgNPC[4]);
                    npc[5].conversa(jogador, "Pensei que fosse mais simples jogar isso. Certeza que você se dará bem detetive.", "Kelvin", imgNPC[5]);
                    npc[6].conversa(jogador, "Detetive?! Juro que não estou trapaceando... Eu juro.", "Ramires", imgNPC[6]);
                    npc[7].conversa(jogador, "Olá detetive, vamos jogar um pouco depois que você resolver o problema da bomba ok?!", "Leandro", imgNPC[7]);
                    npc[8].conversaCod6(jogador, "Sexto dígito do código de desativação", imgNPC[8]);

                } catch (Exception e) {
                }
            }

            //Desenha, posiciona os NPCs e verifica a colisão 
            for (int i = 0; i < npc.length; i++) {
                try {
                    npc[i].x += cena.getXOffset();
                    npc[i].y += cena.getYOffset();
                    jogador.caminhoNPC(cena, npc[i]);
                    npc[i].draw();

                } catch (Exception e) {
                }
            }

            jogador.txtAll(janela);

            jogador.controle(janela, teclado);
            jogador.draw();
            janela.update();
            lerTeclado(teclado);

            if (mudarCenario() == true) {
                break;
            }
        }
    }

    protected void criaNPC() {
        npc[0] = new NPC(58, 45, URL.sprite("npc12.png"), 1);
        npc[1] = new NPC(680, 227, URL.sprite("npc11.png"), 1);
        npc[2] = new NPC(48, 395, URL.sprite("npc35.png"), 1);
        npc[3] = new NPC(48, 470, URL.sprite("npc15.png"), 1);
        npc[4] = new NPC(353, 245, URL.sprite("npc36.png"), 1);
        npc[5] = new NPC(427, 15, URL.sprite("npc33.png"), 1);
        npc[6] = new NPC(235, 337, URL.sprite("npc32.png"), 1);
        npc[7] = new NPC(415, 376, URL.sprite("npc2.png"), 1);
        npc[8] = new NPC(572, 45, URL.sprite("npc9.png"), 1);

        imgNPC[0] = new ImageIcon("src/recursos/sprites/npc12-img.png");
        imgNPC[1] = new ImageIcon("src/recursos/sprites/npc11-img.png");
        imgNPC[2] = new ImageIcon("src/recursos/sprites/npc35-img.png");
        imgNPC[3] = new ImageIcon("src/recursos/sprites/npc15-img.png");
        imgNPC[4] = new ImageIcon("src/recursos/sprites/npc36-img.png");
        imgNPC[5] = new ImageIcon("src/recursos/sprites/npc33-img.png");
        imgNPC[6] = new ImageIcon("src/recursos/sprites/npc32-img.png");
        imgNPC[7] = new ImageIcon("src/recursos/sprites/npc2-img.png");
        imgNPC[8] = new ImageIcon("src/recursos/sprites/npc9-img.png");
    }

    private boolean mudarCenario() {
        if ((tileCollision(39, jogador, cena) || (tileCollision(40, jogador, cena)) == true)) {
            return true;
        }
        return false;
    }
}
