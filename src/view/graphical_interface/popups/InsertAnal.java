package view.graphical_interface.popups;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import dao.API;

public class InsertAnal {

    private static void display() {
        
       
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        // ----------- Padrao para Publicacoes ------------
        JTextField pub_title = new JTextField("Novo anal");
        JTextField pub_theme = new JTextField("tema anal");
        JTextField pub_local = new JTextField("local do anal");    
        panel.add(new JLabel("titulo do anal"));
        panel.add(pub_title);
        panel.add(new JLabel("tema do anal"));
        panel.add(pub_theme);
        panel.add(new JLabel("local de publicacao do anal"));
        panel.add(pub_local);
        
        
        // ----------- Atributos especificos ------------ id_editora, volume, numero, data
        
      
        JTextField id_editora = new JTextField("");
        JTextField volume = new JTextField("primeiro volume");
        JTextField numero = new JTextField("4");
    
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("##/##/####");
			maskData.setPlaceholderCharacter( '_' );
			
	        JFormattedTextField date = new JFormattedTextField(maskData);
	        panel.add(new JLabel("id_editora (Obrigatorio)"));
	        panel.add(id_editora);
	        panel.add(new JLabel("volume"));
	        panel.add(volume);
	        panel.add(new JLabel("numero"));
	        panel.add(numero);
	        
	        panel.add(new JLabel("data"));
	        panel.add(date);	      
	        

	        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar artigo",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);	        
	        
	        
	        
	        if (result == JOptionPane.OK_OPTION) {
	            try {
					API.adicionarAnal(
							// Atributos publicacao
							pub_title.getText(),
							pub_theme.getText(),
							pub_local.getText(),
							
							// Atributos artigo
							((id_editora).getText().equals(""))?
							-1:Integer.parseInt(id_editora.getText()),
							volume.getText(),            		
							Integer.parseInt(numero.getText()),            		
							new java.sql.Date(df.parse(date.getText()).getTime())           		
							);
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ocorreu um erro: \n" + e.toString());
				}
	            		
	        } else {
	            System.out.println("Cancelled");
	        }      
	        
		} catch (ParseException e) {
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