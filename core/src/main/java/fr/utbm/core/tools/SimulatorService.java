package fr.utbm.core.tools;

import java.util.List;

import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.dao.DaoFactory;
import fr.utbm.dao.impl.AreaDao;
import fr.utbm.dao.impl.SensorDao;
import fr.utbm.dao.impl.StationDao;

/*
 * Service Layer to provide data for simulation
 * 
 */
public class SimulatorService {
	
	private SensorDao sensorDao;
	private StationDao stationDao;
	private AreaDao areaDao;

	public SimulatorService() {
		sensorDao = DaoFactory.getSensorDao();
		stationDao = DaoFactory.getStationDao();
		areaDao = DaoFactory.getAreaDao();
	}
	
	public List<Sensor> getSensorList(){
		return sensorDao.getAll();
	}
	
	public Sensor getSensor(int id){
		return sensorDao.findById(id);
	}
	
	public Station getStation(int id){
		return stationDao.findById(id);
	}
	
	public Area getArea(int id){
		return areaDao.findById(id);
	}
	
	public List<Area> getAreaList(){
		return areaDao.getAll();
	}
	
	
	
	

	
	
	

}
