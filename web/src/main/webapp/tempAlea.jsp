<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<%=(String) request.getAttribute("todo")%>
	<h1>Simulation de température aleatoire</h1>
	<form method="POST" action="PostTempAlea">
		<p>
			<h4>Choix de la sonde</h4>
		<select id="zone" name="zone" size="1">
			<option>Toto</option>
		</select> <select id="station" name="station" size="1">
			<option>Toto</option>
		</select> <select id="sonde" name="sonde" size="1">
			<option>Toto</option>
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
		<select name="interval" size="1">
			<option>Seconde</option>
			<option>Minute</option>
			<option>Heure</option>
		</select>
		</p>
		<input type="button" value="Start" onClick="start();" />
		<input type="button" value="stop" onClick="stop();" />
	</form>
<script type="text/javascript">
	var interval = null;
	var sonde = document.getElementById("sonde").value;
  	var started = false;
  	
	function start() {
		if(started)return;
		interval = setInterval(generate, 2000);
		started=true;
	}
	function stop() {
		window.clearInterval(interval);
		started=false;
	}

	function generate() {
		var today = new Date();
		var date = today.toISOString();
		var tempMax = parseFloat(document.getElementById("temperatureMax").value);
		var tempMin = parseFloat(document.getElementById("temperatureMin").value);
		var temperature = ((Math.random() * tempMax) + tempMin).toFixed(1);
		$.post("http://localhost:8080/web/PostTempAlea", {
			sonde : sonde,
			temperature : temperature,
			date : date
		});
	}
</script>
</body>
</html>