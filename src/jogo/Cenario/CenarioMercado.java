package jogo.Cenario;

import javax.swing.*;
import jogo.Personagem.*;
import jplay.*;

public class CenarioMercado extends CenarioPai {

    private final Window janela;
    private final Scene cena;
    private final Jogador jogador;
    private final Keyboard teclado;
    private final NPC[] npc = new NPC[9];
    private final ImageIcon[] imgNPC = new ImageIcon[9];

    //Construtor
    public CenarioMercado(Window window, int jogadorX, int jogadorY, int frame) {

        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("CenarioMercado.scn"));
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

            if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                try {
                    npc[0].conversa(jogador, "Aproveitando as promoções hoje. ", "Larissa", imgNPC[0]);
                    npc[1].conversa(jogador, "Não estou encontrando o que queria.", "Pedro", imgNPC[1]);
                    npc[2].conversaCod7(jogador, "Sétimo dígito do código de desativação", imgNPC[2]);
                    npc[3].conversa(jogador, "Ainda não sei o que levar. Esqueci a lista de compras em casa.", "João", imgNPC[3]);
                    npc[4].conversa(jogador, "Isso parece estar bom né detetive?!", "Bruna", imgNPC[4]);
                    npc[5].conversa(jogador, "Até que aqui dentro não tem lixo, os seguranças fizeram um bom trabalho né detetive?!", "Stefany", imgNPC[5]);
                    npc[6].conversa(jogador, "Olá Detetive, aqui está tudo sobre controle.", "Segurança", imgNPC[6]);
                    npc[7].conversa(jogador, "Fique tranquilo, lugar mais seguro que esse só a delegacia.", "Segurança", imgNPC[7]);
                    npc[8].conversa(jogador, "Detetive você por aqui?! Veio fazer compras?", "Jade", imgNPC[8]);

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
        npc[0] = new NPC(232, 40, URL.sprite("npc48.png"), 1);
        npc[1] = new NPC(315, 200, URL.sprite("npc45.png"), 1);
        npc[2] = new NPC(355, 200, URL.sprite("npc37.png"), 1);
        npc[3] = new NPC(351, 360, URL.sprite("npc42.png"), 1);
        npc[4] = new NPC(170, 360, URL.sprite("npc41.png"), 1);
        npc[5] = new NPC(225, 520, URL.sprite("npc53.png"), 1);
        npc[6] = new NPC(728, 75, URL.sprite("npc39.png"), 1);
        npc[7] = new NPC(728, 640, URL.sprite("npc40.png"), 1);
        npc[8] = new NPC(425, 595, URL.sprite("npc50.png"), 1);

        imgNPC[0] = new ImageIcon("src/recursos/sprites/npc48-img.png");
        imgNPC[1] = new ImageIcon("src/recursos/sprites/npc45-img.png");
        imgNPC[2] = new ImageIcon("src/recursos/sprites/npc37-img.png");
        imgNPC[3] = new ImageIcon("src/recursos/sprites/npc42-img.png");
        imgNPC[4] = new ImageIcon("src/recursos/sprites/npc41-img.png");
        imgNPC[5] = new ImageIcon("src/recursos/sprites/npc53-img.png");
        imgNPC[6] = new ImageIcon("src/recursos/sprites/npc39-img.png");
        imgNPC[7] = new ImageIcon("src/recursos/sprites/npc40-img.png");
        imgNPC[8] = new ImageIcon("src/recursos/sprites/npc50-img.png");
    }

    private boolean mudarCenario() {
        if (tileCollision(2, jogador, cena)) {
            return true;
        }
        return false;
    }
}
