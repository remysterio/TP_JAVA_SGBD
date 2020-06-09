package iti.java3d.mission2;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import iti.java3d.mission2.dao.DAO;
import iti.java3d.mission2.dao.FactureDAO;
import iti.java3d.mission2.dao.PaiementDAO;
import iti.java3d.modele.Facture;
import iti.java3d.modele.Paiement;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactureDAO fdao = new FactureDAO();
		PaiementDAO pdao = new PaiementDAO();
		
		Scanner sc = new Scanner(System.in);
		switch (0) 
		{
		//ETAPE 2 : GetFactureById
		case 0 :
			
			System.out.println("Donner l'Id d'une facture à chercher");
			
			
			System.out.println(fdao.getFactureByID(new Facture(sc.nextInt(),"",0)));
			break;
		//Etape 3 : addFacture
		case 1 :
			Facture fact = new Facture();
			System.out.print("Insertion d'une nouvelle facture : \n no facture : ");
			fact.setFact_no(sc.nextInt());
			System.out.print("Fact date : ");
			sc.nextLine();
			fact.setFact_Date(sc.nextLine());
			System.out.print("Fact montant: ");
			fact.setFact_montant(sc.nextInt());
			System.out.println(fdao.addFacture(fact));
			break;
		//Etape X
		//deleteFacture 
		case 2:
			
			System.out.println("Donner l'Id de la facture à delete");
			
			
			System.out.println(fdao.deleteFacture(new Facture(sc.nextInt(),"",0)));
			break;
		//deleteFacture    
		case 3 :
			ArrayList<Facture> liste = fdao.getAllFacture();
			for(int i=0;i<liste.size();i++) {
				liste.get(i).toString();
			}
			break;
		//Get Paiement by Id
		case 4:
			System.out.println("Donner l'Id d'un paiement à chercher");
			
			
			System.out.println(pdao.getPaiementByID(new Paiement(sc.nextInt(),0,"",0)));
			
			break;
			
		
		    }
		}
		
	}

