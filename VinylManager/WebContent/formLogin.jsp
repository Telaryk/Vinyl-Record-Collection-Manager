<%@ include file="entete.jsp"%>
<div id="page">
	<br><br>
	<form name="firstForm" action="login" method="POST" 
             style="width:50%;margin:auto;padding-bottom:15px;">
		
		<div style="text-align:center;">		
			<h2 style="color:black;">Log in</h2>
			
			<p>Username : <input type="text" name="pseudo" /></p>
			<p>Password : <input type="password" name="motdepasse" /></p>
			
			<p style="width:50%;margin:auto;"><input type="submit" name="bouton" value="Log in"/></p>
		</div>
	</form>
</div>
<%@include file="footer.jsp"%>