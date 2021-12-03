package model.DAO;

import java.sql.Connection;

public class ConnectionFactory {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String banco = "jdbc.mysql://localhost:3306/bancoloja";
	private static final String user = "root";
	private static final String senha = "ifsc";
	
    public static Connection getConnection() {
    	return null;
    }
}
