package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Autor;
import model.Publicacao;

/**
 * DAO que gerencia selecoes e insercoes em publicacoes
 *
 */
public class PublicacoesDAO extends GenericDAO{

	public PublicacoesDAO() {
		super();
	}
	
	public PublicacoesDAO(Connection con) {
		super(con);
	}

	/**
	 * Adiciona uma publicacao
	 * @param tipo_publicacao_
	 * @param local_publicacao_
	 * @return id da publicacao inserida
	 */
	public int adiciona(String tipo_publicacao_, String local_publicacao_, String titulo_publicacao, String tema_publicacao) {

		Publicacao pub = new Publicacao(tipo_publicacao_, local_publicacao_, titulo_publicacao, tema_publicacao);

		String sql = "insert into publicacoes (tipo_publicacao,local_publicacao, tema_publicacao, titulo_publicacao) values (?,?,?,?)";
		try {

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, pub.getTipo_publicacao());
			stmt.setString(2, pub.getLocal_publicacao());
			stmt.setString(3, pub.getTema_publicacao());
			stmt.setString(4, pub.getTitulo_publicacao());
			stmt.execute();
	
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("Criar publicacao falhou, nenhum ID obtido");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Adiciona uma publicacao
	 * @param pub - Objeto do tipo Publicacao a ser inserido
	 * @return id da publicacao inserida
	 */
	public int adiciona(Publicacao pub) {
		String sql = "insert into publicacoes (tipo_publicacao,local_publicacao,tema_publicacao,titulo_publicacao)"
				+ " values (?,?,?,?)";
		try {

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, pub.getTipo_publicacao());
			stmt.setString(2, pub.getLocal_publicacao());
			stmt.setString(3, pub.getTema_publicacao());
			stmt.setString(4, pub.getTitulo_publicacao());
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
	 * Retorna um objeto do tipo publicacao com o determinado ID
	 * @param id_pub
	 * @return Publicacao
	 */
	public Publicacao seleciona(int id_pub) {

		String sql = "select id_pub, local_publicacao, tipo_publicacao, titulo_publicacao, tema_publicacao from publicacoes where id_pub = ?";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_pub);
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
		                throw new SQLException("nenhuma publicação encontrada com o id passado: " + id_pub);
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Retorna uma lista com as Publicacoes com o determinado Tipo
	 * @param tipo_publicacao
	 * @return List<Publicacao>
	 */
	public List<Publicacao> selecionaPorTipo(String tipo_publicacao) {

		String sql = "select * from publicacoes where tipo_publicacao = ?";

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

	/**
	 * Retorna uma lista com as Publicacoes com o determinado Local
	 * @param tipo_publicacao
	 * @return List<Publicacao>
	 */
	public List<Publicacao> selecionaPorLocal(String local_publicacao) {

		String sql = "select * from publicacoes where local_publicacao = '?'";

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
	 * Lista todas as publicacao presentes no Banco de dados, se nenhuma for encontrada retorna null
	 * @return List<Publicacao>
	 */
	public List<Publicacao> selecionaTudo() {

		String sql = "select * from publicacoes";
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
	 * Remove uma publicacao
	 * @param pub - Objeto do tipo Publicacao a ser inserido
	 * @return id da publicacao inserida
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
		                throw new SQLException("Não foi possivel remover: id nao encontrado");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	/**
	 * Cria um novo autor e o adiciona a publicacao com o id passado
	 * @param autor objeto autor a ser adicionado
	 * @param id_pub publicacao a receber o autor adicionado
	 * @return
	 */
	public Autor adicionaAutorNovoAPublicacao (Autor autor, int id_pub) {
		try {
			con.setAutoCommit(false);
			try {
				AutoresDAO autores = new AutoresDAO(con);
				int id_autor = autores.adiciona(autor);
				PublicacoesAutoresDAO linker = new PublicacoesAutoresDAO(con);
				linker.link(id_pub , id_autor);
				con.commit();
				autor.setId_autor(id_autor);
				return autor;
			} catch (Exception e) {
				con.setAutoCommit(true);
				e.printStackTrace();
			}
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	public Publicacao selecionaComAutores(int id_pub) {
			try {
				Publicacao pub = seleciona(id_pub);
				PublicacoesAutoresDAO linker = new PublicacoesAutoresDAO(con);
				List<Autor> autores = linker.pegaAutores(id_pub);
				if(autores != null && autores.size()>0) {
					pub.setAutores(autores);
				}
				return pub;
				
			} catch (Exception e) {				
				e.printStackTrace();
			}
		return null;	
	}
	
	public List<Publicacao> selecionaTudoComAutores() {
		
		String sql = "select p.*, a.* from publicacoes p " + 
				"left outer join publicacoes_autores pa on " + 
				"p.id_pub = (select p1.id_pub from publicacoes_autores as p1 where p.id_pub = p1.id_pub limit 1) " + 
				"join autores a on (a.id_autor = pa.id_autor) ";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			return executaSelecionaLista(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
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
								rs.getString("local_publicacao"),
								rs.getString("titulo_publicacao"),
								rs.getString("tema_publicacao")
								);
						try {
							String nome_autor = rs.getString("nome_autor");
							int id_autor = rs.getInt("id_autor");
							pub.setNome_autor(nome_autor);
							pub.setId_autor(id_autor);
							
						} catch (Exception e) {
							System.out.println("Publicacao sem autor");
						}
						pub.setId_pub(rs.getInt("id_pub"));
						listaPubs.add(pub);
					} 
					while (rs.next());
					return listaPubs;
				}
				else {
					return new ArrayList<Publicacao>();
				}
			}

		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}



}
