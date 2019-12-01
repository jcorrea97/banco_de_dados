package view;

import java.util.List;

import dao.ArtigosDAO;
import dao.MonografiasDAO;
import dao.PublicacoesDAO;
import model.Artigo;
import model.Autor;
import model.Monografia;
import model.Publicacao;

public class API {
	
	static PublicacoesDAO pubs;
	static MonografiasDAO mons;
	static ArtigosDAO arts;

	public static List<Publicacao> listarPublicacoes() {
		pubs = new PublicacoesDAO();
		return pubs.selecionaTudo();
	}

	public static List<Monografia> listarMonografias() {
		mons = new MonografiasDAO();
		return mons.selecionaTudo();
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
		mon.setLocal(local_publicacao);
		mon.setNome_instituicao(nome_instituicao);
		mon.setTema_publicacao(tema_monografia);
		mons = new MonografiasDAO();
		return mons.adiciona(mon);
	}

	public static List<Publicacao> listarPublicacoesAutores() {
		pubs = new PublicacoesDAO();
		return pubs.selecionaTudoComAutores();
	}
	
	public static Autor adicionaAutorNovoAPublicacao (Autor autor, int id_pub) {
		pubs = new PublicacoesDAO();
		return pubs.adicionaAutorNovoAPublicacao(autor, id_pub);
	}

	public static List<Artigo> listarArtigos() {
		arts = new ArtigosDAO();
		return arts.selecionaTudo();
	}
	
}
