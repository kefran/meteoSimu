package fr.utbm.core.tools;


import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.SerializationConfig;

import fr.utbm.core.entity.Temperature;


/*
 *  send the temperature to the WebService
 */
public class TempsLogger {
	
	private HttpClient hClient ;
	private PostMethod hMeth ;
	
	
	public TempsLogger()
	{
		hClient = new HttpClient();
		hMeth = new PostMethod("http://jojo.local:8080/concentrator/collectData"); // TODO 
	}
	
	public boolean logTemperature(Temperature t){
		/* init */
	    TimeZone tz = TimeZone.getTimeZone("UTC");
	    SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");    
	    TemperatureDTO tdto = new TemperatureDTO(t);
		ObjectMapper m = new ObjectMapper();
		ObjectWriter w = m.writer();
		SerializationConfig cfg = m.getSerializationConfig();
		ConcentratorResponse cr ;
		
		
		cfg.setDateFormat(sdf);
		m.setSerializationConfig(cfg);
		sdf.setTimeZone(tz);
		
		try {
			
				StringRequestEntity entity = 
						new StringRequestEntity(m.writeValueAsString(tdto), 
												"application/json",
												"UTF-8");
				hMeth.setRequestEntity(entity);
				System.out.println(entity.getContent());
				hClient.executeMethod(hMeth);		

				String response =hMeth.getResponseBodyAsString();
		System.out.println(response);
		cr  = m.readValue(response, ConcentratorResponse.class);
		System.out.println((cr.isSuccess())?"true":"false");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
