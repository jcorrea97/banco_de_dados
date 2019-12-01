package model;

public class Emprestimo {
	private Integer id_emprestimo;
	private String publicacao_emprestimo;
	
	public Emprestimo(String publicacao_emprestimo2) {
		setPublicacao_emprestimo(publicacao_emprestimo2);
		}
	public Integer getId_emprestimo() {
		return id_emprestimo;
	}
	public void setId_emprestimo(Integer id_emprestimo) {
		this.id_emprestimo = id_emprestimo;
	}
	public String getPublicacao_emprestimo() {
		return publicacao_emprestimo;
	}
	public void setPublicacao_emprestimo(String publicacao_emprestimo) {
		this.publicacao_emprestimo = publicacao_emprestimo;
	}
	
	
}
