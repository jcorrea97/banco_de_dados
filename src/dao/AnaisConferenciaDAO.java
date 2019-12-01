package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Anais_conferencia;


public class AnaisConferenciaDAO extends GenericDAO{

	public AnaisConferenciaDAO() {
		super();
	}

	
	public int adiciona(String id_editora2, String volume, String numero, String data) {

		Anais_conferencia anaisConf = new Anais_conferencia(id_editora2, volume,  numero,data);

		String sql = "insert into anais_de_conferencia (id_editora, volume, numero, data) values (?,?, ?)";
		try {

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, anaisConf.getId_editora());
			stmt.setString(2, anaisConf.getVolume());
			stmt.setInt(2, anaisConf.getNumero());
			stmt.setString(3, anaisConf.getData());
			
			stmt.execute();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("Criar anais_de_conferencia falhou, nenhum ID obtido");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public Anais_conferencia seleciona(int id_anal_conf) {

		String sql = "select * from anais_de_conferencia where id_anal_conf = ?";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_anal_conf);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Anais_conferencia anal_conf = new Anais_conferencia (
		            				rs.getString("id_editora"),
		            				rs.getString("volume"),
		            				rs.getString("numero"),
		            				rs.getString("data"));
		            	anal_conf.setId_anal_conf(rs.getInt("id_anal_conf"));
		            	return anal_conf;
		            }
		            else {
		                throw new SQLException("nenhum livro encontrada com o id passado: " + id_anal_conf);
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}