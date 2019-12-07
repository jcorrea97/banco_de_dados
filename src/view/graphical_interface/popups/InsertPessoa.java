package view.graphical_interface.popups;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

import dao.API;

public class InsertPessoa{

    private static void display() {
        JTextField field1 = new JTextField("");
        JTextField field2 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("CPF / CNPJ da pessoa (apenas numeros)"));
        panel.add(field1);
        panel.add(new JLabel("Nome da pessoa"));
        panel.add(field2);
        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar autor",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            API.adicionarPessoa(
            		field1.getText(),
            		field2.getText()
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