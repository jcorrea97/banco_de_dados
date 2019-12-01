package model;

import java.sql.Date;
import java.util.List;

public class Publicacao {
	
	private Integer id_pub;
	private String tipo_publicacao;
	private String local_publicacao;
	private Date data;
	private Integer id_emprestimo_pub;
	private String tema_publicacao;
	private String titulo_publicacao;
	private List<Autor> autores;
	private int id_autor = -1; 
	private String nome_autor = "";
	
	


	public Integer getId_emprestimo_pub() {
		return id_emprestimo_pub;
	}

	public void setId_emprestimo_pub(Integer id_emprestimo_pub) {
		this.id_emprestimo_pub = id_emprestimo_pub;
	}

	public void setLocal_publicacao(String local_publicacao) {
		this.local_publicacao = local_publicacao;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	/**
	 * Cria um novo objeto do tipo publica��o
	 * @param tipo_publicacao_
	 * @param local_publicacao_
	 */
	public Publicacao(
			String tipo_publicacao_,
			String local_publicacao_,
			String titulo_publicacao_,
			String tema_publicacao_){
		setTitulo_publicacao(titulo_publicacao_);
		setTema_publicacao(tema_publicacao_);
		setLocal(local_publicacao_);
		setTipo_publicacao(tipo_publicacao_);
	}
	
	public Publicacao(){
		
	}
	
	public Integer getId_pub() {
		return id_pub;
	}
	public void setId_pub(Integer id_pub) {
		this.id_pub = id_pub;
	}
	public String getTipo_publicacao() {
		return tipo_publicacao;
	}
	public void setTipo_publicacao(String tipo_publicacao) {
		this.tipo_publicacao = tipo_publicacao;
	}
	public String getLocal_publicacao() {
		return local_publicacao;
	}
	public void setLocal(String local) {
		this.local_publicacao = local;
	}
	
	@Override
	public String toString() {
		if(autores != null) {
			return String.format(
					"{ id_pub: %d, tipo_publicacao: %s , local_publicacao: %s, autores: %s }",
					getId_pub(),
					getTipo_publicacao(),
					getLocal_publicacao(),
					getAutores());
		}
		return String.format(
				"{ id_pub: %d, tipo_publicacao: %s , local_publicacao: %s }",
				getId_pub(),
				getTipo_publicacao(),
				getLocal_publicacao());
	}

	public String getTitulo_publicacao() {
		return titulo_publicacao;
	}

	public void setTitulo_publicacao(String titulo) {
		this.titulo_publicacao = titulo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTema_publicacao() {
		return tema_publicacao;
	}

	public void setTema_publicacao(String tema_publicacao) {
		this.tema_publicacao = tema_publicacao;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
}
