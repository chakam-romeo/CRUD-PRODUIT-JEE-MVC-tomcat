package metier;

import java.io.Serializable;

public class Produit implements Serializable{
	private String reference;
	private String designation;
	private int quantite;
	private double prix;
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Produit(String reference, String designation, int quantite, double prix) {
		super();
		
		this.reference = reference;
		this.designation = designation;
		this.quantite = quantite;
		this.prix = prix;
	}

	public String getReference() {
		return reference;
	}
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
