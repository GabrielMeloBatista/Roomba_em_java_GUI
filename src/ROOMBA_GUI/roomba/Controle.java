package src.ROOMBA_GUI.roomba;

import src.ROOMBA_GUI.GUI.AdaptadorGUI;
import src.ROOMBA_GUI.GUI.GUI;
import src.ROOMBA_GUI.shared.Porco;
import src.ROOMBA_GUI.shared.Sala;

public class Controle {
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

