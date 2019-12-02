package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Emprestimo;


public class EmprestimoDAO extends GenericDAO{

	public EmprestimoDAO() {
		super();
	}

	
	public int adiciona(String publicacao_emprestimo) {

		Emprestimo emp = new Emprestimo(publicacao_emprestimo);

		String sql = "insert into emprestimo (publicacao_emprestimo) values (?)";
		try {

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, emp.getPublicacao_emprestimo());
			
			stmt.execute();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("Criar emprestimo falhou, nenhum ID obtido");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public Emprestimo seleciona(int id_emprestimo) {

		String sql = "select * from emprestimo where id_emprestimo = ?";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_emprestimo);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Emprestimo emp = new Emprestimo (
		            				rs.getString("publicacao_emprestimo")
		            			);
		            	emp.setId_emprestimo(rs.getInt("id_emprestimo"));
		            	return emp;
		            }
		            else {
		                throw new SQLException("nenhum livro encontrada com o id passado: " + id_emprestimo);
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}