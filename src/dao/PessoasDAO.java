package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Editora;
import model.Pessoa;

/**
 * DAO que gerencia sele��es e inser��es em publicacoes
 *
 */
public class PessoasDAO extends GenericDAO{
	
	public PessoasDAO() {
		super();
	}
	
	public PessoasDAO(Connection con) {
		super(con);
	}
	
	/**
	 * Adiciona uma editora
	 * @param editora
	 */
	public void adiciona( String cpf_cnpj, String nome_pessoa) {
		
			Pessoa pes = new Pessoa();
			pes.setCpf_cnpj_pessoa(cpf_cnpj);
			pes.setNome_pessoa(nome_pessoa);
			
			String sql = "insert into pessoas (cpf_cnpj_pessoa, nome_pessoa) values (?,?)";
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, pes.getCpf_cnpj_pessoa());
			stmt.setString(2, pes.getNome_pessoa());
			stmt.execute();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return;
		            }
		            else {
		                throw new SQLException("Criar pessoa falhou, nenhum ID obtido");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	

	
	/**
	 * Retorna um objeto do tipo editora com o determinado ID
	 * @param id_editora
	 * @return Editoras
	 */
	public Pessoa seleciona(int id_pessoa) {
	
			String sql = "select * from pessoas where id_editora = ?";
			
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_pessoa);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Pessoa pes = new Pessoa ();
		            	pes.setCpf_cnpj_pessoa((rs.getString("cpf_cnpj_pessoa")));
		            	pes.setNome_pessoa((rs.getString("nome_pessoa")));
		            	return pes;
		            }
		            else {
		                throw new SQLException("nenhuma publica��o encontrada com o id passado: " + id_pessoa);
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Lista todas as publica��es presentes no Banco de dados, se nenhuma for encontrada retorna Null
	 * @return List<Publicacao>
	 */
	public List<Pessoa> selecionaTudo() {
		String sql = "select * from pessoas";
		
		try {			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();	
			 try (ResultSet rs = stmt.getResultSet()) {
				 List<Pessoa> pessoas = new ArrayList<Pessoa>();
		            if (rs.next()) {
		            	do {
		            	Pessoa pes = new Pessoa();
		            	pes.setCpf_cnpj_pessoa(rs.getString("cpf_cnpj_pessoa"));		            	
		            	pes.setNome_pessoa(rs.getString("nome_pessoa"));           	
		            	pessoas.add(pes);
		            	} 
		            	while (rs.next());
		            	return pessoas;
		            }
		            else {
		            	return pessoas;
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public int remove(int id_edit) {
			String sql = "delete from editoras where id_editora = ?";
			
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, id_edit);
			stmt.executeUpdate();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("N�o foi poss�vel remover: id n�o encontrado");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
