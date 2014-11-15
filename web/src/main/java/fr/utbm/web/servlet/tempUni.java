package fr.utbm.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class tempUni extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(arg0, arg1);
		displayLayout(request, response); PrintWriter out = response.getWriter();
			}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		displayLayout(request, response);
	}
	
	private void displayLayout(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException{
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
            out.println("<h1>Servlet température at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
	}
}
