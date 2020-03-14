package metier;

import java.util.List;

public interface IcatalogueMetier {
	public List<Produit> listeProduit();
	public void addProduit(Produit p);
	public List<Produit> listProduitMc(String mc);
	public void updateProduit(Produit p);
	public void deleteProduit(String reference);
	public Produit getProduit(String reference);
	
	

}
