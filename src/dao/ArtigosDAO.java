package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Artigo;

public class ArtigosDAO extends GenericDAO {

	public ArtigosDAO() {
		super();
	}
	
	public ArtigosDAO(Connection con) {
		super(con);
	}
	
	public List<Artigo> selecionaTudo() {
		String sql = "select a.*, p.* from artigos a"
				+ " inner join publicacoes p on a.id_artigo = p.id_pub";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			return executaSelecionaLista(stmt);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	
public int adiciona(Artigo artigo) {		
		
		String sql = "insert into artigo (id_editora, id_livro, id_periodico, tipo_artigo, titulo_artigo, pg_inicial, pg_final, id_artigo_anais) values (?,?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, artigo.getId_editora());
			stmt.setInt(2, artigo.getId_livro());
			stmt.setInt(3, artigo.getId_periodico());
			stmt.setString(4, artigo.getTipo_artigo());
			stmt.setString(5, artigo.getTitulo_artigo());
			stmt.setInt(6, artigo.getPg_inicial());
			stmt.setInt(7, artigo.getPg_final());
			stmt.setInt(8, artigo.getId_artigo_anais());
			stmt.execute();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("Criar artigo falhou, nenhum ID obtido");
		            }
		        }
			
			} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	private List<Artigo> executaSelecionaLista(PreparedStatement stmt) {
		try {			
			stmt.execute();	
			try (ResultSet rs = stmt.getResultSet()) {
				if (rs.next()) {
					List<Artigo> listaArtigos = new ArrayList<Artigo>();
					do {
						Artigo art = new Artigo();
						//Atributos Publicacao
						art.setId_pub(rs.getInt("id_publicacao"));
						art.setTitulo_publicacao(rs.getString("titulo_publicacao"));
						art.setLocal(rs.getString("local_publicacao"));
						art.setTipo_publicacao(rs.getString("tipo_publicacao"));
						art.setTema_publicacao(rs.getString("tema_publicacao"));
						
						//Atributos Artigo
						art.setTipo_artigo(rs.getString("tipo_artigo"));
						art.setPg_inicial(rs.getInt("pg_inicial"));
						art.setPg_final(rs.getInt("pg_final"));
						
						listaArtigos.add(art);
					} 
					while (rs.next());
					return listaArtigos;
				}
				else {
					return new ArrayList<Artigo>();
				}
			}

		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
