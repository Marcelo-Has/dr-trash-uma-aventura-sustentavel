package jogo.Cenario;

import javax.swing.*;
import jogo.Personagem.*;
import jplay.*;

public class CenarioEscola extends CenarioPai {

    private final Window janela;
    private final Scene cena;
    private final Jogador jogador;
    private final Keyboard teclado;
    private final NPC[] npc = new NPC[6];
    private final ImageIcon[] imgNPC = new ImageIcon[6];

    //Construtor
    public CenarioEscola(Window window, int jogadorX, int jogadorY, int frame) {

        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("CenarioEscola.scn"));
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
                    npc[0].conversa(jogador, "VOCÊ SABIA?\n"
                            + "\n"
                            + "       Sustentabilidade é a capacidade de sustentação ou conservação de um processo ou sistema.\n"
                            + "   A palavra sustentável deriva do latim sustentare e significa sustentar, apoiar, conservar e cuidar.\n"
                            + "   O conceito de sustentabilidade aborda a maneira como se deve agir em relação à natureza. Além      disso, ele pode ser aplicado desde uma comunidade até todo o planeta.\n"
                            + "   A sustentabilidade é alcançada através do Desenvolvimento Sustentável, definido como:\n"
                            + "                 \"O desenvolvimento que satisfaz as necessidades do presente sem comprometer a"
                            + "\n                   capacidade das gerações futuras de satisfazerem suas próprias necessidades\".\n" + "\n"
                            + "           Tripé da Sutentabilidade:\n"
                            + "\n"
                            + "       O chamado tripé da sustentabilidade é baseado em três princípios: o social, o ambiental e o" + "\n"
                            + "   econômico. Esses três fatores precisam ser integrados para que a sustentabilidade de fato" + "\n"
                            + "   aconteça. Sem eles, a sustentabilidade não se sustenta.\n"
                            + "   SOCIAL: Engloba as pessoas e suas condições de vida, como educação, saúde, violência, lazer," + "\n"
                            + "                   dentre outros aspectos.\n"
                            + "   AMBIENTAL: Refere-se aos recursos naturais do planeta e a forma como são utilizados pela" + "\n"
                            + "                           sociedade, comunidades ou empresas.\n"
                            + "   ECONÔMICO: Relacionado com a produção, distribuição e consumo de bens e serviços. A" + "\n"
                            + "                              economia deve considerar a questão social e ambiental.\n"
                            + "\n"
                            + "           Tipos de Sustentabilidade\n"
                            + "\n"
                            + "       A Sustentabilidade ambiental abrange a conservação e a manutenção do meio ambiente.\n"
                            + "   Importante notar que, para que a sustentabilidade ambiental seja efetivada, as pessoas devem" + "\n"
                            + "   estar em harmonia com o meio ambiente, para obterem melhoria na qualidade de vida.\n"
                            + "\n"
                            + "           Sustentabilidade Social\n"
                            + "\n"
                            + "   A sustentabilidade social sugere a igualdade dos indivíduos, baseado no bem-estar da" + "\n"
                            + "   população.\n"
                            + "   Para isso, é necessária a participação da população, com intuito de fortalecer as propostas de" + "\n"
                            + "   desenvolvimento social, acesso à educação, cultura e saúde. Principalmente no Brasil onde são" + "\n"
                            + "   produzidas, diariamente, cerca de 250 mil toneladas de lixo. Sendo que a cidade de São Paulo é" + "\n"
                            + "   que mais produz lixo no país, com cerca de 19 mil toneladas por dia.\n"
                            + "\n"
                            + "           Sustentabilidade Empresarial\n"
                            + "\n"
                            + "       Atualmente, muitas estratégias de responsabilidade social de empresas estão pautadas na" + "\n"
                            + "   sustentabilidade.\n"
                            + "   Produtos e ações sustentáveis na área empresarial ganham destaque e o gosto dos" + "\n"
                            + "   consumidores. As pessoas estão cada vez mais conscientes do peso ecológico e social de suas" + "\n"
                            + "   escolhas.\n"
                            + "   Nesse caso, a empresa possui uma postura de responsabilidade com os valores ambientais e" + "\n"
                            + "   sociais. Além de fundamentada na preservação do meio ambiente e melhoria da qualidade de" + "\n"
                            + "   vida das pessoas.\n"
                            + "\n"
                            + "           Sustentabilidade Econômica\n"
                            + "\n"
                            + "       A sustentabilidade econômica é fundamentada num modelo de gestão sustentável. Isso implica" + "\n"
                            + "   na gestão de adequada dos recursos naturais, que objetivam o crescimento econômico, o" + "\n"
                            + "   desenvolvimento social e melhoria da distribuição de renda.\n"
                            + "   Em resumo, corresponde à capacidade de produção, de distribuição e de utilização das riquezas" + "\n"
                            + "   produzidas pelo homem, buscando uma justa distribuição de renda.\n"
                            + "\n"
                            + "           Política Ambiental\n"
                            + "\n"
                            + "   Conceito\n"
                            + "\n"
                            + "       Política Ambiental é um conjunto de ações ordenadas e práticas tomadas por empresas e" + "\n"
                            + "   governos com o propósito de preservar o meio ambiente e garantir o desenvolvimento sustentável" + "\n"
                            + "   do planeta. Esta política ambiental deve ser norteada por princípios e valores ambientais que" + "\n"
                            + "   levem em consideração a sustentabilidade.\n"
                            + " \n"
                            + "   Importância\n"
                            + "\n"
                            + "       Atualmente, quase todos os governos e grandes empresas possuem políticas ambientais." + "\n"
                            + "   Alem de mostrar para os cidadãos e consumidores quais são os princípios ambientais seguidos," + "\n"
                            + "   as políticas ambientais servem para minimizar os impactos ambientais gerados pelo crescimento" + "\n"
                            + "   econômico e urbano.\n"
                            + "       Estas políticas são, portanto, importantes instrumentos para a garantia de um futuro com" + "\n"
                            + "   desenvolvimento e preservação ambiental. São também fundamentais para o combate ao" + "\n"
                            + "   aquecimento global do planeta (verificado nas últimas décadas), redução significativa da poluição" + "\n"
                            + "   ambiental (ar, rios, solo e oceanos) e melhoria na qualidade de vida das pessoas (principalmente" + "\n"
                            + "   dos grandes centros urbanos).\n"
                            + "\n"
                            + "           Tipos de Lixo\n"
                            + "\n"
                            + "   Introdução\n"
                            + "\n"
                            + "       O lixo gerado pelos diversos segmentos da sociedade pode ser classificado de acordo com" + "\n"
                            + "   sua composição (características físicas) e destino. Esta classificação é muito importante, pois" + "\n"
                            + "   facilita a coleta seletiva, reciclagem e definição do destino mais apropriado. Logo, são" + "\n"
                            + "   informações de muito valor para a preservação do meio ambiente e manutenção da saúde das" + "\n"
                            + "   pessoas.\n"
                            + " \n"
                            + "   Lixo orgânico\n"
                            + "\n"
                            + "       É o lixo derivado dos resíduos orgânicos. São gerados principalmente nas residências," + "\n"
                            + "   restaurantes e estabelecimentos comerciais que atuam na área de alimentação. Devem ser" + "\n"
                            + "   separados dos outros tipos de lixo, pois são destinados, principalmente, aos aterros sanitários" + "\n"
                            + "   das cidades.\n"
                            + "   Exemplos: cascas de frutas e legumes; restos de verduras, de arroz e de feijão; restos de carnes" + "\n"
                            + "   e ovos.\n"
                            + " \n"
                            + "   Lixo reciclável\n"
                            + "\n"
                            + "       É todo lixo material que pode ser utilizado no processo de transformação de outros materiais ou" + "\n"
                            + "   na fabricação de matéria-prima. São gerados nas residências, comércios e indústrias. Devem ser" + "\n"
                            + "   separados e destinados a coleta seletiva. São usados por cooperativas e empresas" + "\n"
                            + "   de reciclagem. A separação para a reciclagem deste tipo de resíduo sólido é de extrema" + "\n"
                            + "   importância, pois além de gerar empregos e renda, também contribuí para o meio ambiente. Isto" + "\n"
                            + "   ocorre, pois, este lixo não vai gerar poluição em rios, solo e mar.\n"
                            + "   Exemplos: embalagens de plástico, papelão, potes de vidro, garrafas PET, jornais e revistas" + "\n"
                            + "   usadas e objetos de metal.\n"
                            + " \n"
                            + "   Lixo industrial\n"
                            + "\n"
                            + "       São os resíduos, principalmente sólidos, originários no processo de produção das indústrias." + "\n"
                            + "   Geralmente é composto por sobras de matérias-primas, destinados à reciclagem ou reuso no" + "\n"
                            + "   processo industrial.\n"
                            + "   Exemplos: retalhos de tecido, sobras e retalhos de metal, embalagens de matéria-prima, sobras" + "\n"
                            + "   de vidro e etc.\n"
                            + " \n"
                            + "   Lixo hospitalar\n"
                            + "\n"
                            + "       São os resíduos originados em hospitais e clínicas médicas. São perigosos, pois podem" + "\n"
                            + "   apresentar contaminação e transmitir doenças para as pessoas que tiverem contato. Devem ser" + "\n"
                            + "   tratados segundo padrões estabelecidos, com todo cuidado possível. São destinados para" + "\n"
                            + "   empresas especializadas no tratamento deste tipo de lixo, onde geralmente são incinerados.\n"
                            + "   Exemplos: curativos, seringas e agulhas usadas, material cirúrgico usado, restos de" + "\n"
                            + "   medicamentos e até mesmo partes do corpo humano extraídos em procedimentos cirúrgicos.\n"
                            + " \n"
                            + "   Lixo comercial\n"
                            + "\n"
                            + "       É aquele produzido pelos estabelecimentos comerciais como, por exemplo, lojas de roupas," + "\n"
                            + "   brinquedos e eletrodomésticos. Este lixo é quase totalmente destinado à reciclagem, pois é" + "\n"
                            + "   composto, principalmente, por embalagens plásticas, papelão e diversos tipos de papéis.\n"
                            + " \n"
                            + "   Lixo verde\n"
                            + "\n"
                            + "       É aquele que resulta, principalmente, da poda de árvores, galhos, troncos, cascas e folhas que" + "\n"
                            + "   caem nas ruas. Por se tratar de matéria orgânica, poderia ser utilizado para compostagem," + "\n"
                            + "   produção de adubo orgânico e até confecção de objetos de artesanato. Infelizmente, no Brasil," + "\n"
                            + "   é destinado quase exclusivamente aos aterros sanitários.\n"
                            + " \n"
                            + "   Lixo eletrônico\n"
                            + "\n"
                            + "       São os resíduos gerados pelo descarte de produtos eletroeletrônicos que não funcionam mais" + "\n"
                            + "   ou que estão muito superados. Para não provocar a contaminação e poluição do meio ambiente," + "\n"
                            + "   o correto é fazer o descarte de lixo eletrônico em locais apropriados como, por exemplo, empresas" + "\n"
                            + "   e cooperativas que atuam na área de reciclagem.\n"
                            + "   Exemplos: televisores, rádios, impressoras, computadores, geladeiras, micro-ondas, telefones e" + "\n"
                            + "   etc.\n"
                            + " \n"
                            + "   Lixo nuclear\n"
                            + "\n"
                            + "       É aquele que é gerado, principalmente, pelas usinas nucleares. É um lixo altamente perigoso" + "\n"
                            + "   por se tratar de elemento radioativo. Devem tratados seguindo padrões rigorosos de segurança.\n"
                            + "   Exemplos: sobras de urânio utilizados em usinas nucleares e elementos radioativos que" + "\n"
                            + "   compõem aparelhos de raio-x.\n"
                            + " \n"
                            + "   Lixo espacial\n"
                            + "\n"
                            + "       É o lixo gerado a partir das atividades espaciais. Ficam na órbita terrestre, gerando uma grande" + "\n"
                            + "   poluição espacial.\n"
                            + "   Exemplos: satélites desativados, ferramentas perdidas em missões espaciais, resíduos de tintas" + "\n"
                            + "   e pedaços de foguetes espaciais.\n"
                            + "\n"
                            + "           Compostagem\n"
                            + "\n"
                            + "   Definição\n"
                            + "\n"
                            + "       Compostagem é um processo de transformação de matéria orgânica, encontrada no lixo, em" + "\n"
                            + "   adubo orgânico (composto orgânico). É considerada uma espécie de reciclagem do lixo orgânico,"
                            + "   pois o adubo gerado pode ser usado na agricultura ou em jardins e plantas.\n"
                            + "   A compostagem é realizada com o uso dos próprios microrganismos presentes nos resíduos, em" + "\n"
                            + "   condições ideais de temperatura, aeração e umidade.\n"
                            + "\n"
                            + "   Importância para o meio ambiente e saúde das pessoas \n"
                            + "\n"
                            + "       A compostagem, usada principalmente na zona rural, é de extrema importância para o meio" + "\n"
                            + "   ambiente e para a saúde dos seres humanos. O lixo orgânico, muitas vezes, é descartado em" + "\n"
                            + "   lixões, ruas, rios e matas, poluindo o meio ambiente. Além disso, o acúmulo de resíduos" + "\n"
                            + "   orgânicos a céu aberto favorece o desenvolvimento de bactérias, vermes e fungos que causam" + "\n"
                            + "   doenças nos seres humanos. Além disso, favorece o desenvolvimento de insetos, ratos e outros" + "\n"
                            + "   animais que podem transmitir doenças aos homens.\n"
                            + "   Com a compostagem, além de se evitar a poluição e gerar renda, faz com que a matéria orgânica" + "\n"
                            + "   volte a ser usada de forma útil.", "Professor", imgNPC[0]);
                    npc[1].conversa(jogador, "Olá detetive, sim eu estou de castigo de novo.", "Fagner", imgNPC[1]);
                    npc[2].conversa(jogador, "Eu realmente não tenho mais paciência para estudar matemática", "Paola", imgNPC[2]);
                    npc[3].conversa(jogador, "Acabei toda a lição, estou indo para minha casa.", "Eduarda", imgNPC[3]);
                    npc[4].conversa(jogador, "Oi detetive, só estou esperando o Fagner sair do castigo.", "Anderson", imgNPC[4]);
                    npc[5].conversa(jogador, "Estudando um pouco para a prova do mês que vem.", "Jennifer", imgNPC[5]);

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
        npc[0] = new NPC(350, 145, URL.sprite("npc18.png"), 1);
        npc[1] = new NPC(650, 125, URL.sprite("npc54.png"), 1);
        npc[2] = new NPC(465, 345, URL.sprite("npc60.png"), 1);
        npc[3] = new NPC(219, 315, URL.sprite("npc59.png"), 1);
        npc[4] = new NPC(316, 445, URL.sprite("npc55.png"), 1);
        npc[5] = new NPC(605, 575, URL.sprite("npc58.png"), 1);

        imgNPC[0] = new ImageIcon("src/recursos/sprites/npc18-img.png");
        imgNPC[1] = new ImageIcon("src/recursos/sprites/npc55-img.png");
        imgNPC[2] = new ImageIcon("src/recursos/sprites/npc60-img.png");
        imgNPC[3] = new ImageIcon("src/recursos/sprites/npc59-img.png");
        imgNPC[4] = new ImageIcon("src/recursos/sprites/npc54-img.png");
        imgNPC[5] = new ImageIcon("src/recursos/sprites/npc58-img.png");
    }

    private boolean mudarCenario() {
        if (tileCollision(50, jogador, cena)) {
            return true;
        }
        return false;
    }
}
