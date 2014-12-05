package fr.utbm.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.utbm.core.tools.SimulatorService;
import fr.utbm.core.tools.TemperatureDto;
import fr.utbm.core.tools.TempsLogger;

public class SimuTest {

	@Test
	public void testSerialization() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd kk:mm:ss");
		
		Integer idSensor=1;
		Float temperature= (float)10.0;
		TimeZone tz = TimeZone.getTimeZone("UTC+1");
		sdf.setTimeZone(tz);
		Date date = sdf.parse("2010-1-1 01:01:01");
		
		TemperatureDto tdto = new TemperatureDto(idSensor,temperature,date);
		ObjectMapper om = new ObjectMapper();
		
		String goodRes = "{\"sensorId\":1,\"temperature\":10.0,\"date\":\"2010-01-04T01:01:01+0000\"}";		
		
		String res = om.writeValueAsString(tdto);
		
		assertEquals(goodRes, res);
	}
	@Test
	public void testService()
	{
		
		SimulatorService ss = SimulatorService.getInstance();
		System.out.println("Attendu : "+ss.toString()+" Obtenu : "+SimulatorService.getInstance());
		assertEquals(ss,SimulatorService.getInstance());
	
	}
	
}
