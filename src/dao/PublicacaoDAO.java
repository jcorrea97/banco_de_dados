package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bd.ConnectionFactory;
import model.Contato;
import model.Publicacao;

/**
 * DAO que gerencia seleções e inserções em publicacoes
 *
 */
public class PublicacaoDAO extends GenericDAO{
	
	public PublicacaoDAO() {
		super();
	}
	
	public int adiciona(String tipo_publicacao_, String local_publicacao_) {
		
		Publicacao pub = new Publicacao(tipo_publicacao_, local_publicacao_);
		
		String sql = "insert into publicacoes (tipo_publicacao,local_publicacao) values (?,?)";
	try {
		
		PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		stmt.setString(1, pub.getTipo_publicacao());
		stmt.setString(2, pub.getLocal_publicacao());
		stmt.execute();

		 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	               return generatedKeys.getInt(1);
	            }
	            else {
	                throw new SQLException("Criar publicação falhou, nenhum ID obtido");
	            }
	        }
		
	}catch (SQLException e) {
		throw new RuntimeException(e);
	}

	}
	
	public Publicacao seleciona(int id_pub) {
	
			String sql = "select id_pub, local_publicacao, tipo_publicacao from publicacoes where id_pub = ?";
			
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_pub);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Publicacao pub = new Publicacao (
		            				rs.getString("local_publicacao"),
		            				rs.getString("tipo_publicacao")
		            			);
		            	pub.setId_pub(rs.getInt("id_pub"));
		            	return pub;
		            }
		            else {
		                throw new SQLException("nenhuma publicação encontrada com o id passado: " + id_pub);
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
