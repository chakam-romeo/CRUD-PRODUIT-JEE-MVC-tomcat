package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CatalogueMetierImpl implements IcatalogueMetier {

	@Override
	public List<Produit> listeProduit() {
		List<Produit> listProduits = new ArrayList<Produit>();
		Connection conn = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from CAT_PROD");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit prod = new Produit();
				
				prod.setReference(rs.getString("REF_PROD"));
				prod.setDesignation(rs.getString("DESIGNATION"));
				prod.setPrix(rs.getDouble("PRIX"));
				prod.setQuantite(rs.getInt("QUANTITE"));
				listProduits.add(prod);
			}
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return listProduits;
	}

	@Override
	public void addProduit(Produit p) {
		Connection conn = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into CAT_PROD values (?,?,?,?)");
			ps.setString(1, p.getReference());
			ps.setString(2, p.getDesignation());
			ps.setDouble(3, p.getPrix());
			ps.setInt(4, p.getQuantite());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<Produit> listProduitMc(String mc) {
		List<Produit> listProduits = new ArrayList<Produit>();
		Connection conn = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from CAT_PROD where DESIGNATION like ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit prod = new Produit();
				
				prod.setReference(rs.getString("REF_PROD"));
				prod.setDesignation(rs.getString("DESIGNATION"));
				prod.setPrix(rs.getDouble("PRIX"));
				prod.setQuantite(rs.getInt("QUANTITE"));
				listProduits.add(prod);
			}
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return listProduits;
	}

	@Override
	public void updateProduit(Produit p) {
		Connection conn = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = conn.prepareStatement("update CAT_PROD set DESIGNATION=?, PRIX=?, QUANTITE=? where REF_PROD=?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setString(4, p.getReference());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void deleteProduit(String reference) {
		Connection conn = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM CAT_PROD where REF_PROD=?");
			ps.setString(1, reference);
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public Produit getProduit(String reference) {
		Produit prod = null;
		Connection conn = SingletonConnexion.getConnexion();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from CAT_PROD where REF_PROD=?");
			ps.setString(1, reference);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				prod = new Produit();
				prod.setReference(rs.getString("REF_PROD"));
				prod.setDesignation(rs.getString("DESIGNATION"));
				prod.setPrix(rs.getDouble("PRIX"));
				prod.setQuantite(rs.getInt("QUANTITE"));
			}
				
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(prod == null) throw new RuntimeException("Produit " + reference + " introuvable");
		
		return prod;
	}

}
