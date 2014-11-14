package fr.utbm.dao;

import fr.utbm.dao.impl.*;

public abstract class DaoFactory {

	public static AlertDao getAlertDao() {
		return new AlertDao();
	}

	public static AlertHistoryDao getAlertHistoryDao() {
		return new AlertHistoryDao();
	}

	public static AreaDao getAreaDao() {
		return new AreaDao();
	}

	public static SensorDao getSensorDao() {
		return new SensorDao();
	}

	public static StationDao getStationDao() { return new StationDao(); }

	public static TemperatureDao getTemperatureDao() {
		return new TemperatureDao();
	}

	public static TriggerDao getTriggerDao() {
		return new TriggerDao();
	}
}
