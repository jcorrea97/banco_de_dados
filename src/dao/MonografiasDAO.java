package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Monografia;

public class MonografiasDAO extends GenericDAO{
	
	public MonografiasDAO() {
		super();
	}
	
	public MonografiasDAO(Connection con) {
		super(con);
	}
	
	public List<Monografia> selecionaTudo() {
		String sql = "select m.id_monografia as id_monografia, m.numero_monog as numero_monog, m.nome_instituicao as nome_instituicao, m.data as data, p.titulo_publicacao as titulo, p.local_publicacao as local_publicacao, p.tipo_publicacao as tipo_publicacao, p.tema_publicacao as tema_publicacao, p.titulo_publicacao as titulo_publicacao from monografias m"
				+ " inner join publicacoes p on m.id_monografia = p.id_pub";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			return executaSelecionaLista(stmt);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * seleciona um objeto Monografia com base no id_monografia passado
	 * @param id_monografia
	 * @return Monografia
	 */
	public Monografia seleciona (int id_monografia) {

		String sql = "select m.id_monografia as id_monografia, m.numero_monog as numero_monog, m.nome_instituicao as nome_instituicao,"
				+ " p.data as data, p.titulo_publicacao as titulo_publicacao, p.local_publicacao as local_publicacao, p.tipo_publicacao as tipo_publicacao, p.tema_publicacao as tema_publicacao from monografias m"
				+ " inner join publicacoes p on m.id_monografia = p.id_pub"
				+ " where id_monografia = ?";
		
		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id_monografia);
			stmt.execute();
	
			 try (ResultSet rs = stmt.getResultSet()) {
		            if (rs.next()) {
		            	Monografia mon = new Monografia();
		            	mon.setId(rs.getInt("id_monografia"));
		            	mon.setTitulo_publicacao("titulo_publicacao");
		            	mon.setData(rs.getDate("data")); //TODO Nao sei se funciona
		            	mon.setLocal_publicacao(rs.getString("local_publicacao"));
		            	mon.setNome_instituicao(rs.getString("nome_insituicao"));
		            	mon.setNumero_monog(rs.getInt("numero_monog"));
		            	mon.setTipo_publicacao(rs.getString("tipo_publicacao"));
		            	mon.setTema_publicacao(rs.getString("tema_publicacao"));
		            	return mon;
		            }
		            else {
		                throw new SQLException("nenhuma monografia encontrada com o id passado: " + id_monografia);
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private int adicionaMonografia(Monografia mon) {
		String sql = "insert into monografias (id_monografia,numero_monog, nome_instituicao, data) values (?,?,?,?)";
		try {

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, mon.getId_pub());
			stmt.setInt(2, mon.getNumero_monog());
			stmt.setString(3, mon.getNome_instituicao());
			// create a java calendar instance
			Calendar calendar = Calendar.getInstance();
			java.util.Date currentDate = calendar.getTime();
			java.sql.Date date = new java.sql.Date(currentDate.getTime());
			stmt.setDate(4, date);
			stmt.execute();
			 try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		               return generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("Criar Monografia falhou, nenhum ID obtido");
		            }
		        }
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int adiciona(Monografia mon) {
		try {
			con.setAutoCommit(false);
			try {
				PublicacoesDAO pubs = new PublicacoesDAO(con);
				int id_pub = pubs.adiciona(mon);
				mon.setId_pub(id_pub);
				adicionaMonografia(mon);
				con.commit();
				return id_pub;
			} catch (Exception e) {
				con.setAutoCommit(true);
				e.printStackTrace();
			}
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;	
	}
	
	private List<Monografia> executaSelecionaLista(PreparedStatement stmt) {
		try {			
			stmt.execute();	
			try (ResultSet rs = stmt.getResultSet()) {
				if (rs.next()) {
					List<Monografia> listaMonografias = new ArrayList<Monografia>();
					do {
						Monografia mon = new Monografia();
		            	mon.setId(rs.getInt("id_monografia"));
		            	mon.setTitulo_publicacao(rs.getString("titulo_publicacao"));
		            	mon.setData(rs.getDate("data")); //TODO Nao sei se funciona
		            	mon.setLocal_publicacao(rs.getString("local_publicacao"));
		            	mon.setNome_instituicao(rs.getString("nome_instituicao"));
		            	mon.setNumero_monog(rs.getInt("numero_monog"));
		            	mon.setTipo_publicacao(rs.getString("tipo_publicacao"));
		            	mon.setTema_publicacao(rs.getString("tema_publicacao"));
		            	listaMonografias.add(mon);
					} 
					while (rs.next());
					return listaMonografias;
				}
				else {
					return new ArrayList<Monografia>();
				}
			}

		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
