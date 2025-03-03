package src.ROOMBA_GUI.roomba;

import src.ROOMBA_GUI.GUI.AdaptadorGUI;
import src.ROOMBA_GUI.shared.Sala;

class Sugador {
    public void ativar(int linha, int coluna, Sala sala) {
        AdaptadorGUI.obterInstancia().sugador();
        sala.limpar(linha, coluna);
    }
}
