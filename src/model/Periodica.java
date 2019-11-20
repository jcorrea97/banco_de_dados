package model;

import java.util.Calendar;

public class Periodica {

	private Integer id_periodico;
	private Integer id_artigo;
	private String titulo;
	private String volume;
	private Integer numero;
	private Calendar data;
	
	public Integer getId_periodico() {
		return id_periodico;
	}
	public void setId_periodico(Integer id_periodico) {
		this.id_periodico = id_periodico;
	}
	public Integer getId_artigo() {
		return id_artigo;
	}
	public void setId_artigo(Integer id_artigo) {
		this.id_artigo = id_artigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
}
