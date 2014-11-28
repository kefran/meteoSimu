

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simulation Température Aléatoire</title>
</head>
<body>
	<a href="GetTempUni">Simulation unitaire</a>
	<br>
	<h1>Simulation de température aleatoire</h1>
	<form method="POST" action="PostTempAlea">
		<p>
			<h4>Choix de la sonde</h4>
		<select id="sonde" name="sonde" size="1">
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
		<h4>Données à simuler</h4>
		<p> 
			Température minimale 
			<input type="text" id="temperatureMin" value="1"
				name="temperatureMin" />
		</p>
		<p>
			Température maximale
			<input type="text" id="temperatureMax" value="10"
				name="temperatureMax">	 
		</p>
		<p>
		Intervale 
		<select id="interval" name="interval" size="1">
		<option  value="100">0,1 Seconde /!\</option>
			<option value="500">0,5 Seconde</option>
			<option value="1000">1 Seconde</option>
			<option value="2000">2 Seconde</option>
			<option value="5000">5 Seconde</option>
		</select>
		</p>
		<input type="button" value="Start" onClick="start();" />
		<input type="button" value="stop" onClick="stop();" />
		
	</form>
	<p id="nbGenerated"></p>
	<table id="generatedTemp">
	<thead><th>date</th><th>Temperature</th><th>Sonde</th></thead>
	
	</table>
<script type="text/javascript">
	var interval = null;
	var sonde = document.getElementById("sonde").value;
  	var started = false;
  	var nbGenerated =0;
  	var results = document.getElementById("generatedTemp");
  	var pNbGenerated = document.getElementById("nbGenerated");
  	
  	
	function start() {
		if(started)return;
	    interval = document.getElementById("interval").value;
		sonde = document.getElementById("sonde").value;
		interval = setInterval(generate, interval);
		started=true;
	}
	function stop() {
		window.clearInterval(interval);
		started=false;
	}

	function generate() {
		var today = new Date();
		var date = today.toLocaleString();
		var tempMax = parseFloat(document.getElementById("temperatureMax").value);
		var tempMin = parseFloat(document.getElementById("temperatureMin").value);
		var temperature = ((Math.random() * tempMax) + tempMin).toFixed(1);
		$.post("http://localhost:8080/web/PostTempAlea", {
			sonde : sonde,
			temperature : temperature,
		});
		addResults(date,temperature,sonde);
		nbGenerated+=1;
	}
	
	
	function addResults(date,temperature,sonde)
	{
		row = results.insertRow(1);
		var cellDate = row.insertCell(0);
		var cellTemp = row.insertCell(1);
		var cellSonde = row.insertCell(2);
		
		cellDate.innerHTML = date;
		cellTemp.innerHTML = temperature;
		cellSonde.innerHTML = sonde;
		
		pNbGenerated.innerHTML = nbGenerated;
		
	}
	
</script>
</body>
</html>