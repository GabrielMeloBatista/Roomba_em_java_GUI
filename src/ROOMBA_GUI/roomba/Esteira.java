package src.ROOMBA_GUI.roomba;

import src.ROOMBA_GUI.shared.ParametroPorReferencia;

abstract class Esteira {
    abstract public void ativar(ParametroPorReferencia linha, ParametroPorReferencia coluna);

    public String direcao() {
        return this.getClass().getSimpleName();
    }
}
