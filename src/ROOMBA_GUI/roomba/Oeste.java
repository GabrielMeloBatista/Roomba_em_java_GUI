package src.ROOMBA_GUI.roomba;

import src.ROOMBA_GUI.shared.ParametroPorReferencia;

class Oeste extends Esteira {
    public void ativar(ParametroPorReferencia linha, ParametroPorReferencia coluna) {
        coluna.valor--;
    }
}
