package src.ROOMBA_GUI.roomba;

import java.util.Random;

import src.ROOMBA_GUI.GUI.AdaptadorGUI;
import src.ROOMBA_GUI.Sensor.Sensor;
import src.ROOMBA_GUI.Sensor.SensorParede;
import src.ROOMBA_GUI.Sensor.SensorSujeira;
import src.ROOMBA_GUI.shared.ParametroPorReferencia;
import src.ROOMBA_GUI.shared.Sala;

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
