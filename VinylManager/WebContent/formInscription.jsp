<%@ include file="entete.jsp"%>
<div id="page">
	<br><br>
	<form name="firstForm" action="inscription" method="POST" 
             style="width:70%;margin:auto;padding-bottom:10px;">
		
		<div style="text-align:center;">		
			<h2 style="color:black;">Create an account</h2>
			
			<p>Username : <input type="text" name="pseudo" /></p>
			<p>Password : <input type="password" name="motdepasse" /></p>
			<p>Email : <input type="text" name="email" /></p>
			<p>First name : <input type="text" name="prenom" /></p>
			<p>Last name : <input type="text" name="nom" /></p>
			
			
			
			<p style="width:70%;margin:auto;"><input type="submit" name="bouton" value="Submit"/></p>
		</div>
	</form>
</div>
<%@include file="footer.jsp"%>