package fr.utbm.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.core.tools.SimulatorService;
import fr.utbm.core.tools.TempsLogger;

/*
 * Servlet de recéption des valeurs du formulaire
 */
public class PostTempUni extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer sensor = Integer.parseInt(request.getParameter("sonde"));
		Float temperature = Float.parseFloat(request.getParameter("temperature"));
		String _dateTemp = request.getParameter("dateTime");
		
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
			TimeZone tz = TimeZone.getTimeZone("UTC");
			sdf.setTimeZone(tz);
			Date date = sdf.parse(_dateTemp);
			SimulatorService ss = new SimulatorService();
			ss.setTemperature(sensor, temperature, date);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		
		try{
			response.setContentType("text/html;charset=UTF-8");
			out.println("Les données ont bien été envoyées dans la base." );
		}finally{
			out.close();
		}
	}
	
}
