package tables;

import java.util.Calendar;

public class Livros {

	private Integer id_livro;
	private Integer id_editora;
	private Integer id_autor;
	private String titulo;
	private String tipo_livro;
	private String titulo_original;
	private Integer num_edicao;
	private Calendar ano_pub;
	private Integer num_pg;
	private Integer id_cap;
	public Integer getId_livro() {
		return id_livro;
	}
	public void setId_livro(Integer id_livro) {
		this.id_livro = id_livro;
	}
	public Integer getId_editora() {
		return id_editora;
	}
	public void setId_editora(Integer id_editora) {
		this.id_editora = id_editora;
	}
	public Integer getId_autor() {
		return id_autor;
	}
	public void setId_autor(Integer id_autor) {
		this.id_autor = id_autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTipo_livro() {
		return tipo_livro;
	}
	public void setTipo_livro(String tipo_livro) {
		this.tipo_livro = tipo_livro;
	}
	public String getTitulo_original() {
		return titulo_original;
	}
	public void setTitulo_original(String titulo_original) {
		this.titulo_original = titulo_original;
	}
	public Integer getNum_edicao() {
		return num_edicao;
	}
	public void setNum_edicao(Integer num_edicao) {
		this.num_edicao = num_edicao;
	}
	public Calendar getAno_pub() {
		return ano_pub;
	}
	public void setAno_pub(Calendar ano_pub) {
		this.ano_pub = ano_pub;
	}
	public Integer getNum_pg() {
		return num_pg;
	}
	public void setNum_pg(Integer num_pg) {
		this.num_pg = num_pg;
	}
	public Integer getId_cap() {
		return id_cap;
	}
	public void setId_cap(Integer id_cap) {
		this.id_cap = id_cap;
	}
	
	
}
