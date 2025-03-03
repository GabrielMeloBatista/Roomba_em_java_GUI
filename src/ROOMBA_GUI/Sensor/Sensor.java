package src.ROOMBA_GUI.Sensor;

import src.ROOMBA_GUI.shared.Sala;

public interface Sensor {
    public boolean ativar(int linha, int coluna, Sala sala);
}
