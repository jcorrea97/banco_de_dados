package tables;

import java.util.Calendar;

public class Artigo_anais {
	
	private Integer id_pub;
	private Integer id_artigo;
	private String titulo_congresso;
	private Integer volume;
	private Integer numero;
	private Calendar data;
	
	public Integer getId_pub() {
		return id_pub;
	}
	public void setId_pub(Integer id_pub) {
		this.id_pub = id_pub;
	}
	
	public Calendar getdata() {
		return data;
	}
	public void setdata(Calendar data) {
		this.data = data;
	}
	
	public Integer getId_artigo() {
		return id_artigo;
	}
	public void setId_artigo(Integer id_artigo) {
		this.id_artigo = id_artigo;
	}
	public String getTitulo_congresso() {
		return titulo_congresso;
	}
	public void setTitulo_congresso(String titulo_congresso) {
		this.titulo_congresso = titulo_congresso;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}


}
