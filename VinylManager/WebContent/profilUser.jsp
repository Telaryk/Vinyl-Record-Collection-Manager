<%@ include file="entete.jsp"%>
<div id="page">
	<br><br>
	<center>
		<%for (User u:listes){
			if(!u.getPseudo().equals("")) { %>
		<table>
			<thead>
				<tr> <th> User information </th> <th> </th> </tr>	
			</thead>
			<tr>
				<td>
					Username
				</td>
				<td>
					<%=u.getPseudo() %>
				</td>
			</tr>
			<tr>
				<td>
					Password
				</td>
				<td>
					****
				</td>
			</tr>
			<tr>
				<td>
					Email
				</td>
				<td>
					<%=u.getEmail() %>
				</td>
			</tr>
			<tr>
				<td>
					First name
				</td>
				<td>
					<%=u.getPrenom() %>
				</td>
			</tr>
			<tr>
				<td>
					Last name
				</td>
				<td>
					<%=u.getNom() %>
				</td>
			</tr>
			<tfoot>
				<tr>
					<th>
						<a href="editUser.jsp" title="Compte"/>Edit user information</a>
					</th>
					<th>
						<a href="motDePasseUser.jsp" title="Compte"/>Edit password</a>
					</th>
				</tr>
			</tfoot>
		</table>
		<%}
	}%>
	</center>
</div>
<%@include file="footer.jsp"%>