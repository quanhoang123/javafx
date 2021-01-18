package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static final String URL = "jdbc:mysql://localhost:3307/Project";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	
public static Connection getConnection() {
	try {
		// Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;

}
}
