package fr.utbm.core.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Temperature {

	private int id;
	private Sensor sensor;
	private float value;
	private Date date;

	public Temperature() {
	}

	public Temperature(Sensor sensor, float value, Date date) {
		this.sensor = sensor;
		this.value = value;
		this.date = date;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sensor getSensor() {
		return this.sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}
}
