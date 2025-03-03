package src.ROOMBA_GUI;

import javax.swing.JOptionPane;

import src.ROOMBA_GUI.roomba.Controle;

class AspiradorLogica {
    public static void main(String[] args) {
        Controle controle = new Controle();
        controle.simular();
        JOptionPane.showMessageDialog(null, "Finalizado!");
        System.out.println("Ok");
    }
}