
package fr.utbm.web.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.tools.SimulatorService;

/*
 * Servlet d'affichage de la page web tempUni
 */
public class GetTempUni extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// Récupération de la liste des sondes pour la rediriger sur l'affichage
		SimulatorService mySimulatorService = SimulatorService.getInstance();
		List<Sensor> myListSensor = mySimulatorService.getSensorList();
		
	    request.setAttribute("sensorList", myListSensor);
	    request.getRequestDispatcher("/tempUni.jsp").forward(request, response);
	}
}

