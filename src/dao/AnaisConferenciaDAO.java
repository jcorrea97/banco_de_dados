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

	
	public int adiciona(Anais_conferencia anaisConf) {
		
		try {
			con.setAutoCommit(false);
			PublicacoesDAO pubs = new PublicacoesDAO(con);
			int id_anal_conf = pubs.adiciona(anaisConf);

	
			String sql = "insert into anais_de_conferencia (id_editora, volume, numero, data, id_anal_conf) values (?,?,?,?,?)";
			try {
	
				PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	
				if(anaisConf.getId_editora() != -1)
				stmt.setInt(1, anaisConf.getId_editora());
				else stmt.setNull(1, java.sql.Types.INTEGER);
				stmt.setString(2, anaisConf.getVolume());
				stmt.setInt(3, anaisConf.getNumero());
				stmt.setDate(4, anaisConf.getData());
				stmt.setInt(5, id_anal_conf);
				
				stmt.execute();
				con.commit();
		
				 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
			            if (generatedKeys.next()) {
			               return generatedKeys.getInt(1);
			            }
			            else {
			                throw new SQLException("Criar anais_de_conferencia falhou, nenhum ID obtido");
			            }
			        }
				
				}catch (SQLException e) {
					con.setAutoCommit(true);
					throw new RuntimeException(e);
				}
		} catch(SQLException e) {
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
		            				rs.getInt("id_editora"),
		            				rs.getString("volume"),
		            				rs.getInt("numero"),
		            				rs.getDate("data"));
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


	public List<Anais_conferencia> selecionaTudo() {
		String sql = "select a.*, p.* from anais_de_conferencia a"
				+ " inner join publicacoes p on a.id_anal_conf = p.id_pub";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			return executaSelecionaLista(stmt);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private List<Anais_conferencia> executaSelecionaLista (PreparedStatement stmt) {
		try {			
			stmt.execute();	
			try (ResultSet rs = stmt.getResultSet()) {
				if (rs.next()) {
					List<Anais_conferencia> listaAnais = new ArrayList<Anais_conferencia>();
					do {
						Anais_conferencia anal = new Anais_conferencia(
								null, 
								rs.getString("volume"),
								rs.getInt("numero"),
								rs.getDate("data")
								);				
						
								anal.setId_anal_conf(rs.getInt("id_pub"));
								anal.setTipo_publicacao(rs.getString("tipo_publicacao"));
								anal.setLocal_publicacao(rs.getString("local_publicacao"));
								anal.setTitulo_publicacao(rs.getString("titulo_publicacao"));
								anal.setTema_publicacao(rs.getString("tema_publicacao"));
								
					
						listaAnais.add(anal);
					} 
					while (rs.next());
					return listaAnais;
				}
				else {
					return new ArrayList<Anais_conferencia>();
				}
			}

		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}