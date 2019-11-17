package jogo.Personagem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.Vector;
import jogo.Controle;
import jplay.*;

public class Jogador extends Personagem {

    public int lixoColetado;
    public int lixoRestante;

    public Jogador(int x, int y) {
        super(URL.sprite("jogador.png"), 20);
        this.y = y;
        this.x = x;
        this.setTotalDuration(2000);
    }

    Controle controle = new Controle();

    public void caminho(Scene cena) {
        Point min = new Point((int) this.x, (int) this.y);
        Point max = new Point((int) this.x + this.width, (int) this.y + this.height);

        Vector<?> tiles = cena.getTilesFromPosition(min, max);

        for (int i = 0; i < tiles.size(); i++) {
            TileInfo tile = (TileInfo) tiles.elementAt(i);

            if (controle.colisao(this, tile) == true) {
                if (colisaoVertical(this, tile)) {

                    if (this.y >= tile.y + tile.height - 2) {
                        this.y = tile.y + tile.height;//Reposiciona o player
                    } else if (tile.y > this.y + this.height - 2)//o player está acima da parede
                    {
                        this.y = tile.y - this.height - 1;//Reposiciona o player
                    }
                }
                if (colisaoHorizontal(this, tile)) {
                    if (this.x >= tile.x + tile.width - 2) {
                        this.x = tile.x + tile.width + 1;
                    } else {
                        this.x = tile.x - this.width;
                    }
                }
            }
        }
    }

    public void caminhoNPC(Scene cena, GameObject npc) {
        if (controle.colisao(this, npc) == true) {
            if (colisaoVertical(this, npc)) {

                if (this.y >= npc.y + npc.height - 2) {
                    this.y = npc.y + npc.height;//Reposiciona o player
                } else if (npc.y > this.y + this.height - 2)//o player está acima da parede
                {
                    this.y = npc.y - this.height - 1;//Reposiciona o player
                }
            }
            if (colisaoHorizontal(this, npc)) {
                if (this.x >= npc.x + npc.width - 2) {
                    this.x = npc.x + npc.width + 1;
                } else {
                    this.x = npc.x - this.width;
                }
            }
        }
    }

    public void controle(Window janela, Keyboard teclado) {

        if (teclado.keyDown(Keyboard.LEFT_KEY)) {

            if (this.x > 0) {
                this.x -= velocidade;
            }
            if (direcao != 1) {
                setSequence(4, 8);
                direcao = 1;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
            if (this.x < janela.getWidth() - 50) {
                this.x += velocidade;
            }
            if (direcao != 2) {
                setSequence(8, 12);
                direcao = 2;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.UP_KEY)) {
            if (this.y > 0) {
                this.y -= velocidade;
            }
            if (direcao != 4) {
                setSequence(12, 16);
                direcao = 4;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.DOWN_KEY)) {
            if (this.y < janela.getHeight() - 50) {
                this.y += velocidade;
            }
            if (direcao != 5) {
                setSequence(0, 4);
                direcao = 5;
            }
            movendo = true;
        }

        if (movendo == true) {
            update();
            movendo = false;
        }
    }

    private int lixoRestante() {
        lixoRestante = 40 - lixoColetado;
        return lixoRestante;
    }

    Font f = new Font("arial", Font.BOLD, 15);

    public void textoLixo(Window janela, Jogador jogador) {

        janela.drawText("Lixos Coletados: " + lixoColetado, 15, 30, Color.BLACK, f);
        janela.drawText("Lixos Restantes: " + lixoRestante(), 15, 50, Color.BLACK, f);
    }

    public void txtAll(Window janela) {
        janela.drawText("Sair (Esc)", 715, 30, Color.BLACK, f);
        janela.drawText("Recolher (Espaço)", 255, 580, Color.BLACK, f);
        janela.drawText("Falar (Enter)", 435, 580, Color.BLACK, f);
    }
    
    
}
