package fr.utbm.core.entity;

import java.util.HashSet;
import java.util.Set;

public class Trigger {
	private int id;
	private Alert alert;
	private Sensor sensor;
	private float highValue;
	private float lowValue;
	private boolean edge;
	private Set<AlertHistory> alertHistories = new HashSet<AlertHistory>(0);

	public Trigger() {
	}

	public Trigger(int id, Alert alert, Sensor sensor, float highValue,
	               float lowValue, boolean edge) {
		this.id = id;
		this.alert = alert;
		this.sensor = sensor;
		this.highValue = highValue;
		this.lowValue = lowValue;
		this.edge = edge;
	}

	public Trigger(int id, Alert alert, Sensor sensor, float highValue,
	               float lowValue, boolean edge, Set<AlertHistory> alertHistories) {
		this.id = id;
		this.alert = alert;
		this.sensor = sensor;
		this.highValue = highValue;
		this.lowValue = lowValue;
		this.edge = edge;
		this.alertHistories = alertHistories;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Alert getAlert() {
		return this.alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	public Sensor getSensor() {
		return this.sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public float getHighValue() {
		return this.highValue;
	}

	public void setHighValue(float highValue) {
		this.highValue = highValue;
	}

	public float getLowValue() {
		return this.lowValue;
	}

	public void setLowValue(float lowValue) {
		this.lowValue = lowValue;
	}

	public boolean isEdge() {
		return this.edge;
	}

	public void setEdge(boolean edge) {
		this.edge = edge;
	}

	public Set<AlertHistory> getAlertHistories() {
		return this.alertHistories;
	}

	public void setAlertHistories(Set<AlertHistory> alertHistories) {
		this.alertHistories = alertHistories;
	}

	@Override
	public String toString() {
		return getLowValue() + ", " + getHighValue();
	}
}
