package model;

public class Artigo extends Publicacao{

	private Integer id_periodico;
	private Integer id_editora;
	private String tipo_artigo;
	private Integer id_livro;
	private Integer pg_inicial;
	private Integer pg_final;
	public Integer getId_periodico() {
		return id_periodico;
	}
	public void setId_periodico(Integer id_periodico) {
		this.id_periodico = id_periodico;
	}
	public Integer getId_editora() {
		return id_editora;
	}
	public void setId_editora(Integer id_editora) {
		this.id_editora = id_editora;
	}
	public String getTipo_artigo() {
		return tipo_artigo;
	}
	public void setTipo_artigo(String tipo_artigo) {
		this.tipo_artigo = tipo_artigo;
	}
	public Integer getId_livro() {
		return id_livro;
	}
	public void setId_livro(Integer id_livro) {
		this.id_livro = id_livro;
	}
	public Integer getPg_inicial() {
		return pg_inicial;
	}
	public void setPg_inicial(Integer pg_inicial) {
		this.pg_inicial = pg_inicial;
	}
	public Integer getPg_final() {
		return pg_final;
	}
	public void setPg_final(Integer pg_final) {
		this.pg_final = pg_final;
	}

	
	
	
	
}
