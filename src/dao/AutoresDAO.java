package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Autor;
import model.Capitulo;

public class AutoresDAO extends GenericDAO{
	
	public AutoresDAO() {
		super();
	}
	
	public int adiciona(Autor autor) {		
			
		String sql = "insert into autores (nome_autor) values (?)";
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, autor.getNome_autor());
			stmt.execute();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("Criar autor falhou, nenhum ID obtido");
		            }
		        }
			
			} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	/**
	 * seleciona um objeto Autor de acordo com o ID passado
	 * @param id_autor
	 * @return
	 */
	public Autor seleciona(int id_autor) {
		String sql = "select id_autor, nome_autor from autores where id_autor = ?";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_autor);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Autor autor = new Autor (
		            				rs.getString("nome_autor")
		            			);
		            	autor.setId_autor(rs.getInt("id_autor"));
		            	return autor;
		            }
		            else {
		                throw new SQLException("nenhum autor encontrado com o id passado: " + id_autor);
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * seleciona todos os autores
	 * @param id_autor
	 * @return
	 */
	public List<Autor> selecionaTudo() {
String sql = "select id_autor, nome_autor from autores";
		
		try {			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	List<Autor> listAutores = new ArrayList<Autor>();
		            	do {
		            	Autor autor = new Autor (
		            				rs.getString("nome_autor")
		            			);
		            	autor.setId_autor(rs.getInt("id_autor"));
		            	listAutores.add(autor);
		            	} 
		            	while (rs.next());
		            	return listAutores;
		            }
		            else {
		            	return null;
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
