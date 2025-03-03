package src.ROOMBA_GUI.GUI;

import javax.swing.JFrame;

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

