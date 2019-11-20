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
}
