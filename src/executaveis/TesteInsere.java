package executaveis;

import dao.PublicacoesDAO;
import model.Autor;

public class TesteInsere {

	public static void main(String[] args) {

		PublicacoesDAO pubs = new PublicacoesDAO();
//		pubs.adicionaAutorNovoAPublicacao(new Autor("Jose de Alencar"), 4);
//		System.out.println(pubs.selecionaTudo());
		System.out.println(pubs.selecionaComAutores(4));
		
	}

}
