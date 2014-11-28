
package fr.utbm.web.servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.util.Log;

import fr.utbm.core.entity.Sensor;
import fr.utbm.dao.DaoFactory;
import fr.utbm.dao.impl.SensorDao;

public class GetTempUni extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//GET DATA ET PASSER EN SETATTRIBUTE? 
		
		SensorDao mySensorDao = DaoFactory.getSensorDao();
		
		List<Sensor> myListSensor = mySensorDao.getAll();
		

	    request.setAttribute("sensorList", myListSensor);
	    request.getRequestDispatcher("/tempUni.jsp").forward(request, response);
	}


}

