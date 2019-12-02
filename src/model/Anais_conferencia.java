package model;

import java.sql.Date;

public class Anais_conferencia extends Publicacao{;
	private Integer id_editora;
	private String volume;
	private Integer numero;
	private Date data;
	
	public Anais_conferencia(Integer id_editora2, String volume, Integer numero, Date data) {
		setTipo_publicacao("anal_de_conferencia");
		setId_editora(id_editora2);
		setVolume(volume);
		setNumero(numero);
		setData(data);
	}
	
	public Integer getId_anal_conf() {
		return super.getId_pub();
	}
	public void setId_anal_conf(Integer id_anal_conf) {
		super.setId_pub(id_anal_conf);
	}
	public Integer getId_editora() {
		return id_editora;
	}
	public void setId_editora(Integer id_editora) {
		this.id_editora = id_editora;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	

}
