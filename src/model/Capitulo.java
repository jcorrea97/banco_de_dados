package model;

public class Capitulo {
	
	private Integer id_capitulo;
	private Integer id_livro;
	private Integer capitulo; // int ou varchar (no modelo ta varchar)
	public Integer getId_capitulo() {
		return id_capitulo;
	}
	public void setId_capitulo(Integer id_capitulo) {
		this.id_capitulo = id_capitulo;
	}
	public Integer getId_livro() {
		return id_livro;
	}
	public void setId_livro(Integer id_livro) {
		this.id_livro = id_livro;
	}
	public Integer getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(Integer capitulo) {
		this.capitulo = capitulo;
	}

	
}
