package metier;

import java.util.List;

public class TestMetier {

	public static void main(String[] args) {
		IcatalogueMetier metier = new CatalogueMetierImpl();
		/*metier.addProduit(new Produit("REF01","AA",870,12));
		metier.addProduit(new Produit("REF02","ABB",8710,1782));
		metier.addProduit(new Produit("REF03","CCCC",970,1782));
		metier.addProduit(new Produit("REF04","DDD",8702,1542));
		metier.addProduit(new Produit("REF05","EEE",8120,1522));
		metier.addProduit(new Produit("REF06","FFF",8780,128));
		metier.addProduit(new Produit("REF07","AZSSA",41870,120));*/
		
		
		System.out.println("-----------DELETE produit-------------");
		try {
			 metier.deleteProduit("REF07");
			List<Produit> listProdst = metier.listeProduit();
			for(Produit p:listProdst) {
				System.out.println(p.getDesignation());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
