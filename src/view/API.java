package view;

import java.sql.Date;
import java.util.List;

import dao.AnaisConferenciaDAO;
import dao.ArtigosDAO;
import dao.MonografiasDAO;
import dao.PublicacoesDAO;

import model.Anais_conferencia;
import model.Artigo;
import model.Autor;
import model.Monografia;
import model.Publicacao;

public class API {
	
	static PublicacoesDAO pubsDAO;
	static MonografiasDAO monsDAO;
	static ArtigosDAO artsDAO;
	static AnaisConferenciaDAO anaisDAO;

	public static List<Publicacao> listarPublicacoes() {
		pubsDAO = new PublicacoesDAO();
		return pubsDAO.selecionaTudo();
	}

	public static List<Monografia> listarMonografias() {
		monsDAO = new MonografiasDAO();
		return monsDAO.selecionaTudo();
	}
	
	public static int adicionarMonografia(
			int num_monografia,
			String titulo_monografia,
			String local_publicacao,
			String nome_instituicao,
			String tema_monografia
			) {
		Monografia mon = new Monografia();
		mon.setNumero_monog(num_monografia);
		mon.setTitulo_publicacao(titulo_monografia);
		mon.setLocal_publicacao(local_publicacao);
		mon.setNome_instituicao(nome_instituicao);
		mon.setTema_publicacao(tema_monografia);
		monsDAO = new MonografiasDAO();
		return monsDAO.adiciona(mon);
	}
	
	public static List<Publicacao> listarPublicacoesAutores() {
		pubsDAO = new PublicacoesDAO();
		return pubsDAO.selecionaTudoComAutores();
	}
	
	public static Autor adicionaAutorNovoAPublicacao (Autor autor, int id_pub) {
		pubsDAO = new PublicacoesDAO();
		return pubsDAO.adicionaAutorNovoAPublicacao(autor, id_pub);
	}

	public static List<Artigo> listarArtigos() {
		artsDAO = new ArtigosDAO();
		return artsDAO.selecionaTudo();
	}

	public static int adicionarArtigo(
			String titulo, 
			String tema_publicacao, 
			String local_publicacao, 
			String tipo_artigo, 
			int pg_inicial,
			int pg_final) 
	{
		artsDAO = new ArtigosDAO();
		Artigo art = new Artigo();
		art.setTitulo_publicacao(titulo);
		art.setTema_publicacao(tema_publicacao);
		art.setLocal_publicacao(local_publicacao);
		art.setTipo_artigo(tipo_artigo);
		art.setPg_inicial(pg_inicial);
		art.setPg_final(pg_final);
		
		return artsDAO.adiciona(art);
	}

	public static List<Anais_conferencia> listarAnaisDeConferencia() {
		anaisDAO = new AnaisConferenciaDAO();
		return anaisDAO.selecionaTudo();
	}

	public static int adicionarAnal(
			// Atributos publicacao
			String titulo, 
			String tema_publicacao, 
			String local_publicacao, 
			
			// Atributos Anal
			int id_editora, 
			String volume, 
			int numero,
			Date data) {
		
		anaisDAO = new AnaisConferenciaDAO();
		Anais_conferencia anal = new Anais_conferencia(
				id_editora,
				volume,
				numero,
				data
				);	
		
		anal.setTitulo_publicacao(titulo);
		anal.setTema_publicacao(tema_publicacao);
		anal.setLocal_publicacao(local_publicacao);
			
		return anaisDAO.adiciona(anal);
	}
	
}
