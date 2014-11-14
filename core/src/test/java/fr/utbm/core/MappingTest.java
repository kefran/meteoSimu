package fr.utbm.core;

import fr.utbm.core.entity.*;
import fr.utbm.dao.DaoFactory;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;

/**
 * Test des mappings Hibernate.
 */
public class MappingTest {
	@Test
	public void testAlertMapping() {
		Alert alert = new Alert();
		alert.setCode("B001");
		alert.setLabel("Alerte test");
		alert.setDescription("Description");

		DaoFactory.getAlertDao().persist(alert);

		// On lit l'élément
		Alert readAlert = DaoFactory.getAlertDao().findById("B001");
		Assert.assertThat("L'alerte insérée a un code", readAlert.getCode(), is("B001"));
		Assert.assertThat("L'alerte insérée a un label", readAlert.getLabel(), is("Alerte test"));
		Assert.assertThat("L'alerte insérée a une description", readAlert.getDescription(), is("Description"));
	}

	@Test
	public void testAlertHistoryMapping() {
		AlertHistory alertHistory = new AlertHistory();
		alertHistory.setId(15);
		alertHistory.setTrigger(getTrigger());
		alertHistory.setDate(getDate());
		alertHistory.setState(true);

		DaoFactory.getAlertHistoryDao().persist(alertHistory);

		// On lit l'élément
		AlertHistory readAlertHistory = DaoFactory.getAlertHistoryDao().findById(alertHistory.getId());
		Assert.assertThat("L'AlertHistory inséré a un identifiant", readAlertHistory.getId(), is(15));
		Assert.assertThat("L'AlertHistory inséré a un trigger", readAlertHistory.getTrigger(), is(getTrigger()));
		Assert.assertThat("L'AlertHistory inséré a une date", readAlertHistory.getDate(), is(getDate()));
		Assert.assertThat("L'AlertHistory inséré a un état", readAlertHistory.getState(), is(true));
	}

	@Test
	public void testAreaMapping() {
		Area area = new Area();
		area.setId(3);
		area.setLabel("Zone 1");
		area.setRoad("Route A");
		area.setStations(getStationsSet());

		DaoFactory.getAreaDao().persist(area);

		// On lit l'élément
		Area readArea = DaoFactory.getAreaDao().findById(area.getId());
		Assert.assertThat("La zone insérée a un identifiant", readArea.getId(), is(3));
		Assert.assertThat("La zone insérée a un label", readArea.getLabel(), is("Zone 1"));
		Assert.assertThat("La zone insérée a une route", readArea.getRoad(), is("Route A"));
		Assert.assertThat("La zone insérée a des stations", readArea.getStations(), is(getStationsSet()));
	}

	@Test
	public void testSensorMapping() {
		Sensor sensor = new Sensor();
		sensor.setId(7);
		sensor.setLabel("Thermomètre A");
		sensor.setStation(getStation());
		sensor.setTemperatures(getTemperaturesSet());
		sensor.setTriggers(getTriggersSet());

		DaoFactory.getSensorDao().persist(sensor);

		// On lit l'élément
		Sensor readSensor = DaoFactory.getSensorDao().findById(sensor.getId());
		Assert.assertThat("Le thermomètre inséré a un identifiant", readSensor.getId(), is(7));
		Assert.assertThat("Le thermomètre inséré a un libellé", readSensor.getLabel(), is("Thermomètre A"));
		Assert.assertThat("Le thermomètre inséré a une station", readSensor.getStation(), is(getStation()));
		Assert.assertThat("Le thermomètre inséré a des températures", readSensor.getTemperatures(), is(getTemperaturesSet()));
		Assert.assertThat("Le thermomètre inséré a des triggers", readSensor.getTriggers(), is(getTriggersSet()));
	}

	@Test
	public void testStationMapping() {
		Station station = new Station();
		station.setId(4);
		station.setLabel("Station B");
		station.setArea(getArea());
		station.setLastCommunicationDate(getDate());
		station.setSensors(getSensorsSet());
		station.setValid(true);

		DaoFactory.getStationDao().persist(station);

		Station readStation = DaoFactory.getStationDao().findById(station.getId());
		Assert.assertThat("La station insérée a un identifiant", readStation.getId(), is(4));
		Assert.assertThat("La station insérée a un libellé", readStation.getLabel(), is("Station B"));
		Assert.assertThat("La station insérée a une zone", readStation.getArea(), is(getArea()));
		Assert.assertThat("La station insérée a une date", readStation.getLastCommunicationDate(), is(getDate()));
		Assert.assertThat("La station insérée a des thermomètres", readStation.getSensors(), is(getSensorsSet()));
		Assert.assertThat("La station insérée a une validité", readStation.isValid(), is(true));
	}

	@Test
	public void testTemperatureMapping() {
		Temperature temperature = new Temperature();
		temperature.setId(31);
		temperature.setDate(getDate());
		temperature.setSensor(getSensor());
		temperature.setValue(45.6f);

		DaoFactory.getTemperatureDao().persist(temperature);

		Temperature readTemperature = DaoFactory.getTemperatureDao().findById(temperature.getId());
		Assert.assertThat("La température insérée a un identifiant", readTemperature.getId(), is(31));
		Assert.assertThat("La température insérée a une date", readTemperature.getDate(), is(getDate()));
		Assert.assertThat("La température insérée a un thermomètre", readTemperature.getSensor(), is(getSensor()));
		Assert.assertThat("La température insérée a une valeur", readTemperature.getValue(), is(45.6f));
	}

	@Test
	public void testTriggerMapping() {
		Trigger trigger = new Trigger();
		trigger.setId(4);
		trigger.setAlert(getAlert());
		trigger.setAlertHistories(getAlertHistoriesSet());
		trigger.setEdge(true);
		trigger.setHighValue(17.4f);
		trigger.setLowValue(11.3f);
		trigger.setSensor(getSensor());

		DaoFactory.getTriggerDao().persist(trigger);

		Trigger readTrigger = DaoFactory.getTriggerDao().findById(trigger.getId());
		Assert.assertThat("Le trigger inséré a un identifiant", readTrigger.getId(), is(4));
		Assert.assertThat("Le trigger inséré a une alerte", readTrigger.getAlert(), is(getAlert()));
		Assert.assertThat("Le trigger inséré a des historiques", readTrigger.getAlertHistories(), is(getAlertHistoriesSet()));
		Assert.assertThat("Le trigger inséré a un edge", readTrigger.isEdge(), is(true));
		Assert.assertThat("Le trigger inséré a une valeur maxi", readTrigger.getHighValue(), is(17.4f));
		Assert.assertThat("Le trigger inséré a une valeur mini", readTrigger.getLowValue(), is(11.3f));
		Assert.assertThat("Le trigger inséré a un thermomètre", readTrigger.getSensor(), is(getSensor()));
	}

	private Sensor getSensor() {
		return DaoFactory.getSensorDao().findById(1);
	}

	private Trigger getTrigger() {
		return DaoFactory.getTriggerDao().findById(1);
	}

	private Station getStation() {
		return DaoFactory.getStationDao().findById(1);
	}

	private Area getArea() {
		return DaoFactory.getAreaDao().findById(1);
	}

	private Alert getAlert() {
		return DaoFactory.getAlertDao().findById("A001");
	}

	private Date getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse("2014-02-17 14:11:03");
		} catch (ParseException ignored) {
			Assert.fail("Date invalide");
			return new Date();
		}
	}

	private Set<Station> getStationsSet() {
		return new HashSet<>(DaoFactory.getStationDao().getAll());
	}

	private Set<Temperature> getTemperaturesSet() {
		return new HashSet<>(DaoFactory.getTemperatureDao().getAll());
	}

	private Set<Trigger> getTriggersSet() {
		return new HashSet<>(DaoFactory.getTriggerDao().getAll());
	}

	private Set<Sensor> getSensorsSet() {
		return new HashSet<>(DaoFactory.getSensorDao().getAll());
	}

	private Set<AlertHistory> getAlertHistoriesSet() {
		return new HashSet<>(DaoFactory.getAlertHistoryDao().getAll());
	}
}
