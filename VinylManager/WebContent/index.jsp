<%@ include file="entete.jsp"%>
<div id="page">
	<br><br>
	<center>
		<form name="rechercheForm" action="recherche" method="POST" 
	             style="width:50%;margin:auto;padding-bottom:15px;"">
			
			<div style="text-align:center;">
				
				<input type="text" name="recherche" value="Search music"  onclick="recherche.value='';"/>
				<select name="menu">
					<option selected> --Select a view--</option>
					<option> Track View</option>
					<option> Records View</option>
					<option> Detail View</option>
				</select><br>
				<p>Filter : 
				<input type="radio" name="filter" value="none" checked> None
				<input type="radio" name="filter" value="track"> Track title
				<input type="radio" name="filter" value="artist"> Artist name
				<input type="radio" name="filter" value="record"> Record name </p>
				<p style="width:50%;margin:auto;"><input type="submit" name="bouton" value="Search"/></p>
			</div>
		</form>
	</center>
</div>
<%@include file="footer.jsp"%>