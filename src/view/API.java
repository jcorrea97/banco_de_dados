package view;

import java.util.List;

import dao.MonografiasDAO;
import dao.PublicacoesDAO;
import model.Monografia;
import model.Publicacao;

public class API {
	
	static PublicacoesDAO pubs;
	static MonografiasDAO mons;

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
	
}
