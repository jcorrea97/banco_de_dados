package executaveis;

import java.util.Calendar;

import dao.*;
import model.*;

public class TesteInsere {

	public static void main(String[] args) {
//		PublicacaoDAO pub = new PublicacaoDAO();
		EditoraDAO edit = new EditoraDAO();
//		edit.adiciona("Editora Ricardg");
//		pub.adiciona("Livro", "Guaianases");
//		System.out.println(pub.remove(3));
//		System.out.println(pub.selecionaTudo());
	System.out.println(edit.seleciona(2));
//	System.out.println(edit.selecionaTudo());
//		System.out.println(edit.remove(1));
	}

}
