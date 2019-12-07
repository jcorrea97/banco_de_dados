package view.graphical_interface.popups;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import dao.API;

public class FazEmprestimo{

    private static void display() {
        JTextField cpf = new JTextField("");
        JTextField id_pub = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("CPF / CNPJ da pessoa (apenas numeros)"));
        panel.add(cpf);
        panel.add(new JLabel("ID publicacao emprestada"));
        panel.add(id_pub);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("##/##/####");
			maskData.setPlaceholderCharacter( '_' );
			
	        JFormattedTextField dateEmp = new JFormattedTextField(maskData); 
	        JFormattedTextField dateDev = new JFormattedTextField(maskData); 
	        panel.add(new JLabel("Data de emprestimo"));
	        panel.add(dateEmp);
	        panel.add(new JLabel("Data da devolucao"));
	        panel.add(dateDev);
	        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar autor",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	            API.fazerEmprestimo(
	            		cpf.getText(),
	            		Integer.parseInt(id_pub.getText()),
						new java.sql.Date(df.parse(dateEmp.getText()).getTime()),         		
						new java.sql.Date(df.parse(dateDev.getText()).getTime())
	            		);
	        } else {
	            System.out.println("Cancelled");
	        }
        } catch (Exception e) {
        	e.printStackTrace();
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