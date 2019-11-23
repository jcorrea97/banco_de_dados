package executaveis;

import dao.PublicacaoDAO;
import model.Autor;;

public class TesteInsere {

	public static void main(String[] args) {

		PublicacaoDAO pubs = new PublicacaoDAO();
//		pubs.adicionaAutorNovoAPublicacao(new Autor("Jose de Alencar"), 4);
//		System.out.println(pubs.selecionaTudo());
		System.out.println(pubs.selecionaComAutores(4));
		
	}

}
