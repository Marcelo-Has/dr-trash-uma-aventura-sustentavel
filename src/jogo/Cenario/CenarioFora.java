package jogo.Cenario;

import javax.swing.*;
import jogo.Personagem.*;
import jplay.*;
import jogo.Lixo;

public class CenarioFora extends CenarioPai {

    private final Window janela;
    private final Scene cena;
    private final Jogador jogador;
    private final Keyboard teclado;
    private final NPC[] npc = new NPC[12];
    private final ImageIcon[] imgNPC = new ImageIcon[12];
    private final Lixo[] lixoPlas = new Lixo[10];
    private final Lixo[] lixoMetal = new Lixo[10];
    private final Lixo[] lixoPapel = new Lixo[10];
    private final Lixo[] lixoVidro = new Lixo[10];

    //Construtor
    public CenarioFora(Window window, int jogadorX, int jogadorY, int frame) {

        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("CenarioFora.scn"));
        jogador = new Jogador(jogadorX, jogadorY);
        jogador.setCurrFrame(frame);
        teclado = janela.getKeyboard();

        criaLixo();
        criaNPC();

        run();

    }

    private void run() {
        while (true) {

            //System.out.println("X: " + jogador.x + " Y: " + jogador.y);

            cena.moveScene(jogador);
            jogador.caminho(cena);
            jogador.controle(janela, teclado);

            if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                try {
                    npc[0].conversa(jogador, "A cidade está muito suja, espero que encontre logo o responsável", "Guilherme", imgNPC[0]);
                    npc[1].conversa(jogador, "Fique tranquilo Detetive, confiamos em você para encontrar os códigos para desativar a bomba.", "Samuel", imgNPC[1]);
                    npc[2].conversaCod3(jogador, "Terceiro dígito do código de desativação", imgNPC[2]);
                    npc[3].conversa(jogador, "O senhor é o detetive que meu pai falou que irá nos salvar né?!", "Alice", imgNPC[3]);
                    npc[4].conversa(jogador, "Minha mãe te elogiou, todos nós acreditamos em você.", "Flávio", imgNPC[4]);
                    npc[5].desativaBomba(jogador, imgNPC[5], janela);
                    npc[6].conversa(jogador, "Opa, está procurando diversão?\nAqui dentro Tem um casino ótimo, porque não dá uma olhada?!!", "Gabriel Apostador", imgNPC[6]);
                    npc[7].conversa(jogador, "Olá detetive, estou indo ao mercado fiquei sabendo que as comidas podem estragar em breve.", "Karina", imgNPC[7]);
                    npc[8].conversa(jogador, "Acabei de chegar na cidade, estou curtindo bastante!", "Viajante", imgNPC[8]);
                    npc[9].conversaCod5(jogador, "Quinto dígito do código de desativação", imgNPC[9]);
                    npc[10].conversa(jogador, "O que está havendo?!", "Turista", imgNPC[10]);
                    npc[11].conversa(jogador, "• Ande pela cidade e converse com as pessoas e descubra quais delas estão com os enigmas que precisam ser resolvidos."
                                            + "\n\n• Alguns enigmas são complicados, fale com o professor pois ele irá lhe ajudar!"
                                            + "\n\n• A cada resposta certa você receberá um código para a desativação da bomba, anote-os de acordo com sua sequência."
                                            + "\n\n• Colete todos os lixos espalhados pela cidade e depois vá falar com o senhor ao lado do foguete que está armazenando a bomba."
                                            , "Atenção", imgNPC[11]);

                } catch (Exception e) {
                }
            }

            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();

            if (teclado.keyDown(Keyboard.SPACE_KEY)) {
                for (int i = 0; i < 10; i++) {
                    if (jogador.collided(lixoPlas[i])) {
                        lixoPlas[i].hide();
                        lixoPlas[i].y = 1_000_000;
                        jogador.lixoColetado++;
                    }
                    if (jogador.collided(lixoMetal[i])) {
                        lixoMetal[i].hide();
                        lixoMetal[i].y = 1_000_000;
                        jogador.lixoColetado++;
                    }
                    if (jogador.collided(lixoPapel[i])) {
                        lixoPapel[i].hide();
                        lixoPapel[i].y = 1_000_000;
                        jogador.lixoColetado++;
                    }
                    if (jogador.collided(lixoVidro[i])) {
                        lixoVidro[i].hide();
                        lixoVidro[i].y = 1_000_000;
                        jogador.lixoColetado++;
                    }
                }
            }

            aplicaLixo();

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
            
            jogador.draw();

            jogador.textoLixo(janela, jogador);
            jogador.txtAll(janela);
            janela.update();

            lerTeclado(teclado);
            mudarCenario();
            
            if (CenarioPergaminho.creditos == true) {
                break;
            }
        }
    }

    private void aplicaLixo() {

        for (int i = 0; i < 10; i++) {
            lixoPlas[i].draw();
            lixoMetal[i].draw();
            lixoPapel[i].draw();
            lixoVidro[i].draw();

            lixoPlas[i].x += cena.getXOffset();
            lixoPlas[i].y += cena.getYOffset();
            lixoMetal[i].x += cena.getXOffset();
            lixoMetal[i].y += cena.getYOffset();
            lixoPapel[i].x += cena.getXOffset();
            lixoPapel[i].y += cena.getYOffset();
            lixoVidro[i].x += cena.getXOffset();
            lixoVidro[i].y += cena.getYOffset();
        }

    }

    protected void criaNPC() {
        npc[0] = new NPC(500, 190, URL.sprite("npc3.png"), 1);
        npc[1] = new NPC(540, 190, URL.sprite("npc4.png"), 1);
        npc[2] = new NPC(1150, 515, URL.sprite("npc13.png"), 1);
        npc[3] = new NPC(940, 900, URL.sprite("npc14.png"), 1);
        npc[4] = new NPC(980, 900, URL.sprite("npc16.png"), 1);
        npc[5] = new NPC(1120, 115, URL.sprite("npc17.png"), 1);
        npc[6] = new NPC(510, 490, URL.sprite("npc1.png"), 1);
        npc[7] = new NPC(95, 949, URL.sprite("npc10.png"), 1);
        npc[8] = new NPC(135, 355, URL.sprite("npc5.png"), 1);
        npc[9] = new NPC(650, 1220, URL.sprite("npc19.png"), 1);
        npc[10] = new NPC(715, 675, URL.sprite("npc20.png"), 1);
        npc[11] = new NPC(250, 480, URL.sprite("npc!.png"), 1);

        imgNPC[0] = new ImageIcon("src/recursos/sprites/npc3-img.png");
        imgNPC[1] = new ImageIcon("src/recursos/sprites/npc4-img.png");
        imgNPC[2] = new ImageIcon("src/recursos/sprites/npc13-img.png");
        imgNPC[3] = new ImageIcon("src/recursos/sprites/npc14-img.png");
        imgNPC[4] = new ImageIcon("src/recursos/sprites/npc16-img.png");
        imgNPC[5] = new ImageIcon("src/recursos/sprites/npc17-img.png");
        imgNPC[6] = new ImageIcon("src/recursos/sprites/npc1-img.png");
        imgNPC[7] = new ImageIcon("src/recursos/sprites/npc10-img.png");
        imgNPC[8] = new ImageIcon("src/recursos/sprites/npc5-img.png");
        imgNPC[9] = new ImageIcon("src/recursos/sprites/npc19-img.png");
        imgNPC[10] = new ImageIcon("src/recursos/sprites/npc20-img.png");
        imgNPC[11] = new ImageIcon("src/recursos/sprites/npc!-img.png");

    }

    private void criaLixo() {

        for (int y = 0; y < 10; y++) {
            lixoPlas[y] = new Lixo(URL.sprite("lixoplastico.png"), 1);
            lixoMetal[y] = new Lixo(URL.sprite("lixometal.png"), 1);
            lixoPapel[y] = new Lixo(URL.sprite("lixopapel.png"), 1);
            lixoVidro[y] = new Lixo(URL.sprite("lixovidro.png"), 1);

        }

        lixoPlas[0].definePosicao(45, 15);
        lixoPlas[1].definePosicao(100, 350);
        lixoPlas[2].definePosicao(150, 900);
        lixoPlas[3].definePosicao(600, 750);
        lixoPlas[4].definePosicao(966, 1005);
        lixoPlas[5].definePosicao(767, 168);
        lixoPlas[6].definePosicao(975, 810);
        lixoPlas[7].definePosicao(760, 1234);
        lixoPlas[8].definePosicao(1039, 70);
        lixoPlas[9].definePosicao(1151, 1194);

        lixoMetal[0].definePosicao(85, 250);
        lixoMetal[1].definePosicao(400, 35);
        lixoMetal[2].definePosicao(12, 740);
        lixoMetal[3].definePosicao(352, 464);
        lixoMetal[4].definePosicao(1019, 485);
        lixoMetal[5].definePosicao(810, 79);
        lixoMetal[6].definePosicao(598, 600);
        lixoMetal[7].definePosicao(350, 1052);
        lixoMetal[8].definePosicao(800, 900);
        lixoMetal[9].definePosicao(1164, 1022);

        lixoPapel[0].definePosicao(560, 323);
        lixoPapel[1].definePosicao(1197, 150);
        lixoPapel[2].definePosicao(327, 212);
        lixoPapel[3].definePosicao(1200, 316);
        lixoPapel[4].definePosicao(228, 1180);
        lixoPapel[5].definePosicao(1032, 702);
        lixoPapel[6].definePosicao(545, 902);
        lixoPapel[7].definePosicao(780, 990);
        lixoPapel[8].definePosicao(818, 435);
        lixoPapel[9].definePosicao(380, 612);

        lixoVidro[0].definePosicao(1280, 1250);
        lixoVidro[1].definePosicao(1207, 889);
        lixoVidro[2].definePosicao(116, 60);
        lixoVidro[3].definePosicao(13, 1025);
        lixoVidro[4].definePosicao(547, 1084);
        lixoVidro[5].definePosicao(755, 776);
        lixoVidro[6].definePosicao(128, 572);
        lixoVidro[7].definePosicao(687, 187);
        lixoVidro[8].definePosicao(965, 239);
        lixoVidro[9].definePosicao(1115, 642);
    }

    private void mudarCenario() {
        if (tileCollision(205, jogador, cena) == true) {
            new CenarioCassino(janela, 395, 510, 15);
        }

        if (tileCollision(284, jogador, cena) == true) {
            new CenarioEscritorio(janela, 383, 955, 15);
        }

        if (tileCollision(125, jogador, cena) == true) {
            new CenarioCasa1(janela, 355, 507, 15);
        }

        if (tileCollision(358, jogador, cena) == true) {
            new CenarioMercado(janela, 355, 507, 15);
        }

        if (tileCollision(363, jogador, cena) == true) {
            new CenarioEscola(janela, 355, 507, 15);
        }

        if (tileCollision(327, jogador, cena) == true) {
            new CenarioBiblioteca(janela, 360, 510, 15);
        }
    }
}
