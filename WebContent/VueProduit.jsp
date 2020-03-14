<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="Text/html;">
<title>Vue Produit</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript">
	function confirmer(url){
		var rep = confirm("Etes vous s�res de vouloir supprimer?");
		if(rep==true){
			document.location=url;		}
	}
</script>
</head>
<body>
<h1>Recherche produit</h1>

<form action="controlleur.php" method="post">
	<table >
		<tr>
			<td>Mot cl�</td>
			<td><input type="text" name="motcle" value="${produitList.motcle }"/></td>
			<td><input type="submit" value="chercher" name="action" /></td>
		</tr>
	
	</table>
</form>

<div>
<form action="controlleur.php" method="post">
	<table >
	<input type="hidden" value="${produitList.mode}" name="mode" />
	<c:if test="${produitList.mode == 'add' }">
		<tr>
			<td>REF:</td>
			<td><input type="text" name="reference" placeholder="Entrez la r�f�rence" value="${produitList.produit.reference }"/></td>
			<td></td>
		</tr>
	</c:if>
	<c:if test="${produitList.mode == 'edit' }">
		<tr>
			<td>REF:</td>
			<td>${produitList.produit.reference }<input type="hidden" name="reference" placeholder="Entrez la r�f�rence" value="${produitList.produit.reference }"/></td>
			<td></td>
		</tr>
	</c:if>
		<tr>
			<td>D�signation:</td>
			<td><input type="text" name="designation" placeholder="Entrez la d�signation" value="${produitList.produit.designation }" /></td>
			<td></td>
		</tr>
		<tr>
			<td>Quantit�:</td>
			<td><input type="text" name="quantite" placeholder="Entrez la quantite" value="${produitList.produit.quantite }"/></td>
			<td></td>
		</tr>
		<tr>
			<td>Prix:</td>
			<td><input type="text" name="prix" placeholder="Entrez le prix" value="${produitList.produit.prix }"/></td>
			<td></td>
		</tr>
		<tr>
			
			<td><input type="submit" value="ajouter" name="action" /></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</form>
<div>
	${produitList.errorMsg}
</div>
</div>
<div>
	<table class="table1">
		<tr>
			<th>REFERENCE</th>
			<th>DESIGNATION</th>
			<th>QUANTITE</th>
			<th>PRIX</th>
		</tr>
		<c:forEach items="${produitList.listeProduit }" var="produit">
			<tr>
				<td>${produit.reference }</td>
				<td>${produit.designation }</td>
				<td>${produit.quantite }</td>
				<td>${produit.prix }</td>
				<td><a href="javascript:confirmer('controller.php?action=delete&ref=${ produit.reference }')">Supprimer</a></td>
				<td><a href="controller.php?action=update&ref=${ produit.reference }">Modifier</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>