package dao;

import java.sql.Connection;

import bd.ConnectionFactory;

public class GenericDAO {

	Connection con;
	
	public GenericDAO() {
		this.con = new ConnectionFactory().getConnection();
	}
	
	public GenericDAO(Connection con) {
		this.con = con;
	}
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	
}
