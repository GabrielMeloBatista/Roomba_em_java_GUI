package src.ROOMBA_GUI.GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;



public class GUI extends GraficoUI {

    JPanel Sala;
    JLabel Sujeira, Parede, Mover, Direcao, Sugador, Acao;
    JLabel Sujeiras[][] = new JLabel[5][5];
    JLabel Aspirador;
    int Linha = 0, Coluna = 0;

    private static final String ASSETS_PATH = "src/assets/";
    
    public enum Imagem {
        ASPIRADOR_Leste("aspiradorLeste.png"),
        ASPIRADOR_NE("aspiradorNE.png"),
        ASPIRADOR_NO("aspiradorNO.png"),
        ASPIRADOR_Norte("aspiradorNorte.png"),
        ASPIRADOR_Oeste("aspiradorOeste.png"),
        ASPIRADOR_SE("aspiradorSE.png"),
        ASPIRADOR_SO("aspiradorSO.png"),
        ASPIRADOR_Sul("aspiradorSul.png"),
        BRANCO("branco.png"),
        LUZ_ACESA("LuzAcesa.png"),
        LUZ_APAGADA("LuzApagada.png"),
        RASTRO("rastro.png");


        private final String fileName;

        Imagem(String fileName) {
            this.fileName = fileName;
        }
        public String getFileName() {
            return fileName;
        }
    }

    private Map<Imagem, ImageIcon> imagens = new HashMap<>();

    public GUI(String Titulo) {
        super(Titulo);

        for (Imagem imagem : Imagem.values()) {
            imagens.put(imagem, loadImage(imagem));
        }

        setIconImage(getImagem(Imagem.ASPIRADOR_NE).getImage());
        setSize(700, 400);
        setLocation(250, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MontarLayout();
        setVisible(true);
    }

    private ImageIcon loadImage(Imagem imagem) {
        return new ImageIcon(ASSETS_PATH + imagem.getFileName());
    }

    public ImageIcon getImagem(Imagem imagem) {
        return imagens.get(imagem);
    }

    public void SensorSujeira() {
        Sujeira.setIcon(getImagem(Imagem.LUZ_ACESA));
        Tempo(100);
        Sujeira.setIcon(getImagem(Imagem.LUZ_APAGADA));
        Tempo(100);
    }

    public void SensorParede() {
        Parede.setIcon(getImagem(Imagem.LUZ_ACESA));
        Tempo(100);
        Parede.setIcon(getImagem(Imagem.LUZ_APAGADA));
        Tempo(100);
    }

    public void MoverAspirador(int Linha, int Coluna) {
        Mover.setIcon(getImagem(Imagem.LUZ_ACESA));
        Tempo(100);
        this.Linha = (Linha * 64);
        this.Coluna = (Coluna * 64);
        Aspirador.setLocation(this.Coluna, this.Linha);
        Mover.setIcon(getImagem(Imagem.LUZ_APAGADA));
        Tempo(100);
    }

    public void MoverAspirador(int Linha, int Coluna, String Direcao) {
        int i, Delta;

        Mover.setIcon(getImagem(Imagem.LUZ_ACESA));
        Tempo(100);

        if (Direcao.equalsIgnoreCase("Sul")) {
            Delta = this.Linha;
            Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_Sul));
            for (i = 0; i < (Math.abs((Linha * 64) - Delta)); i++) {
                this.Linha++;
                Aspirador.setLocation(this.Coluna, this.Linha);
                Tempo(5);
            }
        }

        if (Direcao.equalsIgnoreCase("Norte")) {
            Delta = this.Linha;
            Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_Norte));
            for (i = 0; i < (Math.abs((Linha * 64) - Delta)); i++) {
                this.Linha--;
                Aspirador.setLocation(this.Coluna, this.Linha);
                Tempo(5);
            }
        }

        if (Direcao.equalsIgnoreCase("Leste")) {
            Delta = this.Coluna;
            Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_Leste));
            for (i = 0; i < (Math.abs((Coluna * 64) - Delta)); i++) {
                this.Coluna++;
                Aspirador.setLocation(this.Coluna, this.Linha);
                Tempo(5);
            }
        }

        if (Direcao.equalsIgnoreCase("Oeste")) {
            Delta = this.Coluna;
            Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_Oeste));
            for (i = 0; i < (Math.abs((Coluna * 64) - Delta)); i++) {
                this.Coluna--;
                Aspirador.setLocation(this.Coluna, this.Linha);
                Tempo(5);
            }
        }

        Mover.setIcon(getImagem(Imagem.LUZ_APAGADA));
        Tempo(100);
    }

    public void MudarDirecaoAspirador(String Direcao) {
        this.Direcao.setIcon(getImagem(Imagem.LUZ_ACESA));

        String DirecaoAnterior = Aspirador.getIcon().toString();

        if (DirecaoAnterior.contains("Sul")) {
            if (Direcao.equalsIgnoreCase("Leste")) {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_SE));
                Tempo(90);
            } else if (Direcao.equalsIgnoreCase("Oeste")) {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_SO));
                Tempo(90);
            } else {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_NE));
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_Leste));
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_SE));
                Tempo(90);
            }
        }

        if (DirecaoAnterior.contains("Oeste")) {
            if (Direcao.equalsIgnoreCase("Sul")) {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_SO));
                Tempo(90);
            } else if (Direcao.equalsIgnoreCase("Norte")) {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_NO));
                Tempo(90);
            } else {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_NE));
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_Norte));
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_NO));
                Tempo(90);
            }
        }

        if (DirecaoAnterior.contains("Norte")) {
            if (Direcao.equalsIgnoreCase("Leste")) {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_NE));
                Tempo(90);
            } else if (Direcao.equalsIgnoreCase("Oeste")) {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_NO));
                Tempo(90);
            } else {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_SO));
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_Oeste));
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_NO));
                Tempo(90);
            }
        }

        if (DirecaoAnterior.contains("Leste")) {
            if (Direcao.equalsIgnoreCase("Norte")) {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_NE));
                Tempo(90);
            } else if (Direcao.equalsIgnoreCase("Sul")) {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_SE));
                Tempo(90);
            } else {
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_NE));
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_Leste));
                Tempo(90);
                Aspirador.setIcon(getImagem(Imagem.ASPIRADOR_SE));
                Tempo(90);
            }
        }

        Aspirador.setIcon(new ImageIcon(ASSETS_PATH + "aspirador" + Direcao + ".png"));

        Tempo(50);
        this.Direcao.setIcon(getImagem(Imagem.LUZ_APAGADA));
        Tempo(500);
    }

    public void Sugador() {
        Sugador.setIcon(getImagem(Imagem.LUZ_ACESA));
        Tempo(100);
        Sugador.setIcon(getImagem(Imagem.LUZ_APAGADA));
        Tempo(100);
    }

    public void AcaoRealizar() {
        Acao.setIcon(getImagem(Imagem.LUZ_ACESA));
        Tempo(100);
        Acao.setIcon(getImagem(Imagem.LUZ_APAGADA));
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
        Sujeiras[Linha][Coluna].setIcon(getImagem(Imagem.BRANCO));
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
                Sujeiras[j][i] = new JLabel(getImagem(Imagem.RASTRO));
                Sujeiras[j][i].setBounds(0 + (i * 64), 0 + (j * 64), 64, 64);
                Sujeiras[j][i].setVisible(false);
                Sala.add(Sujeiras[j][i]);
            }
        }
    };

    protected void InitAspirador(JPanel Sala) {
        Aspirador = new JLabel(getImagem(Imagem.ASPIRADOR_Sul));
        Aspirador.setBounds(0, 0, 64, 64);
        Sala.add(Aspirador);
    };

    protected void InitSensores() {
        JPanel Sensores = new JPanel();

        Sensores.setLayout(new FlowLayout(FlowLayout.LEFT));
        Sujeira = new JLabel("Sujeira", getImagem(Imagem.LUZ_APAGADA), JLabel.LEFT);
        Parede = new JLabel("Parede", getImagem(Imagem.LUZ_APAGADA), JLabel.LEFT);
        Sensores.setBounds(350, 10, 165, 60);
        Sensores.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "Sensores"));
        Sensores.add(Sujeira);
        Sensores.add(Parede);
        getContentPane().add(Sensores);

    };

    protected void InitAtuadores() {
        JPanel Atuadores = new JPanel();

        Atuadores.setLayout(new FlowLayout(FlowLayout.LEFT));
        Mover = new JLabel("Movimento", getImagem(Imagem.LUZ_APAGADA), JLabel.LEFT);
        Direcao = new JLabel("Direção", getImagem(Imagem.LUZ_APAGADA), JLabel.LEFT);
        Sugador = new JLabel("Sugador", getImagem(Imagem.LUZ_APAGADA), JLabel.LEFT);

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
        Acao = new JLabel("Ação", getImagem(Imagem.LUZ_APAGADA), JLabel.LEFT);
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
