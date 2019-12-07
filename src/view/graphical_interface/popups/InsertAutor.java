package view.graphical_interface.popups;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

import dao.API;

public class InsertAutor{

    private static void display() {
        JTextField field1 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nome do autor")); //TODO INSERT DO AUTOR E CONFIGURA BOTOES E TAB E CHAMA API
        panel.add(field1);
        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar autor",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            API.adicionarAutor(
            		field1.getText()
            		);
        } else {
            System.out.println("Cancelled");
        }
    }

    public static void executar() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                display();
            }
            
        });
    }
}