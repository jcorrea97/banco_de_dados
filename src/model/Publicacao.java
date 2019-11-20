package model;

public class Publicacao {
	
	private Integer id_pub;
	private String tipo_publicacao;
	private String local_publicacao;
	
	/**
	 * Cria um novo objeto do tipo publicação
	 * @param tipo_publicacao_
	 * @param local_publicacao_
	 */
	public Publicacao(String tipo_publicacao_, String local_publicacao_){
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
}
