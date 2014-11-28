package fr.utbm.web.servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.util.Log;

import fr.utbm.core.tools.TempsLogger;

public class PostTempAlea extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Integer sensor = Integer.parseInt(request.getParameter("sonde"));
		Float temperature = Float.parseFloat(request.getParameter("temperature"));

		Date date = new Date(); 
		try{
			TempsLogger tl = new TempsLogger();
			//tl.logTemperature(sensor, temperature, date);
			}
			catch(Exception e){e.printStackTrace();
			
			
			}
		PrintWriter out = response.getWriter();
		try{
		response.setContentType("text/html;charset=UTF-8");
			System.out.println(date +  " temp : " + temperature);
		
		}
		finally
		{
			out.close();
		}
	}
}
