package tables;

public class Publicacoes {
	
	private Integer id_pub;
	private String tipo_publicacao;
	private String local;
	
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
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
}
