package executaveis;

import java.util.Calendar;

import dao.ContatoDAO;
import dao.PublicacaoDAO;
import model.Contato;

public class TesteInsere {

	public static void main(String[] args) {
		PublicacaoDAO pub = new PublicacaoDAO();
		pub.adiciona("Artigo", "Itaquera");
	}

}
