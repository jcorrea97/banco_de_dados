package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Artigo;
import model.Publicacao;

public class exercicioDAO extends GenericDAO {
	
	public exercicioDAO() {
		super();
	}
	
	public exercicioDAO(Connection con) {
		super(con);
	}

	
	// exercicio 3.4
	public List<Artigo> seleciona34() {
		String sql = "select * from artigos inner join artigos_de_anais "
				+ "on artigos.id_artigo_anais = artigos_de_anais.id_artigo ";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			return executaSelecionaLista(stmt);
			
		} catch (Exception e) {
			e.printStackTrace();
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
						art.setId_pub(rs.getInt("id_pub"));
						art.setTitulo_publicacao(rs.getString("titulo_publicacao"));
						art.setLocal_publicacao(rs.getString("local_publicacao"));
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
	
	// exercicio 3.4
	public Artigo seleciona342() {

		String sql = "select * from artigos inner join artigos_de_anais "
				+ "on artigos.id_artigo_anais = artigos_de_anais.id_artigo ";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Artigo pub = new Artigo (
		            				rs.getInt("id_periodico"),
		            				rs.getInt("id_editora"),
		            				rs.getString("tipo_artigo"),
		            				rs.getInt("id_livro"),
		            				rs.getInt("pg_inicial"),
		            				rs.getInt("pg_final"),
		            				rs.getInt("id_artigo_anais"),
		            				rs.getString("titulo_artigo"),
		            				rs.getInt("id_artigo")
		            			);
		            	pub.setId_pub(rs.getInt("id_periodico"));
		            	return pub;
		            }
		            else {
		                throw new SQLException("nenhum artigo");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	//exercicio 3.9
	public Publicacao seleciona39(String tit_pub) {

		String sql = "select local_publicacao from publicacoes where titulo_publicacao = ?";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tit_pub);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Publicacao pub = new Publicacao (
		            				rs.getString("tipo_publicacao"),
		            				rs.getString("local_publicacao"),
		            				rs.getString("titulo_publicacao"),
		            				rs.getString("tema_publicacao")
		            			);
		            	pub.setId_pub(rs.getInt("id_pub"));
		            	return pub;
		            }
		            else {
		                throw new SQLException("nenhuma publicao encontrada com o titulo passado: " + tit_pub);
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
