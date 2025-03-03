package src.ROOMBA_GUI.shared;

import src.ROOMBA_GUI.GUI.AdaptadorGUI;

public class Sala {
    protected boolean[][] sala = new boolean[5][5];
    int qde_linha, qde_coluna;

    public Sala() {
        qde_linha = 5;
        qde_coluna = 5;

        for (int i = 0; i < qde_linha; i++) {
            for (int j = 0; j < qde_coluna; j++) {
                sala[i][j] = false;
            }
        }
    }

    public void sujar(int linha, int coluna) {
        AdaptadorGUI.obterInstancia().mostrarSujeira(linha, coluna);
        sala[linha][coluna] = true;
    }

    public Boolean estaSujo(int linha, int coluna) {
        return sala[linha][coluna];
    }

    public void limpar(int linha, int coluna) {
        AdaptadorGUI.obterInstancia().apagarSujeira(linha, coluna);
        sala[linha][coluna] = false;
    }

    public boolean estaNoLimite(int linha, int coluna) {
        return !((linha > -1) && (linha < qde_linha) && (coluna > -1) && (coluna < qde_coluna));
    }

    public int qdeLinhas() {
        return qde_linha;
    }

    public int qdeColunas() {
        return qde_coluna;
    }

    public void texto() {
        System.out.println("");
        System.out.println("");
        System.out.println("------SALA------");
        System.out.println("");
        System.out.println("");

        for (int i = 0; i < qde_linha; i++) {
            for (int j = 0; j < qde_coluna; j++) {
                if (sala[i][j]) {
                    System.out.print("X");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
    }
}

