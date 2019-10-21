package fr.cfai.scrumboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBdd {

	 public static Connection getConnection() throws SQLException, ClassNotFoundException {
         Class.forName("com.mysql.jdbc.Driver");
         Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8000/arthur?verifyServerCertificate=false&useSSL=false","root","root");
         return connection ;
 }
	 public static void close() throws ClassNotFoundException, SQLException {
		 getConnection().close();
	 }

}
