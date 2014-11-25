package fr.utbm.web.servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.util.Log;

public class PostTempAlea extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO ENVOYER CHIER L'UTILISATEUR CAR IL N'A PAS A GET CETTE PAGE!

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String zone = request.getParameter("zone");
		String station = request.getParameter("station");
		String sonde = request.getParameter("sonde");
		String temperature = request.getParameter("temperature");
		String dateTemp = request.getParameter("date");
		String timeTemp = request.getParameter("time");
		PrintWriter out = response.getWriter();
		try{
		response.setContentType("text/html;charset=UTF-8");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println(zone + " " + station + " " + sonde + " " + temperature + " " + dateTemp + " " + timeTemp);
		out.println("</body>");
		out.println("</html>");
		}
		finally
		{
			out.close();
		}
	}
}
