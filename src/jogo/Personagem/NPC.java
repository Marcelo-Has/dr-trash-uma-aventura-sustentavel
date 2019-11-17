package jogo.Personagem;

import java.util.Random;
import javax.swing.*;
import jogo.Cenario.CenarioCreditos;
import jplay.*;

public class NPC extends Personagem {

    private String res;
    private String selecionaCod;
    private final String[] cod2 = {"Social, Ambiental e Econômico.", "Natural, Jurídico e Social.", "Natural, Ambiental e Reciclagem.", "Reduzir, Reutilizar e Reciclar."};
    private final String[] cod4 = {"Recolher, organizar e armazenar em casa o máximo de tempo que der.", "Juntar com plásticos e metais.", "Jogar no lixo comum.", "Procurar locais específicos para seu descarte."};
    private final JTextArea falaProf = new JTextArea(15, 50);

    public NPC(int x, int y, String nomeDoAquivo, int frame) {
        super(nomeDoAquivo, frame);
        this.y = y;
        this.x = x;
        this.setTotalDuration(2000);

    }

    private String selecionaCod(String cod[]) {
        return selecionaCod = cod[new Random().nextInt(cod.length)];
    }

    public void conversaCod1(Jogador jogador, String titulo, ImageIcon icone) {

        if (this.collided(jogador)) {

            if (JOptionPane.showConfirmDialog(null, "Olá detetive! Tenho um dos enigmas que precisam ser resolvidos, deseja resolver?", titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icone) == JOptionPane.YES_OPTION) {
                res = (String) JOptionPane.showInputDialog(null, "Qual o tipo de sustentabilidade que é um conjunto de medidas e políticas que visam a incorporação de preocupações e conceitos ambientais e sociais?", titulo, JOptionPane.INFORMATION_MESSAGE, icone, null, null);
                res = res.toUpperCase();
                if (res.equals("SUSTENTABILIDADE ECONÔMICA")) {
                    JOptionPane.showMessageDialog(null, "Muito bem, o primeiro dígito do código de desativação é : A.", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                } else {
                    JOptionPane.showMessageDialog(null, "Lamento detetive, resposta incorreta!", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                }
            }

        }
    }

    public void conversaCod2(Jogador jogador, String titulo, ImageIcon icone) {

        if (this.collided(jogador)) {

            if (JOptionPane.showConfirmDialog(null, "Olá detetive! Tenho um dos enigmas que precisam ser resolvidos, deseja resolver?", titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icone) == JOptionPane.YES_OPTION) {
                res = (String) JOptionPane.showInputDialog(null, "Quais os 3 princípios do tripé da sustentabilidade?", titulo, JOptionPane.INFORMATION_MESSAGE, icone, cod2, selecionaCod(cod2));
                if (res.equals(cod2[0])) {
                    JOptionPane.showMessageDialog(null, "Muito bem, o segundo dígito do código de desativação é : P.", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                } else {
                    JOptionPane.showMessageDialog(null, "Lamento detetive, resposta incorreta!", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                }
            }
        }
    }

    public void conversaCod3(Jogador jogador, String titulo, ImageIcon icone) {

        if (this.collided(jogador)) {

            if (JOptionPane.showConfirmDialog(null, "Olá detetive! Tenho um dos enigmas que precisam ser resolvidos, deseja resolver?", titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icone) == JOptionPane.YES_OPTION) {
                res = (String) JOptionPane.showInputDialog(null, "Qual é a cidade que mais produz lixo diariamente no Brasil?", titulo, JOptionPane.INFORMATION_MESSAGE, icone, null, null);
                res = res.toUpperCase();
                if (res.equals("SÃO PAULO")) {
                    JOptionPane.showMessageDialog(null, "Muito bem, o terceiro dígito do código de desativação é : S.", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                } else {
                    JOptionPane.showMessageDialog(null, "Lamento detetive, resposta incorreta!", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                }
            }

        }
    }

    public void conversaCod4(Jogador jogador, String titulo, ImageIcon icone) {

        if (this.collided(jogador)) {

            if (JOptionPane.showConfirmDialog(null, "Olá detetive! Tenho um dos enigmas que precisam ser resolvidos, deseja resolver?", titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icone) == JOptionPane.YES_OPTION) {
                res = (String) JOptionPane.showInputDialog(null, "O que fazer com o lixo eletrônico (pilhas, baterias e equipamentos quebrados)?", titulo, JOptionPane.INFORMATION_MESSAGE, icone, cod4, selecionaCod(cod4));
                if (res.equals(cod4[3])) {
                    JOptionPane.showMessageDialog(null, "Muito bem, o quarto dígito do código de desativação é : 2.", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                } else {
                    JOptionPane.showMessageDialog(null, "Lamento detetive, resposta incorreta!", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                }
            }
        }
    }

    public void conversaCod5(Jogador jogador, String titulo, ImageIcon icone) {

        if (this.collided(jogador)) {

            if (JOptionPane.showConfirmDialog(null, "Olá detetive! Tenho um dos enigmas que precisam ser resolvidos, deseja resolver?", titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icone) == JOptionPane.YES_OPTION) {
                res = (String) JOptionPane.showInputDialog(null, "Os entes sociais se preocupem em desenvolver em suas unidades uma prática que tenha ainda como escopo formar cidadãos conscientes de sua responsabilidade\n"
                        + "com o propósito de preservar o meio ambiente e garantir o desenvolvimento sustentável do planeta. Que prática é essa?", titulo, JOptionPane.INFORMATION_MESSAGE, icone, null, null);
                res = res.toUpperCase();
                if (res.equals("POLÍTICA AMBIENTAL")) {
                    JOptionPane.showMessageDialog(null, "Muito bem, o quinto dígito do código de desativação é : 3.", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                } else {
                    JOptionPane.showMessageDialog(null, "Lamento detetive, resposta incorreta!", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                }
            }
        }
    }

    public void conversaCod6(Jogador jogador, String titulo, ImageIcon icone) {

        if (this.collided(jogador)) {

            if (JOptionPane.showConfirmDialog(null, "Olá detetive! Tenho um dos enigmas que precisam ser resolvidos, deseja resolver?", titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icone) == JOptionPane.YES_OPTION) {
                res = (String) JOptionPane.showInputDialog(null, "Coleta seletiva é a coleta dos materiais recicláveis previamente separados na fonte geradora. É uma etapa importante para a reciclagem, uma vez que\n"
                        + "a seleção prévia dos recicláveis evita sua contaminação por outros componentes do lixo. A coleta seletiva contribui para a redução do volume de lixo\n"
                        + "a ser encaminhado para os aterros, ou outras formas de destinação final de resíduos. As lixeiras e caçambas utilizadas para a coleta seletiva possuem\n"
                        + "cores específicas. Qual a cor da lixeira em que se acondiciona o papel?", titulo, JOptionPane.INFORMATION_MESSAGE, icone, null, null);
                res = res.toUpperCase();
                if (res.equals("AZUL")) {
                    JOptionPane.showMessageDialog(null, "Muito bem, o sexto dígito do código de desativação é : C.", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                } else {
                    JOptionPane.showMessageDialog(null, "Lamento detetive, resposta incorreta!", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                }
            }
        }
    }

    public void conversaCod7(Jogador jogador, String titulo, ImageIcon icone) {

        if (this.collided(jogador)) {

            if (JOptionPane.showConfirmDialog(null, "Olá detetive! Tenho um dos enigmas que precisam ser resolvidos, deseja resolver?", titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icone) == JOptionPane.YES_OPTION) {
                res = (String) JOptionPane.showInputDialog(null, "Qual processo de transformação da matéria orgânica, encontrada no lixo, em adubo orgânico é considerada uma espécie de reciclagem de lixo?", titulo, JOptionPane.INFORMATION_MESSAGE, icone, null, null);
                res = res.toUpperCase();
                if (res.equals("POLÍTICA AMBIENTAL")) {
                    JOptionPane.showMessageDialog(null, "Muito bem, o sétimo dígito do código de desativação é : C.", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                } else {
                    JOptionPane.showMessageDialog(null, "Lamento detetive, resposta incorreta!", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                }
            }
        }
    }

    public void conversa(Jogador jogador, String conversa, String titulo, ImageIcon icone) {

        if (this.collided(jogador)) {
            if (titulo.equals("Professor")) {
                falaProf.setText(conversa);
                falaProf.setEditable(false);
                falaProf.setLineWrap(true);
                falaProf.setWrapStyleWord(true);
                if (JOptionPane.showConfirmDialog(null, "Você é o detetive que precisa resolver os enigmas?", titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icone) == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Pois bem. Agora te passarei todo o conteúdo necessário para resolvê-los, então preste muito atenção.", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                    JOptionPane.showMessageDialog(null, new JScrollPane(falaProf), titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                    JOptionPane.showMessageDialog(null, "Quando se deparar com um enigma e ainda tiver dúvidas, volte aqui e fale comigo novamente!", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                } else {
                    JOptionPane.showMessageDialog(null, "Então creio que está no lugar errado, pois dou aula apenas para crianças.", titulo, JOptionPane.INFORMATION_MESSAGE, icone);
                }

            } else {
                JOptionPane.showMessageDialog(null, conversa, titulo, JOptionPane.INFORMATION_MESSAGE, icone);
            }
        }

    }

    public void desativaBomba(Jogador jogador, ImageIcon icone, Window janela) {

        if (this.collided(jogador)) {

            res = (String) JOptionPane.showInputDialog(null, "Qual o código de desativação?", "Desativar Bomba", JOptionPane.INFORMATION_MESSAGE, icone, null, null);
            res = res.toUpperCase();
            if (res.equals("APS23CC")) {
                if (jogador.lixoColetado == 40) {
                    JOptionPane.showMessageDialog(null, "Meus parabéns você salvou todo mundo impedindo o lançamento, a cidade de Clean City agradece Detetive!", "Desativar Bomba", JOptionPane.INFORMATION_MESSAGE, icone);
                    new CenarioCreditos(janela);
                } else {
                    JOptionPane.showMessageDialog(null, "Você precisa coletar todo o lixo ainda.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Código incorreto.");
            }
        }
    }
}
