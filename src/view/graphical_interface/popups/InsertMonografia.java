package view.graphical_interface.popups;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

import view.API;

public class InsertMonografia {

    private static void display() {
        JTextField field1 = new JTextField("");
        JTextField field2 = new JTextField("");
        JTextField field3 = new JTextField("");
        JTextField field4 = new JTextField("");
        JTextField field5 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Titulo da monografia"));
        panel.add(field1);
        panel.add(new JLabel("Nome da instituicao"));
        panel.add(field2);
        panel.add(new JLabel("Tema da monografia"));
        panel.add(field3);
        panel.add(new JLabel("Numero da monografia"));
        panel.add(field4);
        panel.add(new JLabel("Local de publicacao"));
        panel.add(field5);
        int result = JOptionPane.showConfirmDialog(null, panel, "Test",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            API.adicionarMonografia(
            		Integer.parseInt(field4.getText()),
            		field1.getText(), 
            		field5.getText(), 
            		field3.getText(), 
            		field2.getText());
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