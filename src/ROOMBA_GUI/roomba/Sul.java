package src.ROOMBA_GUI.roomba;

import src.ROOMBA_GUI.shared.ParametroPorReferencia;

class Sul extends Esteira {
    public void ativar(ParametroPorReferencia linha, ParametroPorReferencia coluna) {
        linha.valor++;
    }
}
