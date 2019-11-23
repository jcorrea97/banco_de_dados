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
import model.*;


public class CapitulosDAO extends GenericDAO{
	
	public CapitulosDAO() {
		super();
	}
	
	
	public int adiciona(int id_livro, int capitulo) {
		
			Capitulo cap = new Capitulo(id_livro, capitulo);
			
			String sql = "insert into capitulos (id_livro,capitulo) values (?,?)";
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, cap.getId_livro());
			stmt.setInt(2, cap.getCapitulo());
			stmt.execute();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("Criar capitulo falhou, nenhum ID obtido");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	
	public Capitulo seleciona(int id_capitulo) {
	
			String sql = "select id_capitulo, id_livro, capitulo from capitulos where id_capitulo = ?";
			
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_capitulo);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Capitulo cap = new Capitulo (
		            				rs.getInt("id_livro"),
		            				rs.getInt("capitulo")
		            			);
		            	cap.setId_capitulo(rs.getInt("id_capitulo"));
		            	return cap;
		            }
		            else {
		                throw new SQLException("nenhuma capituloencontrada com o id passado: " + id_capitulo);
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Capitulo> selecionaTudo() {
		String sql = "select id_capitulo, id_livro, capitulo from capitulos";
		
		try {			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	List<Capitulo> listcap = new ArrayList<Capitulo>();
		            	do {
		            	Capitulo cap = new Capitulo (
		            				rs.getInt("id_capitulo"),
		            				rs.getInt("id_livro")
		            			);
		            	cap.setId_capitulo(rs.getInt("id_capitulo"));
		            	listcap.add(cap);
		            	} 
		            	while (rs.next());
		            	return listcap;
		            }
		            else {
		            	return null;
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Capitulo> selecionaTudoJOinLIvro() {
		String sql = "select * from capitulos inner join livros on capitulos.id_capitulo = livros.id_livro";
		
		try {			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	List<Capitulo> listcap = new ArrayList<Capitulo>();
		            	do {
		            	Capitulo cap = new Capitulo (
		            				rs.getInt("id_capitulo"),
		            				rs.getInt("id_livro")
		            			);
		            	cap.setId_capitulo(rs.getInt("id_capitulo"));
		            	listcap.add(cap);
		            	} 
		            	while (rs.next());
		            	return listcap;
		            }
		            else {
		            	return null;
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	public int remove(int id_cap) {
			String sql = "delete from capitulos where id_capitulo = ?";
			
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, id_cap);
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
