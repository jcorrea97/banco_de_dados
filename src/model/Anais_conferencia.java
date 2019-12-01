package model;

import java.util.Calendar;

public class Anais_conferencia {
	private Integer id_anal_conf;
	private Integer id_editora;
	private String volume;
	private Integer numero;
	private String data;
	
	public Anais_conferencia(String id_editora2, String volume, String numero, String data) {
		// TODO Auto-generated constructor stub
	}
	public Integer getId_anal_conf() {
		return id_anal_conf;
	}
	public void setId_anal_conf(Integer id_anal_conf) {
		this.id_anal_conf = id_anal_conf;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	

}
