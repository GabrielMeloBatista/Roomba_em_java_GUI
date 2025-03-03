package src.ROOMBA_GUI.Sensor;

import src.ROOMBA_GUI.GUI.AdaptadorGUI;
import src.ROOMBA_GUI.shared.Sala;

public class SensorSujeira implements Sensor {
    public boolean ativar(int linha, int coluna, Sala sala) {
        AdaptadorGUI.obterInstancia().sensorSujeira();
        return sala.estaSujo(linha, coluna);
    }
}
