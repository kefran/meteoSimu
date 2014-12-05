
package fr.utbm.core.tools;
 
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import fr.utbm.core.entity.Temperature;

import java.util.Date;
 
/**
 * Objet de transfert de données pour la température.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemperatureDto {
	/**
	 * L'identifiant du capteur qui a relevé la température.
	 */
	protected Integer sensorId;
 
	/**
	 * La température relevée, en degrés Celsius.
	 */
	protected Float temperature;
 
	/**
	 * La date du relevé.
	 */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssZ", timezone="UTC")
	protected Date date;
 
	/**
	 * Le statut du succès de la procédure d'insertion.
	 */
	protected Boolean success;
 
	/**
	 * L'éventuel message d'erreur retourné par la procédure d'insertion.
	 */
	protected String message;
 
	/**
	 * Constructeur par défaut.
	 */
	public TemperatureDto() {
	}
	
	public TemperatureDto(Temperature t){
		setDate(t.getDate());
		setSensorId(t.getSensor().getId());
		setTemperature(t.getValue());
	}
 
	/**
	 * Constructeur d'entrée.
	 * @param sensorId L'identifiant du capteur qui a relevé la température.
	 * @param temperature La température relevée, en degrés Celsius.
	 * @param date La date du relevé.
	 */
	public TemperatureDto(Integer sensorId, Float temperature, Date date) {
		setSensorId(sensorId);
		setTemperature(temperature);
		setDate(date);
	}
 
	/**
	 * Constructeur de sortie.
	 * @param success Le statut du succès de la procédure d'insertion.
	 * @param message L'éventuel message d'erreur retourné par la procédure d'insertion.
	 */
	public TemperatureDto(Boolean success, String message) {
		setSuccess(success);
		setMessage(message);
	}
 
	public Integer getSensorId() {
		return sensorId;
	}
 
	public void setSensorId(Integer sensorId) {
		this.sensorId = sensorId;
	}
 
	public Float getTemperature() {
		return temperature;
	}
 
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
 
	public Date getDate() {
		return date;
	}
 
	public void setDate(Date date) {
		this.date = date;
	}
 
	public Boolean getSuccess() {
		return success;
	}
 
	public void setSuccess(Boolean success) {
		this.success = success;
	}
 
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}
}

