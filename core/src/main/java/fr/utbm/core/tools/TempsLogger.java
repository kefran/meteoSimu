package fr.utbm.core.tools;

import java.io.InputStream;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

/*
 *  send the temperature to the concentrator
 */
public class TempsLogger {


	private MultiThreadedHttpConnectionManager coMan;
	
	private String url;
	
	private TimeZone tz;
	private ObjectMapper mapper;
	private SerializationConfig cfg;
	private HttpClient hClient;
	public TempsLogger() {
		
		url =new String("http://localhost:8080/concentrator/collectData");//default concentrator
			
		coMan = new MultiThreadedHttpConnectionManager();
		mapper = new ObjectMapper();
		hClient = new HttpClient(coMan);
	}

	/*
	 * 
	 */
	public boolean logTemperature(Integer sensorId, Float temperature, Date date) {

		PostMethod hMeth = new PostMethod(url);
		TemperatureDto tdto = new TemperatureDto(sensorId,temperature,date);//Creation du DTO

		try {

			StringRequestEntity entity = new StringRequestEntity(
					mapper.writeValueAsString(tdto), "application/json",
					"UTF-8");
			
			System.out.println("Sent Data : "+mapper.writeValueAsString(tdto));
			
			hMeth.setRequestEntity(entity);

			hClient.executeMethod(hMeth);
			
			InputStream response = hMeth.getResponseBodyAsStream();
		
			tdto = mapper.readValue(response, TemperatureDto.class);
			
			if(!tdto.getSuccess())throw new Exception(tdto.getMessage());
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
			
		}finally{
			
			hMeth.releaseConnection();
		}
		return true;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
