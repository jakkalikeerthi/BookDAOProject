package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	Connection con;
	public Connection getConnection() {
		try {
			//driver loading...
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","keerthi@123");
		}catch(Exception e) {
			System.out.println("Error::"+e);
		}
		return con;
	}
}

