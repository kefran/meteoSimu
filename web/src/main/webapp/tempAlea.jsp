<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simulation Température</title>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
      <div class="container-fluid">
      	<div class="navbar-header">
        	<a class="navbar-brand" href="#">Simulateur</a>
     	</div>
        <div id="navbar" class="navbar-collapse collapse">
        	<ul class="nav navbar-nav">
            	<li><a href="GetTempUni">Simulation unitaire</a></li>
             	<li class="active"><a href="GetTempAlea">Simulation aléatoire</a></li>
           	</ul>
		</div>
      </div>
    </nav>
	
	<div class="container-fluid">
  		<div class="row">
	  		<div class="col-md-8 col-md-offset-2">
				<h1>Simulation de température aleatoire</h1>
					<form class="form-horizontal" method="POST" action="PostTempAlea">
						<div class="well">
							<div class="form-group">
								<label for="sonde" class="col-sm-3" control-label">Choix de la sonde</label>
								<select class="col-sm-8" id="sonde" name="sonde" size="1">
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
							</div>
							<div class="form-group">
								<label for="temperature" class="col-sm-3" control-label">Température minimal</label>
								<input class="col-sm-1" id="temperatureMin" type="text" id="temperatureMin" value="1" name="temperatureMin" />
							</div>
							<div class="form-group">
								<label for="temperature" class="col-sm-3" control-label">Température maximale</label>
								<input class="col-sm-1" id="temperature" type="text" name="temperature" value="1" onkeypress="return isNumberKey(event)"/>
							</div>
							<div class="form-group">
								<label for="temperature" class="col-sm-3" control-label">Température</label>
								<input type="text" id="temperatureMax" value="10" name="temperatureMax">
							</div>
							<div class="form-group">
								<label for="interval" class="col-sm-3" control-label">Intervale</label>
								<select id="interval" name="interval" size="1">
									<option>Seconde</option>
									<option>Minute</option>
									<option>Heure</option>
								</select>
							</div>
						</div>
		<div class="btn-group col-md-2 col-md-offset-10" role="group" >
		<input type="button" value="Start" onClick="start();" class="btn btn-success"/>
		<input type="button" value="stop" onClick="stop();" class="btn btn-danger"/>
		</div>
		
		
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
		var tempMax = parseFloat(document.getElementById("temperatureMax").value);
		var tempMin = parseFloat(document.getElementById("temperatureMin").value);
		var temperature = ((Math.random() * tempMax) + tempMin).toFixed(1);
		$.post("http://localhost:8080/web/PostTempAlea", {
			sonde : sonde,
			temperature : temperature,
		});
	}
</script>
</body>
</html>