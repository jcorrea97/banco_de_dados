package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bd.ConnectionFactory;
import model.Contato;
import model.Publicacao;
import model.Editora;

/**
 * DAO que gerencia sele��es e inser��es em publicacoes
 *
 */
public class EditoraDAO extends GenericDAO{
	
	public EditoraDAO() {
		super();
	}
	
	/**
	 * Adiciona uma editora
	 * @param editora
	 */
	public int adiciona(String editora) {
		
			Editora edit = new Editora(editora);
			
			String sql = "insert into editoras (editora) values (?)";
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, edit.getEditora());
			stmt.execute();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("Criar editora falhou, nenhum ID obtido");
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
	public Editora seleciona(int id_editora) {
	
			String sql = "select id_editora, editora from editoras where id_editora = ?";
			
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_editora);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Editora edit = new Editora (
		            				rs.getString("editora")
		            			);
		            	edit.setId_editora(rs.getInt("id_editora"));
		            	return edit;
		            }
		            else {
		                throw new SQLException("nenhuma publica��o encontrada com o id passado: " + id_editora);
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
	public List<Editora> selecionaTudo() {
		String sql = "select id_editora, editora from editoras";
		
		try {			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	List<Editora> listaedit = new ArrayList<Editora>();
		            	do {
		            	Editora edit = new Editora (
		            				rs.getString("editora")
		            			);
		            	edit.setId_editora(rs.getInt("id_editora"));
		            	listaedit.add(edit);
		            	} 
		            	while (rs.next());
		            	return listaedit;
		            }
		            else {
		            	return null;
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
