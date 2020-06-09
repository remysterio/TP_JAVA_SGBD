package iti.java3d.mission2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import iti.java3d.modele.Facture;
import iti.java3d.modele.Paiement;

public class PaiementDAO implements IPaiementDAO{

	private Connection conn;
	
	public PaiementDAO() {
		super();
		this.conn = DAO.getConnexion();
	}
	
	//On recupere un objet paiement selon l'ID de l'objet paiement passer en argument
	public Paiement getPaiementByID(Paiement paie) {
		// TODO Auto-generated method stub
		try {
			//On definit l'instruction
			String req = "Select * from Balneo_Paiement where paie_no = ?";
			//On prepare la requete
			PreparedStatement pstmt = conn.prepareStatement(req);
			//On recupere l'ID passer en argument
			pstmt.setInt(1,paie.getPaie_no());
		    ResultSet result = pstmt.executeQuery();
		    result.next();
		    Paiement paiement = new Paiement(result.getInt(1), result.getInt(2),result.getString(3), result.getInt(4));
		    if (result.next()) {
		    	System.out.println("Il y a plus d'un paiement avec cette ID");
		    	return paiement;
		    }	
		    return paiement;
		}
		catch (Exception e){
			e.printStackTrace();						
		}
		return null;
	}


	//On recupere tous les paiements de la DB dans un ArrayList
	@Override
	public ArrayList<Paiement> getPaiementByFacture(Facture fact) {
		// TODO Auto-generated method stub
	    ArrayList<Paiement> liste= new ArrayList<Paiement>();	//Declaration de l'ArrayList
   
	    
		try {
    		String req = "Select * from Balneo_Paiement where fact_no = ?";
    		PreparedStatement pstmt = conn.prepareStatement(req);
			pstmt.setInt(1, fact.getFact_no());
		    ResultSet result = pstmt.executeQuery(req);
		    if (result==null) {
		    	return null;
		    }
		    //On réalise une boucle while pour récuperer toutes les valeurs tant le pointeur Resultset en détecte
		    while (result.next()) {								
		    	//Rajout des valeurs indiquées par le select
		    	liste.add(new Paiement(result.getInt(1), result.getInt(2),result.getString(3), result.getInt(4)));
		    }		
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return liste;
	}


	//Fonction ajoutant un objet facture, passer en argument ds la DB et retourne un BOOL selon la reussite
	//True = Succes ; False = echec
	@Override
	public boolean addPaiementFacture(Paiement pmt, Facture fact) {
		String req = "Insert into Balneo_Paiement values (?,?,?,?,?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(req);
			//Ajout des valeurs de paiement avec les getters et setters
		
			pstmt.setInt(1,pmt.getPaie_no());
			pstmt.setInt(2,fact.getFact_no());
			pstmt.setString(3,pmt.getPaie_date());
			pstmt.setFloat(4,pmt.getPaie_montant());
			int res = pstmt.executeUpdate();
			//Si valeurs insérés alors retourne true
			if (res == 1) {
				return true;
			}
		

		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
	

	//Fonction supprimant un objet paiement, passer en argument ds la DB et retourne un BOOL selon la reussite
	//True = Succes ; False = echec
	@Override
	public boolean deletePaiementbyFacture(Paiement pmt, Facture fact) {
		// TODO Auto-generated method stub
		String req = "Delete from Balneo_Paiement where fact_no  = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(req);
			pstmt.setInt(1,fact.getFact_no() );
			pstmt.executeUpdate();
			System.out.println("Paiement supprimé");
			return true;
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
		
	}

	



}
