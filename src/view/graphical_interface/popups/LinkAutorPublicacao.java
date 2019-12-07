package view.graphical_interface.popups;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

import dao.API;

public class LinkAutorPublicacao{

    private static void display() {
        JTextField field1 = new JTextField("");
        JTextField field2 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Id da publicacao"));
        panel.add(field1);
        panel.add(new JLabel("Id do autor"));
        panel.add(field2);
        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar autor a publicacao",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            API.linkAutorPublicacao(
            		Integer.parseInt(field1.getText()),
            		Integer.parseInt(field2.getText())
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