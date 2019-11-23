package view.graphical_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import view.graphical_interface.tabs.PublicacoesTab;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTable;

public class GUIModel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIModel window = new GUIModel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIModel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 200, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JSplitPane splitPane = new JSplitPane();
		tabbedPane.addTab("Publica\u00E7\u00F5es", null, splitPane, null);
		
		configPublicacoesTab(splitPane);
	
		
	}

	private void configPublicacoesTab(JSplitPane splitPane) {
		
		JScrollPane resultados_publicacoes_container = new JScrollPane();
		splitPane.setRightComponent(resultados_publicacoes_container);
		
		JTable resultadosTable;
		resultadosTable = PublicacoesTab.configResultadosTable();
		resultados_publicacoes_container.setViewportView(resultadosTable);
		
		Box verticalBox = Box.createVerticalBox();
		splitPane.setLeftComponent(verticalBox);
		
		JButton btnListarPublicacoes = new JButton("Listar Publica\u00E7\u00F5es");
		verticalBox.add(btnListarPublicacoes);
		
		JButton btnInserirPublicacao = new JButton("Inserir Publica\u00E7\u00E3o");
		verticalBox.add(btnInserirPublicacao);
		
		PublicacoesTab pubsTab = new PublicacoesTab(frame);
		
		pubsTab.configBtnListarPublicacoes(btnListarPublicacoes, resultadosTable);
		pubsTab.configBtnInserirPublicacao(btnInserirPublicacao);

	
		
	}



}
