package src.ROOMBA_GUI.Sensor;

import src.ROOMBA_GUI.GUI.AdaptadorGUI;
import src.ROOMBA_GUI.shared.Sala;

public class SensorParede implements Sensor {
    public boolean ativar(int linha, int coluna, Sala sala) {
        AdaptadorGUI.obterInstancia().sensorParede();
        return sala.estaNoLimite(linha, coluna);
    }
}
