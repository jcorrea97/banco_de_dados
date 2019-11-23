package view;

import java.util.List;

import dao.PublicacoesDAO;
import model.Publicacao;

public class API {
	
	static PublicacoesDAO pubs;

	public static List<Publicacao> listarPublicacoes() {
		pubs = new PublicacoesDAO();
		return pubs.selecionaTudo();
	}
	
}
