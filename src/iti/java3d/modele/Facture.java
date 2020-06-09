package iti.java3d.modele;

public class Facture {
	private int fact_no;
	private int fact_montant;
	private String fact_Date;
    private float solde;
	
	public Facture(int fact_no, String fact_Date, int fact_montant) {
		super();
		this.fact_no = fact_no;
		this.fact_Date = fact_Date;
		this.fact_montant = fact_montant;
	}

	
	public Facture() {
		// TODO Auto-generated constructor stub
	}


	public int getFact_no() {
		return fact_no;
	}


	public void setFact_no(int fact_no) {
		this.fact_no = fact_no;
	}


	public int getFact_montant() {
		return fact_montant;
	}


	public void setFact_montant(int fact_montant) {
		this.fact_montant = fact_montant;
	}


	public String getFact_Date() {
		return fact_Date;
	}


	public void setFact_Date(String fact_Date) {
		this.fact_Date = fact_Date;
	}


	public float getSolde() {
		return solde;
	}


	public void setSolde(float solde) {
		this.solde = solde;
	}


	public String toString() {
		return ("fact_no = " + fact_no + "\nfact_date = " + fact_Date + "\nfact_date = " + fact_Date);
	}
}