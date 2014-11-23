package fr.utbm.web.servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.util.Log;

public class tempUni extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(arg0, arg1);
		displayLayout(request, response);

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
		out.println("<title>Servlet Température unitaire</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Données récupérées</h1>");
		out.println(zone + " " + station + " " + sonde + " " + temperature + " " + dateTemp + " " + timeTemp);
		out.println("</body>");
		out.println("</html>");
		}
		finally
		{
			out.close();
		}
	}

	private void displayLayout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			/* TODO output your page here. You may use following sample code. */
			response.setContentType("text/html;charset=UTF-8");

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Température unitaire</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet température at "
					+ request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
}
