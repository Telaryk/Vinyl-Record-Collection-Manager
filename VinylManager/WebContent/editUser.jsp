<%@ include file="entete.jsp"%>
<div id="page">
	<br><br>
	<center>
	<%for (User u:listes){
		if(!u.getPseudo().equals("")) { %>
		<form name="firstForm" action="editUser" method="POST" 
             style="width:50%;margin:auto;padding-bottom:15px;">
		
			<div style="text-align:center;">		
				<h2 style="color:black;">Edit user information</h2>
				
				<p>Surname : <input type="text" name="pseudo" value=<%=u.getPseudo() %> onclick="pseudo.value='';" /></p>
				<p>Email : <input type="text" name="email" value=<%=u.getEmail() %> onclick="email.value='';" /></p>
				<p>First name : <input type="text" name="prenom" value=<%=u.getPrenom() %> onclick="prenom.value='';" /></p>
				<p>Last name : <input type="text" name="nom" value=<%=u.getNom() %> onclick="nom.value='';" /></p>
				
				<p style="width:50%;margin:auto;"><input type="submit" name="bouton" value="Submit"/></p>
			</div>
		</form>	
		<%}
	}%>
	</center>
</div>
<%@include file="footer.jsp"%>