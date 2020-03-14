package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnexion {
	private static Connection connexion;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest","root",""); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnexion() {
		return connexion;
	}
	
}
