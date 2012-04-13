package controleurs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeles.ConnexionDB;
import modeles.Record;
import modeles.RecordModele;
import modeles.Track;
import modeles.RechercheTrackViewModele;

public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Recherche() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() throws ServletException {
		@SuppressWarnings("unused")
		ConnexionDB conn = new ConnexionDB();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String srecherche = request.getParameter("recherche");
		String styleRecherche = request.getParameter("menu");
		String filterRecherche = request.getParameter("filter");
		
		if(styleRecherche.equals("Track View") || styleRecherche.equals("--Select a view--")){
			RechercheTrackViewModele rtvm = new RechercheTrackViewModele();
			ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
			
			if(srecherche.equals("") || srecherche.equals("Search music")){
				arrayOfTrack = rtvm.RecupListOfAllTrack();
			}else {
				if(filterRecherche.equals("none")){
					arrayOfTrack = rtvm.RecupListOfTrackByFullText(srecherche);
				} else if(filterRecherche.equals("track")){
					arrayOfTrack = rtvm.RecupListOfTrackByTitleName(srecherche);
				} else if(filterRecherche.equals("artist")){
					arrayOfTrack = rtvm.RecupListOfTrackByPersonName(srecherche);
				} else {
					arrayOfTrack = rtvm.RecupListOfTrackByRecordName(srecherche);
				}
			}
			
			
			
			request.setAttribute("arrayOfTrack", arrayOfTrack);
			request.getRequestDispatcher("rechercheTrackView.jsp").forward(request, response);
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
