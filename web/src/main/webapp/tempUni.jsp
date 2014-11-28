<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simulation Température</title>
</head>
<body>
	<a href="GetTempAlea">Simulation aléatoire</a>
	<br>
	
	<h1>Simulation de température unitaire</h1>
	<form method="POST" action="PostTempUni">
		<p>
		<h4>Choix de la sonde</h4>
		
		<select name="sonde" size="1">
		<%@ page import="fr.utbm.core.entity.Sensor, java.util.List" %>
			<%
			 List<Sensor>  mySensorList = (List<Sensor>)request.getAttribute("sensorList");
			 for (Sensor e : mySensorList) {
			 	out.println("<Option Value='" + e.getId() + "'> "+
				 e.getStation().getArea().getLabel() + " > " + e.getStation().getLabel() + " > " + e.getLabel()
				 +"</Option>");
				}	
			%>
		</select>
		</p>
		<p>
			<h4>Données à simuler</h4>
			<span> 
				Température 
				<input type="text" name="temperature" onkeypress="return isNumberKey(event)"/>
			 	<input type="date"	name="date">
				<input type="time" name="time">
			</span>
		</p>
		<input type="Submit" value="Valider"/>
	</form>
</body>
<script>
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : evt.keyCode;
   if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}
</script>
</html>