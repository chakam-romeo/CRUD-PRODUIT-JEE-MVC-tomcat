package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueMetierImpl;
import metier.IcatalogueMetier;
import metier.Produit;

public class ControllerServlet extends HttpServlet{
	private IcatalogueMetier metier;
	
	@Override
	public void init() throws ServletException {
		metier = new CatalogueMetierImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		ProduitModel model = new ProduitModel();
		if(action != null) {
			if(action.equals("chercher")) {
				
				model.setMotcle(request.getParameter("motcle"));
				
				List<Produit> listProduits = metier.listProduitMc(model.getMotcle());
				model.setListeProduit(listProduits);
				
			}else if(action.equals("delete")) {
				
				String reference = request.getParameter("ref");
				metier.deleteProduit(reference);
				model.setListeProduit(metier.listeProduit());
			}else if(action.equals("ajouter")) {
				try {
					model.getProduit().setReference(request.getParameter("reference"));
					model.getProduit().setDesignation(request.getParameter("designation"));
					model.getProduit().setQuantite(Integer.parseInt(request.getParameter("quantite")));
					model.getProduit().setPrix(Double.parseDouble(request.getParameter("prix")));
					model.setMode(request.getParameter("mode"));
					if(model.getMode().equals("edit")) {
						metier.updateProduit(model.getProduit());
					}else if(model.getMode().equals("add")){
						metier.addProduit(model.getProduit());
					}
					
					model.setListeProduit(metier.listeProduit());
				} catch (Exception e) {
					model.setErrorMsg(e.getMessage());
				}
				
			}else if(action.equals("update")) {
				try {
					Produit p = metier.getProduit(request.getParameter("ref"));
					model.setProduit(p);
					model.setMode("edit");
					/*model.getProduit().setReference(request.getParameter("reference"));
					model.getProduit().setDesignation(request.getParameter("designation"));
					model.getProduit().setQuantite(Integer.parseInt(request.getParameter("quantite")));
					model.getProduit().setPrix(Double.parseDouble(request.getParameter("prix")));
					
					metier.addProduit(model.getProduit());*/
					model.setListeProduit(metier.listeProduit());
				} catch (Exception e) {
					model.setErrorMsg(e.getMessage());
				}
				
			}
		}
		request.setAttribute("produitList", model);
		request.getRequestDispatcher("VueProduit.jsp").forward(request, response);
	}
}
