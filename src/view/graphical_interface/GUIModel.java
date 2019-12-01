package view.graphical_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import model.Autor;
import view.API;
import view.graphical_interface.tabs.ArtigosTab;
import view.graphical_interface.tabs.MonografiasTab;
import view.graphical_interface.tabs.PublicacoesTab;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTable;
import java.awt.Color;

public class GUIModel {

	private JFrame frame;
	JTable publicacaoResultadosTable;
	JTable monografiasResultadosTable;
	JTable artigosResultadosTable;

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
		frame.setSize(900, 600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
//		frame.setBounds(600, 200, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JSplitPane publicacoesTab = new JSplitPane();
		tabbedPane.addTab("Publica\u00E7\u00F5es", null, publicacoesTab, null);
		
		JSplitPane monografiasTab = new JSplitPane();
		tabbedPane.addTab("Monografias", null, monografiasTab, null);
		
		JSplitPane artigosTab = new JSplitPane();
		tabbedPane.addTab("Artigos", null, artigosTab, null);
		
		
		
		configPublicacoesTab(publicacoesTab);
		configMonografiasTab(monografiasTab);
		configArtigosTab(artigosTab);
	
		
	}

	private void configArtigosTab(JSplitPane artigosTab) {
		JScrollPane resultados_artigos_container = new JScrollPane();
		artigosTab.setRightComponent(resultados_artigos_container);
		
		artigosResultadosTable = new JTable();
		
		ArtigosTab artsTab = new ArtigosTab(frame, monografiasResultadosTable);
		
		resultados_artigos_container.setViewportView(monografiasResultadosTable);
		
		Box verticalBox = Box.createVerticalBox();
		artigosTab.setLeftComponent(verticalBox);
		
		JButton btnListarArtigos = new JButton("Listar Artigos");
		verticalBox.add(btnListarArtigos);
		
		JButton btnInserirArtigo = new JButton("Inserir Monografia");
		verticalBox.add(btnInserirArtigo);		
		
		artsTab.configBtnListarArtigos(btnListarArtigos);
		artsTab.configBtnInserirArtigo(btnInserirArtigo);
	}

	private void configMonografiasTab(JSplitPane monografiasTab) {
		JScrollPane resultados_monografia_container = new JScrollPane();
		monografiasTab.setRightComponent(resultados_monografia_container);
		
		monografiasResultadosTable = new JTable();
		
		MonografiasTab monsTab = new MonografiasTab(frame, monografiasResultadosTable);
		
		resultados_monografia_container.setViewportView(monografiasResultadosTable);
		
		Box verticalBox = Box.createVerticalBox();
		monografiasTab.setLeftComponent(verticalBox);
		
		JButton btnListarMonografias = new JButton("Listar Monografias");
		verticalBox.add(btnListarMonografias);
		
		JButton btnInserirMonografia = new JButton("Inserir Monografia");
		verticalBox.add(btnInserirMonografia);
		
		
		
		monsTab.configBtnListarMonografias(btnListarMonografias);
		monsTab.configBtnInserirMonografia(btnInserirMonografia);
		
	}

	/**
	 * Funcao responsavel por cuidar da aba de publicacoes
	 * @param publicacoesTab
	 */
	private void configPublicacoesTab(JSplitPane publicacoesTab) {
		
		JScrollPane resultados_publicacoes_container = new JScrollPane();
		publicacoesTab.setRightComponent(resultados_publicacoes_container);
		
		publicacaoResultadosTable = new JTable();	
		
		PublicacoesTab pubsTabConfigurator = new PublicacoesTab(frame, publicacaoResultadosTable);
		
		resultados_publicacoes_container.setViewportView(publicacaoResultadosTable);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(Color.DARK_GRAY);
		publicacoesTab.setLeftComponent(verticalBox);
		
		JButton btnListarPublicacoes = new JButton("Listar Publica\u00E7\u00F5es");
		verticalBox.add(btnListarPublicacoes);
		
		JButton btnListarPublicacoesAutores = new JButton("Listar Publica\u00E7\u00F5es com autores");
		verticalBox.add(btnListarPublicacoesAutores);
		
		JButton btnInserirPublicacao = new JButton("Inserir Publica\u00E7\u00E3o");
		verticalBox.add(btnInserirPublicacao);
		
		
		pubsTabConfigurator.configBtnListarPublicacoes(btnListarPublicacoes);
		pubsTabConfigurator.configBtnListarPublicacoesAutor(btnListarPublicacoesAutores);
		pubsTabConfigurator.configBtnInserirPublicacao(btnInserirPublicacao);

	
		
	}




}
