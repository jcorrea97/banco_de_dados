package view.graphical_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Dimension;

import javax.swing.JSplitPane;

import view.graphical_interface.tabs.AnaisTab;
import view.graphical_interface.tabs.ArtigosTab;
import view.graphical_interface.tabs.AutoresTab;
import view.graphical_interface.tabs.EditorasTab;
import view.graphical_interface.tabs.EmprestimosTab;
import view.graphical_interface.tabs.MonografiasTab;
import view.graphical_interface.tabs.PessoasTab;
import view.graphical_interface.tabs.PublicacoesTab;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTable;
import java.awt.Color;

public class GUIModel {

	private JFrame frame;
	JTable publicacaoResultadosTable;
	JTable emprestimosResultadosTable;
	JTable monografiasResultadosTable;
	JTable editorasResultadosTable;
	JTable artigosResultadosTable;
	JTable anaisResultadosTable;
	JTable autoresResultadosTable;
	JTable pessoasResultadoTable;

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
		
		// Aba das publicacoes
		JSplitPane publicacoesTab = new JSplitPane();
		tabbedPane.addTab("Publica\u00E7\u00F5es", null, publicacoesTab, null);
		
		// Aba dos emprestimos
		JSplitPane emprestimosTab = new JSplitPane();
		tabbedPane.addTab("Emprestimos", null, emprestimosTab, null);
		
		// Aba das monografias
		JSplitPane monografiasTab = new JSplitPane();
		tabbedPane.addTab("Monografias", null, monografiasTab, null);
		
		// Aba dos artigos
		JSplitPane artigosTab = new JSplitPane();
		tabbedPane.addTab("Artigos", null, artigosTab, null);
		
		//Aba dos anais
		JSplitPane anaisTab = new JSplitPane();
		tabbedPane.addTab("Anais de conferencia", null, anaisTab, null);

		//Aba das editoras
		JSplitPane editorasTab = new JSplitPane();
		tabbedPane.addTab("Editoras", null, editorasTab, null);
		
		//Aba dos autores
		JSplitPane autoresTab = new JSplitPane();
		tabbedPane.addTab("Autores", null, autoresTab, null);

		//Aba das pessoas
		JSplitPane pessoasTab = new JSplitPane();
		tabbedPane.addTab("Pessoas", null, pessoasTab, null);
		
		
		configPublicacoesTab(publicacoesTab);
		configEmprestimosTab(emprestimosTab);		
		configMonografiasTab(monografiasTab);
		configArtigosTab(artigosTab);
		configAnaisTab(anaisTab);
		configEditorasTab(editorasTab);
		configAutoresTab(autoresTab);
		configPessoasTab(pessoasTab);
		
	}

	private void configPessoasTab(JSplitPane pessoasTab) {
		JScrollPane resultados_pessoas_container = new JScrollPane();
		pessoasTab.setRightComponent(resultados_pessoas_container);
		
		// Instanciando a table de resultados dos artigos e passando para o configurador
		pessoasResultadoTable = new JTable();		
		PessoasTab pesTab = new PessoasTab(frame, pessoasResultadoTable);
		
		
		resultados_pessoas_container.setViewportView(pessoasResultadoTable);
		
		//Caixa dos botoes
		Box verticalBox = Box.createVerticalBox();
		pessoasTab.setLeftComponent(verticalBox);
		
		//botoes
		JButton btnListarPessoas = new JButton("Listar Pessoas");
		verticalBox.add(btnListarPessoas);
		
		JButton btnInserirPessoa = new JButton("Inserir Pessoa");
		verticalBox.add(btnInserirPessoa);		
		
		//configuracao dos botoes
		pesTab.configBtnListarPessoas(btnListarPessoas);
		pesTab.configBtnInserirPessoa(btnInserirPessoa);
	}

	private void configEmprestimosTab(JSplitPane emprestimosTab) {
		JScrollPane resultados_emprestimos_container = new JScrollPane();
		emprestimosTab.setRightComponent(resultados_emprestimos_container);
		
		// Instanciando a table de resultados dos artigos e passando para o configurador
		emprestimosResultadosTable = new JTable();		
		EmprestimosTab empsTab = new EmprestimosTab(frame, emprestimosResultadosTable);
		
		
		resultados_emprestimos_container.setViewportView(emprestimosResultadosTable);
		
		//Caixa dos botoes
		Box verticalBox = Box.createVerticalBox();
		emprestimosTab.setLeftComponent(verticalBox);
		
		//botoes
		JButton btnListarEmprestimos = new JButton("Listar Emprestimos");
		verticalBox.add(btnListarEmprestimos);
		
		JButton btnFazerEmprestimo = new JButton("Fazer um emprestimo");
		verticalBox.add(btnFazerEmprestimo);		
		
		//configuracao dos botoes
		empsTab.configBtnListarEmprestimos(btnListarEmprestimos);
		empsTab.configBtnFazerEmprestimo(btnFazerEmprestimo);
	}

	private void configEditorasTab(JSplitPane editorasTab) {
		JScrollPane resultados_editoras_container = new JScrollPane();
		editorasTab.setRightComponent(resultados_editoras_container);
		
		// Instanciando a table de resultados dos artigos e passando para o configurador
		editorasResultadosTable = new JTable();		
		EditorasTab editsTab = new EditorasTab(frame, editorasResultadosTable);
		
		
		resultados_editoras_container.setViewportView(editorasResultadosTable);
		
		//Caixa dos botoes
		Box verticalBox = Box.createVerticalBox();
		editorasTab.setLeftComponent(verticalBox);
		
		//botoes
		JButton btnListaEditorasr = new JButton("Listar Editoras");
		verticalBox.add(btnListaEditorasr);
		
		JButton btnInserirEditora = new JButton("Inserir Editora");
		verticalBox.add(btnInserirEditora);		
		
		//configuracao dos botoes
		editsTab.configBtnListarEditoras(btnListaEditorasr);
		editsTab.configBtnInserirEditora(btnInserirEditora);
	}

	private void configArtigosTab(JSplitPane anaisTab) {

		JScrollPane resultados_anais_container = new JScrollPane();
		anaisTab.setRightComponent(resultados_anais_container);
		
		// Instanciando a table de resultados dos artigos e passando para o configurador
		artigosResultadosTable = new JTable();		
		ArtigosTab artsTab = new ArtigosTab(frame, artigosResultadosTable);
		
		
		resultados_anais_container.setViewportView(artigosResultadosTable);
		
		//Caixa dos botoes
		Box verticalBox = Box.createVerticalBox();
		anaisTab.setLeftComponent(verticalBox);
		
		//botoes
		JButton btnListarArtigos = new JButton("Listar Artigos");
		verticalBox.add(btnListarArtigos);
		
		JButton btnInserirArtigo = new JButton("Inserir Artigo");
		verticalBox.add(btnInserirArtigo);		
		
		//configuracao dos botoes
		artsTab.configBtnListarArtigos(btnListarArtigos);
		artsTab.configBtnInserirArtigo(btnInserirArtigo);
	}

	private void configAnaisTab(JSplitPane artigosTab) {
		
		JScrollPane resultados_artigos_container = new JScrollPane();
		artigosTab.setRightComponent(resultados_artigos_container);
		
		// Instanciando a table de resultados dos anais e passando para o configurador
		anaisResultadosTable = new JTable();		
		AnaisTab anaisTab = new AnaisTab(frame, anaisResultadosTable);
		
		
		resultados_artigos_container.setViewportView(anaisResultadosTable);
		
		//Caixa dos botoes
		Box verticalBox = Box.createVerticalBox();
		artigosTab.setLeftComponent(verticalBox);
		
		//botoes
		JButton btnListarAnais = new JButton("Listar Anais de conferencia");
		verticalBox.add(btnListarAnais);
		
		JButton btnInserirAnal = new JButton("Inserir Anais de conferencia");
		verticalBox.add(btnInserirAnal);		
		
		//configuracao dos botoes
		anaisTab.configBtnListaAnais(btnListarAnais);
		anaisTab.configBtnInserirAnal(btnInserirAnal);
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
		
		JButton btnListarPublicacoesEmprestadas = new JButton("Listar Publica\u00E7\u00F5es emprestadas");
		verticalBox.add(btnListarPublicacoesEmprestadas);
		
		JButton btnInserirAutorAPublicacao = new JButton("Inserir autor a publicacao");
		verticalBox.add(btnInserirAutorAPublicacao);
		
		
		pubsTabConfigurator.configBtnListarPublicacoes(btnListarPublicacoes);
		pubsTabConfigurator.configBtnListarPublicacoesAutor(btnListarPublicacoesAutores);
		pubsTabConfigurator.configBtnListarPublicacoesEmprestadas(btnListarPublicacoesEmprestadas);
		pubsTabConfigurator.configBtnInserirPublicacao(btnInserirAutorAPublicacao);

	
		
	}

	private void configAutoresTab(JSplitPane autoresTab) {
		JScrollPane resultados_autores_container = new JScrollPane();
		autoresTab.setRightComponent(resultados_autores_container);
		
		// Instanciando a table de resultados dos artigos e passando para o configurador
		autoresResultadosTable = new JTable();		
		AutoresTab autsTab = new AutoresTab(frame, autoresResultadosTable);
		
		
		resultados_autores_container.setViewportView(autoresResultadosTable);
		
		//Caixa dos botoes
		Box verticalBox = Box.createVerticalBox();
		autoresTab.setLeftComponent(verticalBox);
		
		//botoes
		JButton btnListaAutores = new JButton("Listar Autores");
		verticalBox.add(btnListaAutores);
		
		JButton btnInserirAutor = new JButton("Inserir Autor");
		verticalBox.add(btnInserirAutor);		
		
		//configuracao dos botoes
		autsTab.configBtnListarAutores(btnListaAutores);
		autsTab.configBtnInserirAutor(btnInserirAutor);
	}


}
