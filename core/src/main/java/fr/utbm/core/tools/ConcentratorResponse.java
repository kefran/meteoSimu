package fr.utbm.core.tools;

public class ConcentratorResponse {
	
	private boolean success;
	private float temperatureValue;
	private String exceptionMessage;
	
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public float getTemperatureValue() {
		return temperatureValue;
	}
	public void setTemperatureValue(float temperatureValue) {
		this.temperatureValue = temperatureValue;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	


}
