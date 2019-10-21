package fr.cfai.scrumboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBdd {

	 public static Connection getConnection() throws SQLException, ClassNotFoundException {
         Class.forName("com.mysql.jdbc.Driver");
         Connection connection = DriverManager.getConnection("jdbc:mysql://62.210.119.152:49158/arthur?verifyServerCertificate=false&useSSL=false","arthur","arthur");
         return connection ;
 }
	 public static void close() throws ClassNotFoundException, SQLException {
		 getConnection().close();
	 }

}
