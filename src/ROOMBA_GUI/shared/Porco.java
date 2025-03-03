package src.ROOMBA_GUI.shared;

import java.util.Random;

public class Porco {
    public Porco() {

    }

    public void sujar(Sala sala) {
        Random valor_aleatorio = new Random();
        int qde_sujeiras;
        qde_sujeiras = valor_aleatorio.nextInt(sala.qdeLinhas() * sala.qdeColunas());
        for (int i = 1; i <= qde_sujeiras; i++) {
            int linha = valor_aleatorio.nextInt(sala.qdeLinhas());
            int coluna = valor_aleatorio.nextInt(sala.qdeColunas());
            if (!sala.estaSujo(linha, coluna)) {
                sala.sujar(linha, coluna);
            }
        }
    }
}
