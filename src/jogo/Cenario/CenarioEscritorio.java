package jogo.Cenario;

import javax.swing.*;
import jogo.Personagem.*;
import jplay.*;

public class CenarioEscritorio extends CenarioPai {

    private final Window janela;
    private final Scene cena;
    private final Jogador jogador;
    private final Keyboard teclado;
    private final NPC[] npc = new NPC[8];
    private final ImageIcon[] imgNPC = new ImageIcon[8];

    //Construtor
    public CenarioEscritorio(Window window, int jogadorX, int jogadorY, int frame) {

        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("CenarioEscritorio.scn"));
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

            //Faça dos NPCs
            if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                try {
                    npc[0].conversa(jogador, "Eita detetive, ainda não fiz seu imposto de renda. Fique tranquilo que até sexta eu finalizo.", "Contador", imgNPC[0]);
                    npc[1].conversa(jogador, "Se procura informações é melhor procurar um outro responsável", "Contadora Sandra", imgNPC[1]);
                    npc[2].conversa(jogador, "Tenho que fazer uma apresentação no seminário. Espero que fique tão bom quanto ao que a sua filha fez.", "Prospectador de Recursos", imgNPC[2]);
                    npc[3].conversa(jogador, "Preciso de alguém para me ajudar com as planilhas. Desculpe detetive mas estou ocupada!", "Gerente da Contabilidade", imgNPC[3]);
                    npc[4].conversa(jogador, "Eu sou o responsável pelo Serviço de Atendimento ao Cliente. Não creio que esteja procurando por mim.", "Atendente Matheus", imgNPC[4]);
                    npc[5].conversa(jogador, "Estou trabalhando em um novo projeto, assim que terminar te mostro detetive.", "Gerente de Marketing", imgNPC[5]);
                    npc[6].conversa(jogador, "Detetive você por aqui?! Veio nos dar alguma idéia para a nova campanha?!", "Assistente de Marketing", imgNPC[6]);
                    npc[7].conversaCod1(jogador, "Primeiro dígito do código de desativação", imgNPC[7]);

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
        npc[0] = new NPC(502, 240, URL.sprite("npc30.png"), 1);
        npc[1] = new NPC(216, 365, URL.sprite("npc21.png"), 1);
        npc[2] = new NPC(55, 690, URL.sprite("npc29.png"), 1);
        npc[3] = new NPC(726, 720, URL.sprite("npc24.png"), 1);
        npc[4] = new NPC(95, 960, URL.sprite("npc28.png"), 1);
        npc[5] = new NPC(670, 1050, URL.sprite("npc31.png"), 1);
        npc[6] = new NPC(715, 1050, URL.sprite("npc26.png"), 1);
        npc[7] = new NPC(710, 320, URL.sprite("npc23.png"), 1);

        imgNPC[0] = new ImageIcon("src/recursos/sprites/npc30-img.png");
        imgNPC[1] = new ImageIcon("src/recursos/sprites/npc21-img.png");
        imgNPC[2] = new ImageIcon("src/recursos/sprites/npc29-img.png");
        imgNPC[3] = new ImageIcon("src/recursos/sprites/npc24-img.png");
        imgNPC[4] = new ImageIcon("src/recursos/sprites/npc28-img.png");
        imgNPC[5] = new ImageIcon("src/recursos/sprites/npc31-img.png");
        imgNPC[6] = new ImageIcon("src/recursos/sprites/npc26-img.png");
        imgNPC[7] = new ImageIcon("src/recursos/sprites/npc23-img.png");
    }

    private boolean mudarCenario() {
        if (tileCollision(32, jogador, cena) == true) {
            return true;
        }
        return false;
    }
}
