package fr.utbm.core.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Station {
	private int id;
	private Area area;
	private String label;
	private Date lastCommunicationDate;
	private boolean valid;
	private Set<Sensor> sensors = new HashSet<Sensor>(0);

	public Station() {
	}

	public Station(int id, Area area, String label, boolean valid) {
		this.id = id;
		this.area = area;
		this.label = label;
		this.valid = valid;
	}

	public Station(int id, Area area, String label, Date lastCommunicationDate,
	               boolean valid, Set<Sensor> sensors) {
		this.id = id;
		this.area = area;
		this.label = label;
		this.lastCommunicationDate = lastCommunicationDate;
		this.valid = valid;
		this.sensors = sensors;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getLastCommunicationDate() {
		return this.lastCommunicationDate;
	}

	public void setLastCommunicationDate(Date lastCommunicationDate) {
		this.lastCommunicationDate = lastCommunicationDate;
	}

	public boolean isValid() {
		return this.valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Set<Sensor> getSensors() {
		return this.sensors;
	}

	public void setSensors(Set<Sensor> sensors) {
		this.sensors = sensors;
	}

	@Override
	public String toString() {
		return getLabel();
	}
}
