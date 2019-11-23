package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bd.ConnectionFactory;
import model.Contato;

public class MonografiaDAO {
private Connection connection;
	
	public MonografiaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		
		
		String sql = "insert into publicacoes (nome,email,endereco,datansci) values (?,?,?,?)";
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
