package fr.utbm.core.entity;// default package
// Generated 31 oct. 2014 13:51:02 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Area generated by hbm2java
 */
public class Area implements java.io.Serializable {

	private int areId;
	private String areLabel;
	private String areRoad;
	private Set<Station> stations = new HashSet<Station>(0);

	public Area() {
	}

	public Area(int areId, String areLabel) {
		this.areId = areId;
		this.areLabel = areLabel;
	}

	public Area(int areId, String areLabel, String areRoad,
			Set<Station> stations) {
		this.areId = areId;
		this.areLabel = areLabel;
		this.areRoad = areRoad;
		this.stations = stations;
	}

	public int getAreId() {
		return this.areId;
	}

	public void setAreId(int areId) {
		this.areId = areId;
	}

	public String getAreLabel() {
		return this.areLabel;
	}

	public void setAreLabel(String areLabel) {
		this.areLabel = areLabel;
	}

	public String getAreRoad() {
		return this.areRoad;
	}

	public void setAreRoad(String areRoad) {
		this.areRoad = areRoad;
	}

	public Set<Station> getStations() {
		return this.stations;
	}

	public void setStations(Set<Station> stations) {
		this.stations = stations;
	}

}
