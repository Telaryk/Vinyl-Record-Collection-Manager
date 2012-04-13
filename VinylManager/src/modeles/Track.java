package modeles;

import java.util.Date;

public class Track {
	
	private int id;
	private String title;
	private String label;
	private Date playing_time;
	private Date release_date;
	private String style;
	private Record record;
	private Artist artist;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist person) {
		this.artist = person;
	}
	public Date getPlaying_time() {
		return playing_time;
	}
	public void setPlaying_time(Date playingTime) {
		playing_time = playingTime;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date releaseDate) {
		release_date = releaseDate;
	}
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}

}
