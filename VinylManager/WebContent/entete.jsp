<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,modeles.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Vinyl Record Collection Manager</title>
	<style type="text/css">
		<%@ include file="/css/bootstrap.css" %>
	</style>
</head>

<body>
	<center>
		<div id="bannier">
			<div id="menucon">
				<table width="750" border="0">
					<tr>
						<td width="388">
							<b>Vinyl Manager</b>
							<a href="index.jsp" title="Rechercher"/>Search</a>
							<%ArrayList<modeles.User> listes=(ArrayList<modeles.User>) session.getAttribute("listes");
							if(listes == null || listes.size() == 0){%>
<!--								do nothing-->
							<%} else {%>
								<a href="TraiteClient?lien=lister" title="Liste des clients de la banque"/>My playlists</a>
								<a href="TraiteClient?lien=lister" title="Liste des clients de la banque"/>Add entries </a>
							<%}%>
						</td>
						<td width="107">
						<%if(listes == null || listes.size() == 0){%>
							<a href="formInscription.jsp" title="Creer un compte"/>Create an account</a>
							<a href="formLogin.jsp" title="Login"/>Log in</a>
						<%} else {
							for (User u:listes){
								if(!u.getPseudo().equals("")) { %>
									<a href="profilUser.jsp" title="Compte"/><%=u.getPseudo() %></a>
									<a href="editUser.jsp" title="Edit"/>edit</a>
									<a href="login?lien=logoff" title="Login"/>log out</a>
								<%}
							}
						}%>
							
							
						</td>
					</tr>
				</table>
			</div>
		</center>