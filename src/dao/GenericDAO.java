package dao;

import java.sql.Connection;

import bd.ConnectionFactory;

public class GenericDAO {

	Connection con;
	
	public GenericDAO() {
		this.con = new ConnectionFactory().getConnection();
	}
	
	
}
