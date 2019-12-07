package view.graphical_interface.popups;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

import dao.API;

public class InsertEditora{

    private static void display() {
        JTextField field1 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nome da editora"));
        panel.add(field1);
        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar monografia",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            API.adicionarEditora(
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