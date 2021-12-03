package model.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String banco = "jdbc.mysql://localhost:3306/bancoloja";
	private static final String user = "root";
	private static final String senha = "ifsc";
	
    public static Connection getConnection() throws SQLException{
    	try {
    		return DriveManager.getConnection(banco + "?verifyServerCertificate-false" +
    				"&useSSL=false" + 
    				"&requireSSL=false" +
    				"&USER=" + user + "&password=" + senha +
    				"&serverTimezone=UTC");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
    }
}
