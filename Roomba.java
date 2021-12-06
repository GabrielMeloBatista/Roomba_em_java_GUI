import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Roomba {
    public static void main(String[] args) {
        // Colocar o nome da janela
        String NomeJanela = "Aspirador";

        // criar a janela e colocar o seu conteudo
        GraphicUserInterface a = new GraphicUserInterface(NomeJanela);
    }
}

/**
 * GraphicUserInterface
 */
// Configura a janela, e a posição
class GraphicUserInterface extends JFrame {
    GraphicUserInterface(String Name) {
        Sala pp = new Sala();
        getContentPane().add(pp);
        setTitle(Name);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

/**
 * Aspirador
 */
class Aspirador {

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
        return false;
    }

    protected int QualAcaoRalizar() {
        return 0;
    }

    protected void MudarDirecao() {

    }

    protected boolean JaPercorreuTodaSala() {
        return false;
    }

    protected boolean Mover(Sala Sala) {
        return true;
    }

    void Limpar(Sala Sala) {

    }
}

/**
 * Sala
 */
class Sala extends JPanel {

    int QtdLinhas = QtdLinhas();
    int QtdColunas = QtdColunas();
    protected boolean Sala[][] = new boolean[QtdLinhas][QtdColunas];

    Sala() {
        setLayout(new BorderLayout());

        // Parte da esquerda.
        JTable Tabuleiro = MontarTabela();
        add("West", Tabuleiro);
        JTable Tabela = new JTable(QtdLinhas, QtdColunas);
        Tabuleiro.add(Tabela);

        // Parte da direita
        JPanel Luzes = new JPanel();
        Luzes.setLayout(new BoxLayout(Luzes, BoxLayout.Y_AXIS));
        add("East", Luzes);

        JPanel Sensores = new JPanel();
        Sensores.add(new JLabel("Sensores"));
        Luzes.add(Sensores);
        // TODO Adicionar luzes dos sensores: sujeira e parede

        JPanel Atuadores = new JPanel();
        Atuadores.add(new JLabel("Atuadores"));
        Luzes.add(Atuadores);
        // TODO Adicionar luz dos Atuadores: Sugador, Movimento e direção.

        JPanel Controle = new JPanel();
        Controle.add(new JLabel("Controle"));
        Luzes.add(Controle);
        // TODO Adicionar luz do Controle: Ação.
    }

    JTable MontarTabela() {
        JLabel AspiradorPo = new JLabel(new ImageIcon("/images/Roomba.png"));
        JTable Tabela = new JTable(QtdLinhas, QtdColunas);

        //Define o tamanho da celula
        Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < QtdColunas; i++) {
            Tabela.getColumnModel().getColumn(i).setPreferredWidth(90);
        }

        //TODO colocar imagem na celula
        return Tabela;
    }

    void Sujar(int Linha, int Coluna) {

    }

    boolean EstaSujo(int Linha, int Coluna) {
        return false;
    }

    void Limpar(int Linha, int Coluna) {

    }

    boolean EstaNoLimite(int Linha, int Coluna) {
        return false;
    }

    int QtdLinhas() {
        return 6;
    }

    int QtdColunas() {
        return 6;
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
/* protected */ class Sugador {

    void Ativar(int Linha, int Coluna, Sala Sala) {

    }
}

/**
 * Esteira
 */

/* protected */ class Norte {
    void Ativar(int Linha, int Coluna) {

    }
}

/* protected */ class Sul {
    void Ativar(int Linha, int Coluna) {

    }
}

/* protected */ class leste {
    void Ativar(int Linha, int Coluna) {

    }
}

/* protected */ class Oeste {
    void Ativar(int Linha, int Coluna) {

    }
}

/**
 * Sensor
 */

/* protected */ class SensorSujeira {

    Boolean Ativar(int Linha, int Coluna, Sala Sala) {
        return true;
    }
}

/* protected */ class SensorParede {

    Boolean Ativar(int Linha, int Coluna, Sala Sala) {
        return true;
    }
}