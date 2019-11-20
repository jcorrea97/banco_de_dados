package executaveis;

import java.util.Calendar;

import insere.ContatoDAO;
import tables.Contato;

public class TesteInsere {

	public static void main(String[] args) {
		// vai inserir na table contatos 
		Contato contato = new Contato();
		contato.setNome("kk");
		contato.setEmail("kk@");
		contato.setEndereco("kk rua");
		contato.setDatasci(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
			
		dao.adiciona(contato);
		
		System.out.println("gravado!");
	}

}
