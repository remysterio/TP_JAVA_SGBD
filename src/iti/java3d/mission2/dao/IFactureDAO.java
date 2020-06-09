package iti.java3d.mission2.dao;

import java.util.ArrayList;

import iti.java3d.modele.Facture;

interface IFactureDAO {
	public Facture getFactureByID(Facture fact);
	public ArrayList<Facture> getAllFacture();
	public boolean deleteFacture(Facture fact);
	public boolean addFacture(Facture fact);
}
