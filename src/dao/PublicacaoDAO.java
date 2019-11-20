package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * Adiciona uma publicação
	 * @param tipo_publicacao_
	 * @param local_publicacao_
	 * @return id da publicação inserida
	 */
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
	
	/**
	 * Adiciona uma publicação
	 * @param pub - Objeto do tipo Publicacao a ser inserido
	 * @return id da publicação inserida
	 */
	public int adiciona(Publicacao pub) {
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
	
	/**
	 * Retorna um objeto do tipo publicação com o determinado ID
	 * @param id_pub
	 * @return Publicacao
	 */
	public Publicacao seleciona(int id_pub) {
	
			String sql = "select id_pub, local_publicacao, tipo_publicacao from publicacoes where id_pub = ?";
			
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_pub);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Publicacao pub = new Publicacao (
		            				rs.getString("tipo_publicacao"),
		            				rs.getString("local_publicacao")
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
	
	/**
	 * Retorna um objeto do tipo publicação com o determinado ID
	 * @param id_pub
	 * @return Publicacao
	 */
	public List<Publicacao> selecionaPorTipo(String tipo_publicacao) {
	
			String sql = "select id_pub, local_publicacao, tipo_publicacao from publicacoes where tipo_publicacao = '?'";
			
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, tipo_publicacao);
				return executaSelecionaLista(stmt);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
	}
	
	public List<Publicacao> selecionaPorLocal(String local_publicacao) {
		
		String sql = "select id_pub, local_publicacao, tipo_publicacao from publicacoes where local_publicacao = '?'";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, local_publicacao);
			return executaSelecionaLista(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
}
	
	/**
	 * Lista todas as publicações presentes no Banco de dados, se nenhuma for encontrada retorna Null
	 * @return List<Publicacao>
	 */
	public List<Publicacao> selecionaTudo() {
		
		String sql = "select id_pub, local_publicacao, tipo_publicacao from publicacoes";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			return executaSelecionaLista(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	
	
	/**
	 * Remove uma publicação
	 * @param id
	 * @return id da publicação removida
	 */
	public int remove(int id_pub) {
			String sql = "delete from publicacoes where id_pub = ?";
			
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, id_pub);
			stmt.executeUpdate();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("Não foi possível remover: id não encontrado");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private List<Publicacao> executaSelecionaLista(PreparedStatement stmt) {
		try {			
			stmt.execute();	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	List<Publicacao> listaPubs = new ArrayList<Publicacao>();
		            	do {
		            	Publicacao pub = new Publicacao (
		            				rs.getString("tipo_publicacao"),
		            				rs.getString("local_publicacao")
		            			);
		            	pub.setId_pub(rs.getInt("id_pub"));
		            	listaPubs.add(pub);
		            	} 
		            	while (rs.next());
		            	return listaPubs;
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
