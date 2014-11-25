package fr.utbm.core.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.utbm.core.entity.Temperature;

public class TemperatureDTO {

	private int sensorId;
	private float temperature;
	private Date date;
	
	public TemperatureDTO(Temperature t){
		sensorId=t.getSensor().getId();
		temperature=t.getValue();
		date = t.getDate();
		
	}
	

	public int getSensorId() {
		return sensorId;
	}


	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}


	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
