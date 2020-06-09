package iti.java3d.mission2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import iti.java3d.modele.Facture;

public class FactureDAO implements IFactureDAO {
	private Connection conn;
	
	//Constructeur de la connexion
	public FactureDAO() {
		super();
		this.conn = DAO.getConnexion();
	}

	//On recupere un objet facture selon l'ID de l'objet facture passer en argument
	public Facture  getFactureByID(Facture fact) {
		try {
			//On défini l'instruction
			String req = "Select * from Balneo_Facture where fact_no = ?";
			//On prepare la requete
			PreparedStatement pstmt = conn.prepareStatement(req);
			//On recupere l'ID de facture
			pstmt.setInt(1,fact.getFact_no());
			
		    ResultSet result = pstmt.executeQuery();
		    result.next();
		    Facture f = new Facture(result.getInt(1),result.getString(2),result.getInt(3));
		    if (result.next()) {
		    	System.out.println("Il y a plus d'une facture avec cette ID");
		    	return f;
		    }
		    return f;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	//Fonction supprimant un objet facture, passer en argument ds la DB et retourne un BOOL selon la reussite
	//True = Succes ; False = echec
	public boolean deleteFacture(Facture fact) {
		String req = "Delete from Balneo_Facture where fact_no = ?";
		PaiementDAO dao = new PaiementDAO();
		try {
			PreparedStatement pstmt = conn.prepareStatement(req);
			
			pstmt.setInt(1, fact.getFact_no());	
			int res = pstmt.executeUpdate();
			//Si res=1 alors il y a eu modification d'une ligne dans la table = succes
			if (res == 1) {	
				return true;
			}
			return false;	
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	//Fonction ajoutant un objet facture, passer en argument ds la DB et retourne un BOOL selon la reussite
	//True = Succes ; False = echec
	public boolean addFacture(Facture fact) {
		String req = "Insert into Balneo_Facture values(?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(req);
			pstmt.setInt(1, fact.getFact_no());	
			pstmt.setString(2, fact.getFact_Date());
			pstmt.setInt(3, fact.getFact_montant());
			if (pstmt.executeUpdate()==1) { 	
				return true;
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	//On recupere toute les factures de la DB dans un ArrayList
	public ArrayList<Facture> getAllFacture() {
		ArrayList<Facture> facts = new ArrayList<Facture>();
		//Requete selectionnant toute les factures de la DB
		String req = "Select * from Balneo_Facture";
		try {
			//On travaille avec une requete deja etablie 
			Statement stmt = conn.createStatement();
			//On recupere la resultat
			ResultSet res = stmt.executeQuery(req);
			Facture fact = null;
			
			while(res.next()) {
				facts.add(new Facture(res.getInt(1),res.getString(2),res.getInt(3)));
			}
			//Si aucune facture on renvoie un Arraylist vide
			if(facts.size()==0) {		
				System.out.println("Aucune facture");
				return facts;
			}
			//On affiche les factures
			for (int i = 0;i<facts.size();i++) {
				System.out.println(facts.get(i));
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return facts;
	}
}
