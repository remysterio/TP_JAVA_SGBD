package iti.java3d.mission2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	 
	//Creer la connexion à la DB
	public static Connection getConnexion() {
		 
    try {
    	//On check le driver
    	Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver ok");
		//On creer la connexion
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@thor.ensea.fr:1521:orcl","rsenay","rsenay");
		System.out.println("connection ok");
		//On retourne l'objet connexion pret à etre manipuler
		return conn;
    } 
   catch (ClassNotFoundException|SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    //retourne nul si KO
	return null;
  }      
}
