package view.graphical_interface.popups;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

import view.API;

public class InsertArtigo {

    private static void display() {
        
       
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        // ----------- Padrao para Publicacoes ------------
        JTextField pub_title = new JTextField("");
        JTextField pub_theme = new JTextField("");
        JTextField pub_local = new JTextField("");    
        panel.add(new JLabel("titulo do artigo"));
        panel.add(pub_title);
        panel.add(new JLabel("tema do artigo"));
        panel.add(pub_theme);
        panel.add(new JLabel("local de publicacao do artigo"));
        panel.add(pub_local);
        
        
        // ----------- Atributos especificos ------------ tipo_artigo, pg_inicial, pg_final,
        String[] items = {"artigo_de_anal", "artigo_de_livro", "artigo_de_periodico"};
        JComboBox<String> combo = new JComboBox<>(items);
        panel.add(new JLabel("tipo do artigo"));
        panel.add(combo);
        
        JTextField field5 = new JTextField("");
        JTextField field6 = new JTextField("");
        panel.add(new JLabel("pagina inicial"));
        panel.add(field5);
        panel.add(new JLabel("pagina final"));
        panel.add(field6);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar artigo",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            API.adicionarArtigo(
            		// Atributos publicacao
            		pub_title.getText(),
            		pub_theme.getText(),
            		pub_local.getText(),
            		
            		// Atributos artigo
            		(String)combo.getSelectedItem(),
            		Integer.parseInt(field5.getText()),
            		Integer.parseInt(field6.getText())            		
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