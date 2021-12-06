import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

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
    JTable Tabela;
    DefaultTableModel ModeloTabela;
    Icon AspiradorPo;
    Icon Nada;
    int PosX = 0;// valor precisa ser definido por Aspirador
    int PosY = 0;// valor precisa ser definido por Aspirador
    // Sensores
    JCheckBox Sujeira = new JCheckBox("Sujeira");
    JCheckBox Parede = new JCheckBox("Parede");
    //Atuadores
    JCheckBox Sugador = new JCheckBox("Sugador");
    JCheckBox Movimento = new JCheckBox("Movimento");
    JCheckBox Direcao = new JCheckBox("Direção");
    //Controle
    JCheckBox Acao = new JCheckBox("ação");

    Sala() {
        Sujeira.setSelected(new SensorSujeira().Ativar(PosY, PosX));
        Parede.setSelected(new SensorParede().Ativar(PosY, PosX));

        //TODO 

        AspiradorPo = new ImageIcon("Roomba.png");
        Nada = new ImageIcon("");

        setLayout(new BorderLayout());

        // Parte da esquerda.
        // TODO Colocar imagem na tabela no lugar especificado
        // MontarTabela();
        // Tabela.setValueAt(AspiradorPo, PosX, PosY);
        // add("West", Tabela);

        // Parte da direita
        JPanel Luzes = new JPanel();

        Luzes.setLayout(new BoxLayout(Luzes, BoxLayout.Y_AXIS));
        add("East", Luzes);

        JPanel Sensores = new JPanel();

        Sensores.setLayout(new BoxLayout(Sensores, BoxLayout.Y_AXIS));
        Sensores.add(Box.createHorizontalStrut(3));
        Sensores.add(new JLabel("Sensores"));
        Sensores.add(Sujeira);
        Sensores.add(Parede);
        Luzes.add(Sensores);

        JPanel Atuadores = new JPanel();
        Atuadores.setLayout(new BoxLayout(Atuadores, BoxLayout.Y_AXIS));
        Atuadores.add(Box.createHorizontalStrut(4));
        Atuadores.add(new JLabel("Atuadores"));
        Atuadores.add(Sugador);
        Atuadores.add(Movimento);
        Atuadores.add(Direcao);
        Luzes.add(Atuadores);

        JPanel Controle = new JPanel();
        Controle.setLayout(new BoxLayout(Controle, BoxLayout.Y_AXIS));
        Controle.add(Box.createHorizontalStrut(2));
        Controle.add(new JLabel("Controle"));
        Controle.add(Acao);
        Luzes.add(Controle);
        // TODO Adicionar luz do Controle: Ação.
    }

    // TODO Concertar Erro de imagens repetidas.
    JTable MontarTabela() {
        Tabela = new JTable(QtdLinhas, QtdColunas);
        ModeloTabela = new DefaultTableModel(QtdLinhas, QtdColunas) {

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Icon.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int TamanhoCelula = 90;

        TableColumnModel ModeloCelula = Tabela.getColumnModel();

        // Define o tamanho da celula
        for (int i = 0; i < QtdColunas; i++) {
            JTableRenderer Renderer = new JTableRenderer();
            ModeloCelula.getColumn(i).setCellRenderer(Renderer);
            Tabela.getColumnModel().getColumn(i).setPreferredWidth(TamanhoCelula);
        }
        Tabela.setRowHeight(TamanhoCelula);

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
        return 5;
    }

    int QtdColunas() {
        return 5;
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

    Boolean Ativar(int Linha, int Coluna) {
        return true;
    }
}

/* protected */ class SensorParede {

    Boolean Ativar(int Linha, int Coluna) {
        return true;
    }
}