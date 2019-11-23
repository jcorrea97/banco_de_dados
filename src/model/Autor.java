package model;

public class Autor {
	private Integer id_autor;
	private String nome_autor;
	
	public Autor (String nome_autor) {
		this.setNome_autor(nome_autor);
	}
	
	public Integer getId_autor() {
		return id_autor;
	}
	public void setId_autor(Integer id_autor) {
		this.id_autor = id_autor;
	}
	public String getNome_autor() {
		return nome_autor;
	}
	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("{ nome_autor: %s , id_autor: %d }", 
				getNome_autor(), 
				getId_autor());
	}
	
	
}
