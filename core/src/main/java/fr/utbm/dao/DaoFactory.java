package fr.utbm.dao;

import fr.utbm.dao.impl.AlertDao;
import fr.utbm.dao.impl.AlerthisDao;
import fr.utbm.dao.impl.AreaDao;
import fr.utbm.dao.impl.SensorDao;
import fr.utbm.dao.impl.TemperatureDao;
import fr.utbm.dao.impl.TriggerDao;

public class DaoFactory {

	public static AlertDao getAlertDao() {
		return new AlertDao();
	}

	public static AlerthisDao getAlerthisDao() {
		return new AlerthisDao();
	}

	public static AreaDao getAreaDao() {
		return new AreaDao();
	}

	public static SensorDao getSensorDao() {
		return new SensorDao();
	}

	public static TemperatureDao getTemperatureDao() {
		return new TemperatureDao();
	}

	public static TriggerDao getTriggerDao() {
		return new TriggerDao();
	}
}
