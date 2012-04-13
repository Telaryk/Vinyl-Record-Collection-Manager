package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RechercheTrackViewModele {
	
	private PreparedStatement st = null;
	private ResultSet rs = null;
	
	public ArrayList<Track> RecupListOfTrackByTitleName(String name){
		
		ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
		
		try {
		st = ConnexionDB.Con.prepareStatement("select tr.id, tr.title, tr.label, tr.playing_time, tr.release_date, tr.style, ty.id, ty.name, ar.name, ar.id, re.id, re.name " +
												"from Track tr, Record re, Artist ar, Type ty, TrackInRecord tir " +
												"where tr.title=? " +
												"and ty.id=tr.idtype " +
												"and ar.id=tr.idartist " +
												"and tir.idrecord=re.id " +
												"and tir.idtrack=tr.id");
		st.setString(1, name);
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			Track track = new Track();
			Artist a = new Artist();
			Record r = new Record();
			
			track.setId(rs.getInt("tr.id"));
			track.setTitle(rs.getString("tr.title"));
			track.setLabel(rs.getString("tr.label"));
			track.setPlaying_time(rs.getTime("tr.playing_time"));
			track.setRelease_date(rs.getDate("tr.release_date"));
			track.setStyle(rs.getString("tr.style"));
			
			a.setName(rs.getString("ar.name"));
			a.setId(rs.getInt("ar.id"));
			track.setArtist(a);
			
			r.setId(rs.getInt("re.id"));
			r.setName(rs.getString("re.name"));
			track.setRecord(r);

			arrayOfTrack.add(track);
		}
		
		return arrayOfTrack;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
	
	
	public ArrayList<Track> RecupListOfTrackByFullText(String text){
		
		ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
		
		try {
		st = ConnexionDB.Con.prepareStatement("select tr.id, tr.title, tr.label, tr.playing_time, tr.release_date, tr.style, ty.id, ty.name, ar.name, ar.id, re.id, re.name " +
												"from Track tr, Record re, Artist ar, Type ty, TrackInRecord tir " +
												"where (tr.title=? " +
												"or tr.label=? " +
												"or ty.name=? " +
												"or ar.name=? " +
												"or re.name=?) " +
												"and ty.id=tr.idtype " +
												"and ar.id=tr.idartist " +
												"and tir.idrecord=re.id " +
												"and tir.idtrack=tr.id");
		st.setString(1, text);
		st.setString(2, text);
		st.setString(3, text);
		st.setString(4, text);
		st.setString(5, text);
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			Track track = new Track();
			Artist a = new Artist();
			Record r = new Record();
			
			track.setId(rs.getInt("tr.id"));
			track.setTitle(rs.getString("tr.title"));
			track.setLabel(rs.getString("tr.label"));
			track.setPlaying_time(rs.getTime("tr.playing_time"));
			track.setRelease_date(rs.getDate("tr.release_date"));
			track.setStyle(rs.getString("tr.style"));
			
			a.setName(rs.getString("ar.name"));
			a.setId(rs.getInt("ar.id"));
			track.setArtist(a);
			
			r.setId(rs.getInt("re.id"));
			r.setName(rs.getString("re.name"));
			track.setRecord(r);

			arrayOfTrack.add(track);
		}
		
		return arrayOfTrack;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
	
	public ArrayList<Track> RecupListOfTrackByPersonName(String name){
		
		ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
		
		try {
		st = ConnexionDB.Con.prepareStatement("select tr.id, tr.title, tr.label, tr.playing_time, tr.release_date, tr.style, ty.id, ty.name, ar.name, ar.id, re.id, re.name " +
												"from Track tr, Record re, Artist ar, Type ty, TrackInRecord tir "  +
												"where ar.name=? " +
												"and ty.id=tr.idtype " +
												"and ar.id=tr.idartist " +
												"and tir.idrecord=re.id " +
												"and tir.idtrack=tr.id");
		st.setString(1, name);
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			Track track = new Track();
			Artist a = new Artist();
			Record r = new Record();
			
			track.setId(rs.getInt("tr.id"));
			track.setTitle(rs.getString("tr.title"));
			track.setLabel(rs.getString("tr.label"));
			track.setPlaying_time(rs.getTime("tr.playing_time"));
			track.setRelease_date(rs.getDate("tr.release_date"));
			track.setStyle(rs.getString("tr.style"));
			
			a.setName(rs.getString("ar.name"));
			a.setId(rs.getInt("ar.id"));
			track.setArtist(a);
			
			r.setId(rs.getInt("re.id"));
			r.setName(rs.getString("re.name"));
			track.setRecord(r);

			arrayOfTrack.add(track);
		}
		
		return arrayOfTrack;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
	
	
	public ArrayList<Track> RecupListOfTrackByRecordName(String name){
		
		ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
		
		try {
		st = ConnexionDB.Con.prepareStatement("select tr.id, tr.title, tr.label, tr.playing_time, tr.release_date, tr.style, ty.id, ty.name, ar.name, ar.id, re.id, re.name " +
												"from Track tr, Record re, Artist ar, Type ty, TrackInRecord tir "   +
												"where re.name=? " +
												"and ty.id=tr.idtype " +
												"and ar.id=tr.idartist " +
												"and thp.Person_id=pe.id " +
												"and tir.idrecord=re.id " +
												"and tir.idtrack=tr.id");
		st.setString(1, name);
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			Track track = new Track();
			Artist a = new Artist();
			Record r = new Record();
			
			track.setId(rs.getInt("tr.id"));
			track.setTitle(rs.getString("tr.title"));
			track.setLabel(rs.getString("tr.label"));
			track.setPlaying_time(rs.getTime("tr.playing_time"));
			track.setRelease_date(rs.getDate("tr.release_date"));
			track.setStyle(rs.getString("tr.style"));
			
			a.setName(rs.getString("ar.name"));
			a.setId(rs.getInt("ar.id"));
			track.setArtist(a);
			
			r.setId(rs.getInt("re.id"));
			r.setName(rs.getString("re.name"));
			track.setRecord(r);

			arrayOfTrack.add(track);
		}
		
		return arrayOfTrack;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
	
	
	
public ArrayList<Track> RecupListOfAllTrack(){
		
		ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
		
		try {
		st = ConnexionDB.Con.prepareStatement("select tr.id, tr.title, tr.label, tr.playing_time, tr.release_date, tr.style, ty.id, ty.name, ar.name, ar.id, re.id, re.name " +
												"from Track tr, Record re, Artist ar, Type ty, TrackInRecord tir "   +
												"where ty.id=tr.idtype " +
												"and ar.id=tr.idartist " +
												"and thp.Person_id=pe.id " +
												"and tir.idrecord=re.id " +
												"and tir.idtrack=tr.id");
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			Track track = new Track();
			Artist a = new Artist();
			Record r = new Record();
			
			track.setId(rs.getInt("tr.id"));
			track.setTitle(rs.getString("tr.title"));
			track.setLabel(rs.getString("tr.label"));
			track.setPlaying_time(rs.getTime("tr.playing_time"));
			track.setRelease_date(rs.getDate("tr.release_date"));
			track.setStyle(rs.getString("tr.style"));
			
			a.setName(rs.getString("ar.name"));
			a.setId(rs.getInt("ar.id"));
			track.setArtist(a);
			
			r.setId(rs.getInt("re.id"));
			r.setName(rs.getString("re.name"));
			track.setRecord(r);

			arrayOfTrack.add(track);
		}
		
		return arrayOfTrack;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
	
	
	

}
