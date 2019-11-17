package jogo.Cenario;

import javax.swing.*;
import jogo.Personagem.*;
import jplay.*;

public class CenarioBiblioteca extends CenarioPai {

    private final Window janela;
    private final Scene cena;
    private final Jogador jogador;
    private final Keyboard teclado;
    private final NPC[] npc = new NPC[7];
    private final ImageIcon[] imgNPC = new ImageIcon[7];

    //Construtor
    public CenarioBiblioteca(Window window, int jogadorX, int jogadorY, int frame) {

        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("CenarioBiblioteca.scn"));
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
                    npc[0].conversa(jogador, "Me recomendaria algum livro?", "Albert", imgNPC[0]);
                    npc[1].conversa(jogador, "Olá Detetive! posso ajudar?!", "Agusto", imgNPC[1]);
                    npc[2].conversa(jogador, "A cidade está muito suja, como está a investigação?", "Maria", imgNPC[2]);
                    npc[3].conversa(jogador, "Caramba! você me assustou, tome mais cuidado!", "Julia", imgNPC[3]);
                    npc[4].conversaCod2(jogador, "Segundo dígito do código de desativação", imgNPC[4]);
                    npc[5].conversa(jogador, "Não estou encontrando o livro de programação. ", "Maicon", imgNPC[5]);
                    npc[6].conversa(jogador, "Desculpe mais a cadeira ao lado já está ocupada!", "Mariana", imgNPC[6]);

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
        npc[0] = new NPC(189, 68, URL.sprite("npc44.png"), 1);
        npc[1] = new NPC(634, 25, URL.sprite("npc43.png"), 1);
        npc[2] = new NPC(573, 141, URL.sprite("npc47.png"), 1);
        npc[3] = new NPC(95, 220, URL.sprite("npc52.png"), 1);
        npc[4] = new NPC(703, 231, URL.sprite("npc51.png"), 1);
        npc[5] = new NPC(370, 395, URL.sprite("npc46.png"), 1);
        npc[6] = new NPC(640, 510, URL.sprite("npc49.png"), 1);
        
        imgNPC[0] = new ImageIcon("src/recursos/sprites/npc44-img.png");
        imgNPC[1] = new ImageIcon("src/recursos/sprites/npc43-img.png");
        imgNPC[2] = new ImageIcon("src/recursos/sprites/npc47-img.png");
        imgNPC[3] = new ImageIcon("src/recursos/sprites/npc52-img.png");
        imgNPC[4] = new ImageIcon("src/recursos/sprites/npc51-img.png");
        imgNPC[5] = new ImageIcon("src/recursos/sprites/npc46-img.png");
        imgNPC[6] = new ImageIcon("src/recursos/sprites/npc49-img.png");
    }
    
    private boolean mudarCenario() {
        if (tileCollision(90, jogador, cena)) {
            return true;
        }
        return false;
    }
}
