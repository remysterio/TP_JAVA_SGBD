package iti.java3d.mission2.dao;

import java.util.ArrayList;

import iti.java3d.modele.Facture;
import iti.java3d.modele.Paiement;

public interface IPaiementDAO {
	
	public Paiement getPaiementByID(Paiement pmt);
	public ArrayList<Paiement> getPaiementByFacture(Facture fct);
	public boolean deletePaiementbyFacture(Paiement pmt,Facture fct);
	public boolean addPaiementFacture(Paiement pmt,Facture fct);
	
}