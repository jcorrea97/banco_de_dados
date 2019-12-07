package model;

import java.sql.Date;

public class Emprestimo {
	
	private int id_emprestimo;
	private int id_pub;
	private Date data_devolucao;
	private Date data_emprestimo;
	private String cpf_cnpj_pessoa;
	
	public int getId_emprestimo() {
		return id_emprestimo;
	}
	public void setId_emprestimo(int id_emprestimo) {
		this.id_emprestimo = id_emprestimo;
	}
	public int getId_pub() {
		return id_pub;
	}
	public void setId_pub(int id_pub) {
		this.id_pub = id_pub;
	}
	public Date getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public Date getData_emprestimo() {
		return data_emprestimo;
	}
	public void setData_emprestimo(Date data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}
	public String getCpf_cnpj_pessoa() {
		return cpf_cnpj_pessoa;
	}
	public void setCpf_cnpj_pessoa(String cpf_cnpj_pessoa) {
		this.cpf_cnpj_pessoa = cpf_cnpj_pessoa;
	}
	
	
	
}
