package src.ROOMBA_GUI.GUI;

import src.ROOMBA_GUI.shared.Sala;

public class AdaptadorGUI {
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

