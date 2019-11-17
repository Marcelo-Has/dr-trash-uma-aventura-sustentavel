package jogo.Cenario;

import javax.swing.*;
import jogo.Personagem.*;
import jplay.*;

public class CenarioCasa1 extends CenarioPai {

    private final Window janela;
    private final Scene cena;
    private final Jogador jogador;
    private final Keyboard teclado;
    private final NPC[] npc = new NPC[3];
    private final ImageIcon[] imgNPC = new ImageIcon[3];

    //Construtor
    public CenarioCasa1(Window window, int jogadorX, int jogadorY, int frame) {

        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("CenarioCasa1.scn"));
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

            ///Falas dos NPCs
            if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                try {
                    npc[0].conversa(jogador, "Olá Detetive, se deseja falar com o meu marido, ele está no quarto.", "Simone", imgNPC[0]);
                    npc[1].conversa(jogador, "Eai camarada! Aceita uma cerveja? ... Desculpe, esqueci que você está em serviço", "Bruno", imgNPC[1]);
                    npc[2].conversaCod4(jogador, "Quarto dígito do código de desativação", imgNPC[2]);

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
    
    protected void criaNPC(){
        npc[0] = new NPC(65, 400, URL.sprite("npc6.png"), 1);
        npc[1] = new NPC(570, 80, URL.sprite("npc7.png"), 1);
        npc[2] = new NPC(696, 468, URL.sprite("npc8.png"), 1);
        
        imgNPC[0] = new ImageIcon("src/recursos/sprites/npc6-img.png");
        imgNPC[1] = new ImageIcon("src/recursos/sprites/npc7-img.png");
        imgNPC[2] = new ImageIcon("src/recursos/sprites/npc8-img.png");
    }
    
    private boolean mudarCenario() {
        if ((tileCollision(60, jogador, cena) || (tileCollision(61, jogador, cena)) == true)) {
            return true;
        }
        return false;
    }
}
