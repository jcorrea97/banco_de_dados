package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Editora;
import model.Emprestimo;


public class EmprestimosDAO extends GenericDAO{

	public EmprestimosDAO() {
		super();
	}

	
	public int adiciona(Emprestimo emp) {

		String sql = "insert into emprestimos (id_pub, data_devolucao, data_emprestimo, cpf_cnpj_pessoa) values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, emp.getId_pub());
			stmt.setDate(2, emp.getData_devolucao());
			stmt.setDate(3, emp.getData_emprestimo());
			stmt.setString(4, emp.getCpf_cnpj_pessoa());
			
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

		String sql = "select * from emprestimos where id_emprestimo = ?";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_emprestimo);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Emprestimo emp = new Emprestimo ();
		            	
		            		emp.setId_pub(rs.getInt("id_pub"));		            			
		            		emp.setData_devolucao(rs.getDate("data_devolucao"));		            			
		            		emp.setData_emprestimo(rs.getDate("data_emprestimo"));		            			
		            		emp.setCpf_cnpj_pessoa(rs.getString("cpf_cnpj_pessoa"));		            			
		            		emp.setId_emprestimo(rs.getInt("id_emprestimo"));
		            		
		            	return emp;
		            }
		            else {
		                throw new SQLException("nenhum emprestimo encontrado com o id passado: " + id_emprestimo);
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Emprestimo> selecionaTudo() {
		String sql = "select * from emprestimos";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();	
			 try (ResultSet rs = stmt.getResultSet()) {
				 List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		            if (rs.next()) {
		            	do {
		            		Emprestimo emp = new Emprestimo();
		            		
		            		emp.setId_pub(rs.getInt("id_pub"));		            			
		            		emp.setData_devolucao(rs.getDate("data_devolucao"));		            			
		            		emp.setData_emprestimo(rs.getDate("data_emprestimo"));		            			
		            		emp.setCpf_cnpj_pessoa(rs.getString("cpf_cnpj_pessoa"));		            			
		            		emp.setId_emprestimo(rs.getInt("id_emprestimo"));
		            		
		            		emprestimos.add(emp);
		            	} 
		            	while (rs.next());
		            	return emprestimos;
		            }
		            else {
		            	return emprestimos;
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}