import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

interface InterfaceGraficoUI {

}

class GraficoUI extends JFrame implements InterfaceGraficoUI {
    public GraficoUI(String Titulo) {
        super(Titulo);
    }

    public void SensorSujeira() {
    };

    public void SensorParede() {
    };

    public void MoverAspirador(int Linha, int Coluna) {
    };

    public void MoverAspirador(int Linha, int Coluna, String Direcao) {
    };

    public void MudarDirecaoAspirador(String Direcao) {
    };

    public void Sugador() {
    };

    public void MostrarSujeira(int Linha, int Coluna) {
    };

    public void ApagarSujeira(int Linha, int Coluna) {
    };

    public void acaoRealizar() {
    };

    public void MostrarCaminho(int Linha, int Coluna) {
    };

}

class GUI extends GraficoUI {

    JPanel Sala;
    JLabel Sujeira, Parede, Mover, Direcao, Sugador, Acao;
    JLabel Sujeiras[][] = new JLabel[5][5];
    JLabel Aspirador;
    int Linha = 0, Coluna = 0;

    public GUI(String Titulo) {
        super(Titulo);
        setIconImage(new ImageIcon("aspiradorNE.png").getImage());
        setSize(700, 400);
        setLocation(250, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MontarLayout();
        setVisible(true);
    }

    public void SensorSujeira() {
        Sujeira.setIcon(new ImageIcon("LuzAcesa.png"));
        Tempo(100);
        Sujeira.setIcon(new ImageIcon("LuzApagada.png"));
        Tempo(100);
    }

    public void SensorParede() {
        Parede.setIcon(new ImageIcon("LuzAcesa.png"));
        Tempo(100);
        Parede.setIcon(new ImageIcon("LuzApagada.png"));
        Tempo(100);
    }

    public void MoverAspirador(int Linha, int Coluna) {
        Mover.setIcon(new ImageIcon("LuzAcesa.png"));
        Tempo(100);
        this.Linha = (Linha * 64);
        this.Coluna = (Coluna * 64);
        Aspirador.setLocation(this.Coluna, this.Linha);
        Mover.setIcon(new ImageIcon("LuzApagada.png"));
        Tempo(100);
    }

    public void MoverAspirador(int Linha, int Coluna, String Direcao) {
        int i, Delta;

        Mover.setIcon(new ImageIcon("LuzAcesa.png"));
        Tempo(100);

        if (Direcao.equalsIgnoreCase("Sul")) {
            Delta = this.Linha;
            Aspirador.setIcon(new ImageIcon("aspiradorSul.png"));
            for (i = 0; i < (Math.abs((Linha * 64) - Delta)); i++) {
                this.Linha++;
                Aspirador.setLocation(this.Coluna, this.Linha);
                Tempo(5);
            }
        }

        if (Direcao.equalsIgnoreCase("Norte")) {
            Delta = this.Linha;
            Aspirador.setIcon(new ImageIcon("aspiradorNorte.png"));
            for (i = 0; i < (Math.abs((Linha * 64) - Delta)); i++) {
                this.Linha--;
                Aspirador.setLocation(this.Coluna, this.Linha);
                Tempo(5);
            }
        }

        if (Direcao.equalsIgnoreCase("Leste")) {
            Delta = this.Coluna;
            Aspirador.setIcon(new ImageIcon("aspiradorLeste.png"));
            for (i = 0; i < (Math.abs((Coluna * 64) - Delta)); i++) {
                this.Coluna++;
                Aspirador.setLocation(this.Coluna, this.Linha);
                Tempo(5);
            }
        }

        if (Direcao.equalsIgnoreCase("Oeste")) {
            Delta = this.Coluna;
            Aspirador.setIcon(new ImageIcon("aspiradorOeste.png"));
            for (i = 0; i < (Math.abs((Coluna * 64) - Delta)); i++) {
                this.Coluna--;
                Aspirador.setLocation(this.Coluna, this.Linha);
                Tempo(5);
            }
        }

        Mover.setIcon(new ImageIcon("LuzApagada.png"));
        Tempo(100);
    }

    public void MudarDirecaoAspirador(String Direcao) {
        this.Direcao.setIcon(new ImageIcon("LuzAcesa.png"));

        String DirecaoAnterior = Aspirador.getIcon().toString();

        if (DirecaoAnterior.contains("Sul")) {
            if (Direcao.equalsIgnoreCase("Leste")) {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorSE.png"));
                Tempo(90);
            } else if (Direcao.equalsIgnoreCase("Oeste")) {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorSO.png"));
                Tempo(90);
            } else {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorNE.png"));
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorLeste.png"));
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorSE.png"));
                Tempo(90);
            }
        }

        if (DirecaoAnterior.contains("Oeste")) {
            if (Direcao.equalsIgnoreCase("Sul")) {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorSO.png"));
                Tempo(90);
            } else if (Direcao.equalsIgnoreCase("Norte")) {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorNO.png"));
                Tempo(90);
            } else {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorNE.png"));
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorNorte.png"));
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorNO.png"));
                Tempo(90);
            }
        }

        if (DirecaoAnterior.contains("Norte")) {
            if (Direcao.equalsIgnoreCase("Leste")) {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorNE.png"));
                Tempo(90);
            } else if (Direcao.equalsIgnoreCase("Oeste")) {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorNO.png"));
                Tempo(90);
            } else {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorSO.png"));
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorOeste.png"));
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorNO.png"));
                Tempo(90);
            }
        }

        if (DirecaoAnterior.contains("Leste")) {
            if (Direcao.equalsIgnoreCase("Norte")) {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorNE.png"));
                Tempo(90);
            } else if (Direcao.equalsIgnoreCase("Sul")) {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorSE.png"));
                Tempo(90);
            } else {
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorNE.png"));
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorLeste.png"));
                Tempo(90);
                Aspirador.setIcon(new ImageIcon("aspiradorSE.png"));
                Tempo(90);
            }
        }

        Aspirador.setIcon(new ImageIcon("aspirador" + Direcao + ".png"));

        Tempo(50);
        this.Direcao.setIcon(new ImageIcon("LuzApagada.png"));
        Tempo(500);
    }

    public void Sugador() {
        Sugador.setIcon(new ImageIcon("LuzAcesa.png"));
        Tempo(100);
        Sugador.setIcon(new ImageIcon("LuzApagada.png"));
        Tempo(100);
    }

    public void AcaoRealizar() {
        Acao.setIcon(new ImageIcon("LuzAcesa.png"));
        Tempo(100);
        Acao.setIcon(new ImageIcon("LuzApagada.png"));
        Tempo(100);
    }

    public void MostrarSujeira(int Linha, int Coluna) {
        Tempo(500);
        Sujeiras[Linha][Coluna].setVisible(true);
    };

    public void ApagarSujeira(int Linha, int Coluna) {
        Tempo(100);
        Sujeiras[Linha][Coluna].setVisible(false);
    };

    public void MostrarCaminho(int Linha, int Coluna) {
        // Colocar visivel caso não esteja
        Sujeiras[Linha][Coluna].setVisible(true);
        Sujeiras[Linha][Coluna].setIcon(new ImageIcon("branco.png"));
    }

    protected void Tempo(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    };

    protected void InitMatrizSujeira(JPanel Sala) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Sujeiras[j][i] = new JLabel(new ImageIcon("rastro.png"));
                Sujeiras[j][i].setBounds(0 + (i * 64), 0 + (j * 64), 64, 64);
                Sujeiras[j][i].setVisible(false);
                Sala.add(Sujeiras[j][i]);
            }
        }
    };

    protected void InitAspirador(JPanel Sala) {
        Aspirador = new JLabel(new ImageIcon("aspiradorSul.png"));
        Aspirador.setBounds(0, 0, 64, 64);
        Sala.add(Aspirador);
    };

    protected void InitSensores() {
        JPanel Sensores = new JPanel();

        Sensores.setLayout(new FlowLayout(FlowLayout.LEFT));
        Sujeira = new JLabel("Sujeira", new ImageIcon("LuzApagada.png"), JLabel.LEFT);
        Parede = new JLabel("Parede", new ImageIcon("LuzApagada.png"), JLabel.LEFT);
        Sensores.setBounds(350, 10, 165, 60);
        Sensores.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "Sensores"));
        Sensores.add(Sujeira);
        Sensores.add(Parede);
        getContentPane().add(Sensores);

    };

    protected void InitAtuadores() {
        JPanel Atuadores = new JPanel();

        Atuadores.setLayout(new FlowLayout(FlowLayout.LEFT));
        Mover = new JLabel("Movimento", new ImageIcon("LuzApagada.png"), JLabel.LEFT);
        Direcao = new JLabel("Direção", new ImageIcon("LuzApagada.png"), JLabel.LEFT);
        Sugador = new JLabel("Sugador", new ImageIcon("LuzApagada.png"), JLabel.LEFT);

        Atuadores.setBounds(350, 75, 165, 110);
        Atuadores.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "Atuadores"));
        Atuadores.add(Sugador);
        Atuadores.add(Mover);
        Atuadores.add(Direcao);
        getContentPane().add(Atuadores);

    };

    protected void InitControle() {
        JPanel Controle = new JPanel();

        Controle.setLayout(new FlowLayout(FlowLayout.LEFT));
        Acao = new JLabel("Ação", new ImageIcon("LuzApagada.png"), JLabel.LEFT);
        Controle.setBounds(350, 190, 165, 60);
        Controle.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "Controle"));
        Controle.add(Acao);
        getContentPane().add(Controle);

    };

    protected void MontarLayout() {

        setLayout(null);
        Sala = new JPanel();
        Sala.setLayout(null);
        Sala.setBounds(10, 10, 320, 320);
        Sala.setBackground(new Color(224, 248, 227));
        InitAspirador(Sala);
        InitMatrizSujeira(Sala);
        Sala.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        getContentPane().add(Sala);
        InitSensores();
        InitAtuadores();
        InitControle();

    }

}

/*
 * Parte grafica fim
 * 
 */

class ParametroPorReferencia {
    /**
     * Classe de aplicação porque foi desenvolvida para
     * resolver problemas de implementação: passagem de
     * parametro por referencia
     */
    public int valor;
}

class AdaptadorGUI {
    protected static AdaptadorGUI instancia = null;
    public static AdaptadorGUI obterInstancia() {
        if (instancia == null) {
            instancia = new AdaptadorGUI();
        }

        return instancia;
    }

    /**
     * Classe adaptadora para a Graphical User Interface
     */

    protected GUI display;

    protected AdaptadorGUI() {
        display = null;
    }

    public void setDisplay(GUI display) {
        this.display = display;
    }

    public void sensorSujeira() {
        display.SensorSujeira();
    }

    public void sensorParede() {
        display.SensorParede();
    }

    public void moverAspirador(int linha, int coluna, String direcao) {

        display.MoverAspirador(linha, coluna, direcao);

    }

    public void mudarDirecaoAspirador(String direcao) {
        display.MudarDirecaoAspirador(direcao);
    }

    public void sugador() {
        display.Sugador();
    }

    public void mostrarSujeira(int linha, int coluna) {
        display.MostrarSujeira(linha, coluna);
    }

    public void apagarSujeira(int linha, int coluna) {
        display.ApagarSujeira(linha, coluna);
    }

    public void acaoRealizar() {
        display.AcaoRealizar();
    }

    public void mostrarSala(Sala sala) {
        // Metodo provisorio para mostrar toda a sala em modo texto
        sala.texto();
    }

    public void MostrarCaminho(int linha, int coluna) {
        display.MostrarCaminho(linha, coluna);
    }
}

class Aspirador {
    protected int linha;
    protected int coluna;
    protected int direcao;
    protected boolean interruptor;
    protected Esteira[] direcoes = new Esteira[4];
    protected Esteira esteira;
    protected Sensor sensorSujeira, sensorParede;
    protected Sugador sugador;
    protected boolean[][] caminho_percorrido;

    public Aspirador(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        interruptor = false; // estado de inicialização

        direcoes[0] = new Norte();
        direcoes[1] = new Leste();
        direcoes[2] = new Sul();
        direcoes[3] = new Oeste();
        direcao = 2; // O aspirador comeca virado para o sul
        esteira = direcoes[direcao];
        sensorSujeira = new SensorSujeira();
        sensorParede = new SensorParede();
        sugador = new Sugador();

    }

    public void ligar() {
        interruptor = true;
    }

    public void limpar(Sala sala) {
        boolean condicional;
        initCaminhoPercorrido(sala);

        while (estaLigado()) {
            if (sensorSujeira.ativar(linha, coluna, sala)) { // Ve se este determinado lugar tem sujeira
                sugador.ativar(linha, coluna, sala);
            }

            condicional = false;
            while (!condicional) {
                switch (qualAcaoRealizar()) {
                    case 0:
                        mudarDirecao();
                        condicional = true;
                        break;
                    case 1:
                        if (mover(sala)) {
                            // marcarCaminhoPercorrido(); //criar esse método
                            condicional = true;
                        }
                }// fim switch
            } // fim while (!condicional)

            if (jaPercorreuTodaSala(sala)) {
                desligar();
            }

            AdaptadorGUI.obterInstancia().mostrarSala(sala);
        } // fim while (estaLigado())
    }

    protected void initCaminhoPercorrido(Sala sala) {
        caminho_percorrido = new boolean[sala.qdeLinhas()][sala.qdeColunas()];

        for (int i = 0; i < sala.qdeColunas(); i++) {
            for (int j = 0; j < sala.qdeColunas(); j++) {
                caminho_percorrido[i][j] = false;
            }
        }
    }

    protected void marcarCaminhoPercorrido() {
        AdaptadorGUI.obterInstancia().MostrarCaminho(linha, coluna);
        caminho_percorrido[linha][coluna] = true;
    }

    protected boolean jaPercorreuTodaSala(Sala sala) {

        for (int i = 0; i < sala.qdeLinhas(); i++) {
            for (int j = 0; j < sala.qdeColunas(); j++) {
                if (!caminho_percorrido[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    protected void desligar() {
        interruptor = false;
    }

    protected boolean estaLigado() {
        return interruptor;
    }

    protected int qualAcaoRealizar() {
        Random moeda = new Random();
        AdaptadorGUI.obterInstancia().acaoRealizar();
        return (moeda.nextInt(100) % 2);
    }

    protected void mudarDirecao() {
        Random moeda = new Random();
        int direcao = (moeda.nextInt(100) % 2); // 0 esquerda 1 direita

        if (direcao == 0) {
            // esquerda
            this.direcao--;
            if (this.direcao == -1) {
                this.direcao = 3;
            }
        } else {
            // direita
            this.direcao++;
            if (this.direcao == 4) {
                this.direcao = 0;
            }
        }

        esteira = direcoes[this.direcao]; // virando a esteira
        AdaptadorGUI.obterInstancia().mudarDirecaoAspirador(esteira.direcao());
    }

    protected boolean mover(Sala sala) {
        int linha = this.linha, coluna = this.coluna;
        ParametroPorReferencia prlinha = new ParametroPorReferencia(),
                prcoluna = new ParametroPorReferencia();
        prlinha.valor = linha;
        prcoluna.valor = coluna;

        esteira.ativar(prlinha, prcoluna); // Passagem de parametro entrada e saida (por referencia)
        /**
         * A mensagem esteira.ativar(prlinha, prcoluna) gera a provavel posicao para
         * onde o aspirador
         * deseja mover. Pode ser ou para o Norte, ou Leste etc...
         */

        linha = prlinha.valor;
        coluna = prcoluna.valor;

        if (!sensorParede.ativar(linha, coluna, sala)) {
            marcarCaminhoPercorrido();
            this.linha = linha;
            this.coluna = coluna;
            AdaptadorGUI.obterInstancia().moverAspirador(this.linha, this.coluna, esteira.direcao());
            return true; // conseguiu mover
        }

        return false; // nao conseguiu mover
    }
}

interface Sensor {
    public boolean ativar(int linha, int coluna, Sala sala);
}

class SensorSujeira implements Sensor {
    public boolean ativar(int linha, int coluna, Sala sala) {
        AdaptadorGUI.obterInstancia().sensorSujeira();
        return sala.estaSujo(linha, coluna);
    }
}

class SensorParede implements Sensor {
    public boolean ativar(int linha, int coluna, Sala sala) {
        AdaptadorGUI.obterInstancia().sensorParede();
        return sala.estaNoLimite(linha, coluna);
    }
}

abstract class Esteira {
    abstract public void ativar(ParametroPorReferencia linha, ParametroPorReferencia coluna);

    public String direcao() {
        return this.getClass().getName();
    }
}

class Norte extends Esteira {
    public void ativar(ParametroPorReferencia linha, ParametroPorReferencia coluna) {
        linha.valor--;
    }
}

class Leste extends Esteira {
    public void ativar(ParametroPorReferencia linha, ParametroPorReferencia coluna) {
        coluna.valor++;
    }
}

class Sul extends Esteira {
    public void ativar(ParametroPorReferencia linha, ParametroPorReferencia coluna) {
        linha.valor++;
    }
}

class Oeste extends Esteira {
    public void ativar(ParametroPorReferencia linha, ParametroPorReferencia coluna) {
        coluna.valor--;
    }
}

class Sugador {
    public void ativar(int linha, int coluna, Sala sala) {
        AdaptadorGUI.obterInstancia().sugador();
        sala.limpar(linha, coluna);
    }
}

class Sala {
    protected boolean[][] sala = new boolean[5][5];
    int qde_linha, qde_coluna;

    public Sala() {
        qde_linha = 5;
        qde_coluna = 5;

        for (int i = 0; i < qde_linha; i++) {
            for (int j = 0; j < qde_coluna; j++) {
                sala[i][j] = false;
            }
        }
    }

    public void sujar(int linha, int coluna) {
        AdaptadorGUI.obterInstancia().mostrarSujeira(linha, coluna);
        sala[linha][coluna] = true;
    }

    public Boolean estaSujo(int linha, int coluna) {
        return sala[linha][coluna];
    }

    public void limpar(int linha, int coluna) {
        AdaptadorGUI.obterInstancia().apagarSujeira(linha, coluna);
        sala[linha][coluna] = false;
    }

    public boolean estaNoLimite(int linha, int coluna) {
        return !((linha > -1) && (linha < qde_linha) && (coluna > -1) && (coluna < qde_coluna));
    }

    public int qdeLinhas() {
        return qde_linha;
    }

    public int qdeColunas() {
        return qde_coluna;
    }

    public void texto() {
        System.out.println("");
        System.out.println("");
        System.out.println("------SALA------");
        System.out.println("");
        System.out.println("");

        for (int i = 0; i < qde_linha; i++) {
            for (int j = 0; j < qde_coluna; j++) {
                if (sala[i][j]) {
                    System.out.print("X");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
    }
}

class Porco {
    public Porco() {

    }

    public void sujar(Sala sala) {
        Random valor_aleatorio = new Random();
        int qde_sujeiras;
        qde_sujeiras = valor_aleatorio.nextInt(sala.qdeLinhas() * sala.qdeColunas());
        for (int i = 1; i <= qde_sujeiras; i++) {
            int linha = valor_aleatorio.nextInt(sala.qdeLinhas());
            int coluna = valor_aleatorio.nextInt(sala.qdeColunas());
            if (!sala.estaSujo(linha, coluna)) {
                sala.sujar(linha, coluna);
            }
        }
    }
}

class Controle {
    public void simular() {
        Porco porco = new Porco();
        Sala sala = new Sala();
        AdaptadorGUI.obterInstancia().setDisplay(new GUI("ASPIRADOR DE PO"));
        Aspirador aspirador = new Aspirador(0, 0);

        sala.texto();
        porco.sujar(sala);
        sala.texto();
        aspirador.ligar();
        aspirador.limpar(sala);
        sala.texto();
    }
}

class AspiradorLogica {
    public static void main(String[] args) {
        Controle controle = new Controle();
        controle.simular();
        JOptionPane.showMessageDialog(null, "Finalizado!");
        System.out.println("Ok");
    }
}