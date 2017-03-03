package dk.cit.fyp.domain;

public class Race {
	
	private int raceID;
	private String time;
	private String track;
	private int places;
	private double terms;
	private int runners;
	
	public int getRaceID() {
		return raceID;
	}
	
	public void setRaceID(int raceID) {
		this.raceID = raceID;
	}
	
	public String  getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTrack() {
		return track;
	}
	
	public void setTrack(String track) {
		this.track = track;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	public double getTerms() {
		return terms;
	}

	public void setTerms(double terms) {
		this.terms = terms;
	}

	public int getRunners() {
		return runners;
	}

	public void setRunners(int runners) {
		this.runners = runners;
	}

	@Override
	public String toString() {
		return "Race [raceID=" + raceID + ", time=" + time + ", track=" + track + ", places=" + places + ", terms="
				+ terms + ", runners=" + runners + "]";
	}

}
