package insere;

import java.sql.*;

import bd.ConnectionFactory;
import tables.Contato;


public class ContatoDAO {
	private Connection connection;
	
	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		// metodo de teste para inserir nessa table contatos
		String sql = "insert into contatos (nome,email,endereco, datansci) values (?,?,?,?)";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new Date( contato.getDatasci().getTimeInMillis()));
	
		stmt.execute();
		stmt.close();
		
	}catch (SQLException e) {
		throw new RuntimeException(e);
	}

	}
}

