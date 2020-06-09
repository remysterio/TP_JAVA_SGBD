package iti.java3d.test;
import iti.java3d.modele.Facture;
import iti.java3d.modele.Paiement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import iti.java3d.dao.DAO;

public class JDBCPrepare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//On reprend le code pour preparer la connection jusqu'a obtenir l'objet conn
			//L'enonce demande de creer la classe JDBCPrepare contenant une methode main. Elle ne demander pas de creer une autre classe specifique
			//Du coup la classe contient le main qui reprend le code pour preparer la connection jusqu'a obtenir l'objet conn
			//Puis pour chacune de nos 3 fonctions correspondants aux 3 questions nous envoyons l'objet conn à des methodes
			//L'appel de ses fonctions se fera dans le main
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver ok");
			
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@thor.ensea.fr:1521:orcl","rsenay","rsenay");
			System.out.println("connection ok");

			recherche_exo5(conn);
			
		} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertion_exo5(Connection conn) {
		String req = "INSERT INTO balneo_facture VALUES (?,?,?)";
		//On prépare l'intitulé de la requete avec les ? pour les champs à remplir
		try {
			PreparedStatement pstmt = conn.prepareStatement(req);
			//On prepare l'objet de pré-requete
			Scanner sc = new Scanner(System.in);
			//Objet Scanner pour nos entrees clavier
	
			System.out.println("Saisissez le numéro de facture : ");
			pstmt.setInt(1, sc.nextInt());
			//On rempli le champ 1 de la pré-requete avec le Int rentré par clavier 
			sc.nextLine(); 
			// Vide le caractere espace
			
			System.out.println("Saisissez la date : ");
			pstmt.setDate(2, Date.valueOf(sc.nextLine()));
			//On rentre une date au format : yyyy-mm-dd
			
			System.out.println("Saisissez le montant : ");
			pstmt.setInt(3, sc.nextInt());
			
			int res = pstmt.executeUpdate();
			
			System.out.println("nb de modif realise : "+res);
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void recherche_exo5(Connection conn) {
		String req = "Select * from balneo_facture where fact_no=(?)";
		ArrayList<Facture> liste_facture = new ArrayList<Facture>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(req);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Entrer le numero de la facture que vous souhaitez afficher: \n ");
			pstmt.setInt(1, sc.nextInt());
			
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				System.out.println("fact_no = "+result.getString(1));
				System.out.println("fact_date = "+result.getDate(2));
				System.out.println("fact_montant = "+result.getString(3));
				liste_facture.add(new Facture(result.getString(1),result.getDate(2),result.getString(3)));
			}
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Facture c : liste_facture) {
			System.out.println(c.toString());
		}
	}
	
	public static void suppression_exo5(Connection conn) {
		String req = "delete from balneo_facture where fact_no=(?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(req);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("quel facture voulez vous supprimer: \n ");
			pstmt.setInt(1, sc.nextInt());
			
			int res = pstmt.executeUpdate();
			
			System.out.println("nb de modif realise : "+res);
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void recherchePaiement_exo6(Connection conn) {
		String req = "Select * from balneo_Paiement where fact_no=(?)";
		//On prepare la requete SQL pour rechercher les paiement en fct du numero de facture
		ArrayList<Paiement> liste_paiement = new ArrayList<Paiement>();
		//On creer l'arraylist contenant les objet paiement
		try {
			PreparedStatement pstmt = conn.prepareStatement(req);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Entrer le numero de la facture dont vous souhaitez afficher les paiements: \n ");
			pstmt.setInt(1, sc.nextInt());
			
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				System.out.println("fact_no = "+result.getString(1));
				System.out.println("paie_no = "+result.getString(2));
				System.out.println("paie_date = "+result.getDate(3));
				System.out.println("paie_montant = "+result.getString(4));
				System.out.println("-------------------------------------------");
				liste_paiement.add(new Paiement(result.getString(1),result.getString(2),result.getDate(3),result.getString(4)));
				//On ajoute un objet paiement dans la liste avec ses champs provenant du result
			}
		for(Paiement c : liste_paiement) {
			System.out.println(c.toString());
		}
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
