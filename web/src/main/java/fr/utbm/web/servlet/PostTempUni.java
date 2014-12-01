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

import fr.utbm.core.entity.Temperature;
import fr.utbm.core.tools.TempsLogger;

public class PostTempUni extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO ENVOYER CHIER L'UTILISATEUR CAR IL N'A PAS A GET CETTE PAGE!

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer sensor = Integer.parseInt(request.getParameter("sonde"));
		Float temperature = Float.parseFloat(request.getParameter("temperature"));
		String _dateTemp = request.getParameter("dateTime");
		Date date;
	
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		System.out.println(_dateTemp);
		date = sdf.parse(_dateTemp);
		TempsLogger tl = new TempsLogger();
		System.out.println(date);
		tl.logTemperature(sensor, temperature, date);
		}
		catch(Exception e){e.printStackTrace();
		
		
		}
		PrintWriter out = response.getWriter();
		try{
		response.setContentType("text/html;charset=UTF-8");
		

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("Les données ont bien été envoyées dans la base." );
		out.println("</body>");
		out.println("</html>");
		}
		finally
		{
			out.close();
		}
	}
}
