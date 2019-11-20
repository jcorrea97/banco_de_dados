package model;

import java.util.Calendar;

public class Artigo_periodico {

	private Integer id_pub;
	private Integer id_artigo;
	private String titulo_periodico;
	private Integer num_volume;
	private Calendar data;
	
	public Integer getId_pub() {
		return id_pub;
	}
	public void setId_pub(Integer id_pub) {
		this.id_pub = id_pub;
	}
	public Integer getId_artigo() {
		return id_artigo;
	}
	public void setId_artigo(Integer id_artigo) {
		this.id_artigo = id_artigo;
	}
	public String getTitulo_periodico() {
		return titulo_periodico;
	}
	public void setTitulo_periodico(String titulo_periodico) {
		this.titulo_periodico = titulo_periodico;
	}
	public Integer getNum_volume() {
		return num_volume;
	}
	public void setNum_volume(Integer num_volume) {
		this.num_volume = num_volume;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	
	
}
