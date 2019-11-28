package model;

import java.util.Calendar;

public class Monografia extends Publicacao{
	private Integer id_monografia;
	private Integer numero_monog;
	private String nome_instituicao;
//	private Calendar data;
	private String titulo;
	
	public Monografia() {
		setTipo_publicacao("monografia");
	}
	
	public Integer getId() {
		return id_monografia;
	}
	public void setId(Integer id_monografia) {
		this.id_monografia = id_monografia;
	}
	public Integer getNumero_monog() {
		return numero_monog;
	}
	public void setNumero_monog(Integer numero_monog) {
		this.numero_monog = numero_monog;
	}
	public String getNome_instituicao() {
		return nome_instituicao;
	}
	public void setNome_instituicao(String nome_instituicao) {
		this.nome_instituicao = nome_instituicao;
	}
//	public Calendar getData() {
//		return data;
//	}
//	public void setData(Calendar data) {
//		this.data = data;
//	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
