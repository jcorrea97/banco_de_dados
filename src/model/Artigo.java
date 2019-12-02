package model;

public class Artigo extends Publicacao{

	private Integer id_periodico = null;
	private Integer id_editora = null;
	private String tipo_artigo;
	private Integer id_livro = null;
	private Integer pg_inicial;
	private Integer pg_final;
	private Integer id_artigo_anais = null;
	private String titulo_artigo;
	private Integer id_artigo;
	
	public Artigo (int id_periodico, int id_editora, String tipo_artigo, int id_livro, int pg_inicial, int pg_final, int id_artigo_anais, String titulo_artigo, int id_artigo) {
		setId_artigo_anais(id_artigo_anais);
		setTitulo_artigo(titulo_artigo);
		setId_artigo_anais(id_artigo_anais);
		setId_artigo(id_artigo);
		setId_periodico(id_periodico);
		setId_editora(id_editora);
		setTipo_artigo(tipo_artigo);
		setId_livro(id_livro);
		setPg_inicial(pg_inicial);
		setPg_final(pg_final);
		
		setTipo_publicacao("artigo");
	}		
	
	public Artigo () {
		
		setTipo_publicacao("artigo");
	}	
	
	
	
	
	public Integer getId_artigo_anais() {
		return id_artigo_anais;
	}
	public void setId_artigo_anais(Integer id_artigo_anais) {
		this.id_artigo_anais = id_artigo_anais;
	}
	public String getTitulo_artigo() {
		return titulo_artigo;
	}
	public void setTitulo_artigo(String titulo_artigo) {
		this.titulo_artigo = titulo_artigo;
	}
	public Integer getId_artigo() {
		return id_artigo;
	}
	public void setId_artigo(Integer id_artigo) {
		this.id_artigo = id_artigo;
	}
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
