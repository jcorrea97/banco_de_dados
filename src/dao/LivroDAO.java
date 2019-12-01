package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Autor;
import model.Livro;
import model.Publicacao;


public class LivroDAO extends GenericDAO{

	public LivroDAO() {
		super();
	}

	
	public int adiciona(String id_editora, String titulo, String tipo_livro, String titulo_original, String num_edicao, String ano_pub, String num_pag) {

		Livro liv = new Livro(id_editora, titulo, tipo_livro, titulo_original, num_edicao, ano_pub, num_pag);

		String sql = "insert into livros (id_editora, titulo, tipo_livro, titulo_original, num_edicao, ano_pub, num_pag) values (?,?, ?,?,?,?,?)";
		try {

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, liv.getId_editora());
			stmt.setString(2, liv.getTitulo());
			stmt.setString(3, liv.getTipo_livro());
			stmt.setString(4, liv.getTitulo_original());
			stmt.setInt(5, liv.getNum_edicao());
			stmt.setString(6, liv.getAno_pub());
			stmt.setInt(7, liv.getNum_pg());
			stmt.execute();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("Criar Livro falhou, nenhum ID obtido");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public Livro seleciona(int id_livro) {

		String sql = "select * from livro where id_livro = ?";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_livro);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Livro liv = new Livro (
		            				rs.getString("id_editora"),
		            				rs.getString("titulo"),
		            				rs.getString("tipo_livro"),
		            				rs.getString("titulo_original"),
		            				rs.getString("num_edicao"),
		            				rs.getString("ano_pub"),
		            				rs.getString("num_pg")
		            			);
		            	liv.setId_livro(rs.getInt("id_livro"));
		            	return liv;
		            }
		            else {
		                throw new SQLException("nenhum livro encontrada com o id passado: " + id_livro);
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}