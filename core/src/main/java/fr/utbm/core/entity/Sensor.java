package fr.utbm.core.entity;

import java.util.HashSet;
import java.util.Set;

public class Sensor {
	private int id;
	private Station station;
	private String label;
	private Set<Trigger> triggers = new HashSet<Trigger>(0);
	private Set<Temperature> temperatures = new HashSet<Temperature>(0);

	public Sensor() {
	}

	public Sensor(int id, Station station, String label) {
		this.id = id;
		this.station = station;
		this.label = label;
	}

	public Sensor(int id, Station station, String label,
	              Set<Trigger> triggers, Set<Temperature> temperatures) {
		this.id = id;
		this.station = station;
		this.label = label;
		this.triggers = triggers;
		this.temperatures = temperatures;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<Trigger> getTriggers() {
		return this.triggers;
	}

	public void setTriggers(Set<Trigger> triggers) {
		this.triggers = triggers;
	}

	public Set<Temperature> getTemperatures() {
		return this.temperatures;
	}

	public void setTemperatures(Set<Temperature> temperatures) {
		this.temperatures = temperatures;
	}

	@Override
	public String toString() {
		return getLabel();
	}
}
