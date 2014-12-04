<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<script src="js/jquery-1.11.1.min.js"></script>
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
					<form class="form-horizontal">
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
								<label for="temperature" class="col-sm-3" control-label">Température maximal</label>
								<input type="text" id="temperatureMax" value="10" name="temperatureMax">
							</div>
							<div class="form-group">
								<label for="interval" class="col-sm-3" control-label">Intervale</label>
								<select id="interval" name="interval" size="1">
								<!-- 	<option  value="100">0,1 Seconde /!\</option> 
									<option value="500">0,5 Seconde /!\</option> Crash Test -->
									<option value="1000">1 Seconde</option>
									<option value="2000">2 Seconde</option>
									<option value="5000">5 Seconde</option>
								</select>
							</div>
						</div>
						<div class="btn-group col-md-3 col-md-offset-10" role="group" >
							<input type="button" value="Start" onClick="start();" class="btn btn-success"/>
							<input type="button" value="stop" onClick="stop();" class="btn btn-danger"/>
						</div>
					</form>
					<div class="row">
						<div id="missingFields" class="hide alert alert-danger col-md-8 col-md-offset-2" role="alert">
		      				<strong>Simulateur : </strong>Tous les champs ne sont pas renseigné!
		   				</div>
			   		</div>
					<div class="row">
						<div>
							Nombre de valeurs générées : <span class="label label-info" id="nbGenerated"></span>
						</div>
						<table class="table table-striped " id="generatedTemp">
							<thead><th>Date </th><th>Temperature</th><th>Sonde</th></thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript">
		var interval = null;
		var sonde = document.getElementById("sonde").value;
	  	var started = false;
	  	var nbGenerated =1;
	  	var results = document.getElementById("generatedTemp");
	  	var pNbGenerated = document.getElementById("nbGenerated");
	  	  	
		function start() {
			var tempMax = parseFloat(document.getElementById("temperatureMax").value);
			var tempMin = parseFloat(document.getElementById("temperatureMin").value);
			if ((tempMax === '') || (isNaN(tempMax))  || (tempMin ==='') || (isNaN(tempMin))){
				$('#missingFields').toggleClass('hide');
			 	setTimeout(function(){
			 		  $('#missingFields').toggleClass('hide');
			 	}, 2000);
			}else{
				if(started)return;
			    interval = document.getElementById("interval").value;
				sonde = document.getElementById("sonde").value;
				interval = setInterval(generate, interval);
				started=true;
			}
		}
		
		function stop() {
			window.clearInterval(interval);
			started=false;
		}
	
		function generate() {
			var today = new Date();
			var date = today.toISOString()
			var tempMax = parseFloat(document.getElementById("temperatureMax").value);
			var tempMin = parseFloat(document.getElementById("temperatureMin").value);
			var temperature =  (-tempMin +((Math.random() * (tempMax - tempMin +1)  + tempMin))+tempMin).toFixed(1);
			$.post("http://localhost:8080/web/PostTempAlea", {
				sonde : sonde,
				temperature : temperature,
			});
			addResults(date,temperature,$("#sonde option[value='"+sonde+"']").text());
			nbGenerated+=1;
		}
		
		function addResults(date,temperature,sonde){
			row = results.insertRow(1);
			var cellDate = row.insertCell(0);
			var cellTemp = row.insertCell(1);
			var cellSonde = row.insertCell(2);
			
			cellDate.innerHTML = date;
			cellTemp.innerHTML = temperature;
			cellSonde.innerHTML = sonde;
			
			pNbGenerated.innerHTML = nbGenerated;
			
			if(nbGenerated>10)results.deleteRow(11);
		}
		
	</script>
	</body>
</html>