import java.awt.*;
import java.awt.Component;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Roomba {
    public static void main(String[] args) {
        // TODO Chamar Tela, sim já quero montar direto na tela

        //Colocar o nome da janela
        String NomeJanela = "Aspirador";

        //criar a janela e colocar o seu conteudo
        GraphicUserInterface a = new GraphicUserInterface(NomeJanela);
    }
}

/**
 * GraphicUserInterface
 */
//Configura a janela, e a posição
class GraphicUserInterface extends JFrame {
    GraphicUserInterface(String Name) {
        OrganizadorGUI pp = new OrganizadorGUI();
        getContentPane().add(pp);
        setTitle(Name);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class OrganizadorGUI extends JPanel {
//variaveis globais da classe

//construtor
    OrganizadorGUI(){
        setLayout(new BorderLayout());
        //Parte da esquerda.
        
        JPanel Tabuleiro = new JPanel();
        add("West", Tabuleiro);
        //TODO Montar tabuleiro apartir da Sala

        JTable Tabela = new JTable(6,6);
        Tabuleiro.add(Tabela);

        //Parte da direita
        JPanel Luzes = new JPanel();
        Luzes.setLayout(new BoxLayout(Luzes, BoxLayout.Y_AXIS));
        add("East", Luzes);

        JPanel Sensores = new JPanel();
        Sensores.add(new JLabel("Sensores"));
        Luzes.add(Sensores);
        //TODO Adicionar luzes dos sensores: sujeira e parede

        JPanel Atuadores = new JPanel();
        Atuadores.add(new JLabel("Atuadores"));
        Luzes.add(Atuadores);
        //TODO Adicionar luz dos Atuadores: Sugador, Movimento e direção.
        
        JPanel Controle = new JPanel();
        Controle.add(new JLabel("Controle"));
        Luzes.add(Controle);
        //TODO Adicionar luz do Controle: Ação.

    }
}

/**
 * Aspirador
 */
public class Aspirador {

    protected int Linha;
    protected int Coluna;
    protected int Direcao;
    protected int Interruptor;

    Aspirador(int Linha, int Coluna) {

    }

    void Ligar() {

    }

    protected void Desligar() {

    }

    protected boolean EstaLigado() {

    }

    protected int QualAcaoRalizar() {

    }

    protected void MudarDirecao() {

    }

    protected boolean JaPercorreuTodaSala() {

    }

    protected boolean Mover(Sala Sala) {

    }

    void Limpar(Sala Sala) {

    }
}

/**
 * Sala
 */
public class Sala {

    protected boolean Sala[][] = new boolean[5][5];
    int QtdLinhas;
    int QtdColunas;

    Sala() {

    }

    void Sujar(int Linha, int Coluna) {

    }

    boolean EstaSujo(int Linha, int Coluna) {

    }

    void Limpar(int Linha, int Coluna) {

    }

    boolean EstaNoLimite(int Linha, int Coluna) {

    }

    int QtdLinhas() {

    }

    int QtdColunas() {

    }
}

class Porco {
    Porco() {

    }

    void Sujar() {

    }
}

/**
 * Sugador
 */
protected class Sugador {

    void Ativar(int Linha, int Coluna, Sala Sala) {

    }
}

/**
 * Esteira
 */

protected class Norte {
    void Ativar(int Linha, int Coluna) {

    }
}

protected class Sul {
    void Ativar(int Linha, int Coluna) {

    }
}

protected class leste {
    void Ativar(int Linha, int Coluna) {

    }
}

protected class Oeste {
    void Ativar(int Linha, int Coluna) {

    }
}

/**
 * Sensor
 */

protected class SensorSujeira {

    Boolean Ativar(int Linha, int Coluna, Sala Sala) {

    }
}

protected class SensorParede {

    Boolean Ativar(int Linha, int Coluna, Sala Sala) {

    }
}