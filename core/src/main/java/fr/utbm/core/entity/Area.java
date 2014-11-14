package fr.utbm.core.entity;

import java.util.HashSet;
import java.util.Set;

public class Area {
	private int id;
	private String label;
	private String road;
	private Set<Station> stations = new HashSet<Station>(0);

	public Area() {
	}

	public Area(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public Area(int id, String label, String road,
	            Set<Station> stations) {
		this.id = id;
		this.label = label;
		this.road = road;
		this.stations = stations;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getRoad() {
		return this.road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public Set<Station> getStations() {
		return this.stations;
	}

	public void setStations(Set<Station> stations) {
		this.stations = stations;
	}

	@Override
	public String toString() {
		return getLabel();
	}
}
