package model;

public class Editora {
	private Integer id_editora;
	private String editora;
	
	public Editora(String editora){
		setEditora(editora);
	}
	
	public Integer getId_editora() {
		return id_editora;
	}
	public void setId_editora(Integer id_editora) {
		this.id_editora = id_editora;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	@Override
	public String toString() {
		return String.format(
				"{ id_editora: %d, editora: %s  }",
				getId_editora(),
				getEditora());
	}
	
	
}
