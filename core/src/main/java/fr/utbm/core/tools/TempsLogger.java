package fr.utbm.core.tools;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import fr.utbm.core.entity.Temperature;

/*
 *  send the temperature to the concentrator
 */
public class TempsLogger {

	private HttpClient hClient;
	private PostMethod hMeth;
	
	private String url;
	
	private TimeZone tz;
	private ObjectMapper mapper;
	private SerializationConfig cfg;

	public TempsLogger() {
		
		url =new String("http://locahost:8080/concentrator/collectData");//default concentrator
		
		hClient = new HttpClient();

		hMeth = new PostMethod(url); 

		mapper = new ObjectMapper();
		cfg = mapper.getSerializationConfig();
	
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

	}

	//
	public boolean logTemperature(Integer sensorId, Float temperature, Date date) {

		TemperatureDto tdto = new TemperatureDto(sensorId,temperature,date);

		try {

			StringRequestEntity entity = new StringRequestEntity(
					mapper.writeValueAsString(tdto), "application/json",
					"UTF-8");
			
			System.out.println("Sended Data : "+mapper.writeValueAsString(tdto));
			
			hMeth.setRequestEntity(entity);

			hClient.executeMethod(hMeth);
			
			InputStream response = hMeth.getResponseBodyAsStream();
		
			tdto = mapper.readValue(response, TemperatureDto.class);
			
			if(!tdto.getSuccess())throw new Exception(tdto.getMessage());
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
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
