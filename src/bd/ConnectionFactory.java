package bd;

import java.sql.*;
public class ConnectionFactory {
		public Connection getConnection() {
			try {
				return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","sql");
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
}
