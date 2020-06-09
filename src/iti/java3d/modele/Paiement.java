package iti.java3d.modele;

public class Paiement {


	private int paie_no;
	private int fact_no;
	private int paie_montant;
	private String paie_date;

	
	public Paiement(int paie_no, int fact_no, String paie_date, int paie_montant) {
		super();
		this.paie_no = paie_no;
		this.fact_no = fact_no;
		this.paie_montant = paie_montant;
		this.paie_date = paie_date;
	}


	public int getPaie_no() {
		return paie_no;
	}


	public void setPaie_no(int paie_no) {
		this.paie_no = paie_no;
	}


	public int getFact_no() {
		return fact_no;
	}


	public void setFact_no(int fact_no) {
		this.fact_no = fact_no;
	}


	public int getPaie_montant() {
		return paie_montant;
	}


	public void setPaie_montant(int paie_montant) {
		this.paie_montant = paie_montant;
	}


	public String getPaie_date() {
		return paie_date;
	}


	public void setPaie_date(String paie_date) {
		this.paie_date = paie_date;
	}


	@Override
	public String toString() {
		return "paie_no=" + paie_no + ", fact_no=" + fact_no + ", paie_montant=" + paie_montant
				+ ", paie_date=" + paie_date + "]";
	}

	
}
