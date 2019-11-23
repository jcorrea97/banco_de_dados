package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Autor;
import model.Publicacao;

public class PublicacoesAutoresDAO extends GenericDAO {

	public PublicacoesAutoresDAO() {
		super();
	}
	
	public PublicacoesAutoresDAO(Connection con) {
		super(con);
	}
	
	public void link (int id_pub, int id_autor) {

		String sql = "insert into publicacoes_autores (id_pub,id_autor) values (?,?)";
		try {

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, id_pub);
			stmt.setInt(2, id_autor);
			stmt.execute();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return;
		            }
		            else {
		                throw new SQLException("Criar ligação falhou, nenhum ID obtido");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Autor> pegaAutores (int id_pub) {
		
		String sql = 
				  "SELECT a.id_autor as id_autor, a.nome_autor as nome_autor from publicacoes_autores pa"
				+ " INNER JOIN autores a on pa.id_autor = a.id_autor"
				+ " WHERE id_pub = ?";
		
		try {	
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_pub);
			stmt.execute();	
			try (ResultSet rs = stmt.getResultSet()) {
				if (rs.next()) {
					List<Autor> listaAutores = new ArrayList<Autor>();
					do {
						Autor autor = new Autor(
								rs.getString("nome_autor")
								);
						autor.setId_autor(rs.getInt("id_autor"));
						listaAutores.add(autor);
					} 
					while (rs.next());
					return listaAutores;
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
