
package fr.utbm.web.servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.util.Log;

public class GetTempUni extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    request.setAttribute("todo", "10");
	    request.getRequestDispatcher("/tempUni.jsp").forward(request, response);
	}


}

