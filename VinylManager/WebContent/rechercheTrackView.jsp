<%@ include file="entete.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<div id="page">
	<br><br>
	<center>
		<form name="rechercheForm" action="recherche" method="POST" 
	             style="width:70%;margin:auto;padding-bottom:10px;">
			
			<div style="text-align:center;">
				
				<input type="text" name="recherche" value="Search music" onclick="recherche.value='';"/>
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
				<p style="width:70%;margin:auto;"><input type="submit" name="bouton" value="Search"/></p>
			</div>
		</form>
	</center>
	<br><br>
	<center>
		<table>
			<thead>
				<tr> <th>Title</th> <th>Artist</th> <th>Playing time</th> <th>Record</th> <th>Label</th> <th>Release date</th> <th>Style</th> </tr>
			</thead>
			<tbody>
				<%ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
				arrayOfTrack = (ArrayList<Track>)request.getAttribute("arrayOfTrack");
				for(Track track : arrayOfTrack){%>
					<tr>
						<td>
							<%=track.getTitle() %>
						</td>
						<td>
							<%=track.getArtist().getName() %>
						</td>
						<td>
							<%SimpleDateFormat dateFormatTime = new SimpleDateFormat("mm:ss"); 
							String playingTimeString = dateFormatTime.format(track.getPlaying_time());%>
							<%=playingTimeString %>
						</td>
						<td>
							<a href="profilUser" title="Album"/><%=track.getRecord().getName() %></a>
						</td>
						<td>
							<%=track.getLabel() %>
						</td>
						<td>
							<%SimpleDateFormat dateFormatDate = new SimpleDateFormat("yyyy/MM/dd"); 
							String releaseDateString = dateFormatDate.format(track.getRelease_date());%>
							<%=releaseDateString %>
						</td>
						<td>
							<%=track.getStyle() %>
						</td>
					</tr>
				<%}%>
			</tbody>
		</table>
	</center>
</div>
<%@include file="footer.jsp"%>