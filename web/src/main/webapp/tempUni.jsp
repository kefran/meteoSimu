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
		<style>
			.row {
				margin-top: 10px;
		</style>
	</head>
	<body>
		<nav class="navbar navbar-default" role="navigation">
	      <div class="container-fluid">
	      	<div class="navbar-header">
	        	<a class="navbar-brand" href="#">Simulateur</a>
	     	</div>
	        <div id="navbar" class="navbar-collapse collapse">
	        	<ul class="nav navbar-nav">
	            	<li class="active"><a href="GetTempUni">Simulation unitaire</a></li>
	             	<li><a href="GetTempAlea">Simulation aléatoire</a></li>
	           	</ul>
			</div>
	      </div>
	    </nav>
		<div class="container-fluid">
	  		<div class="row">
		  		<div class="col-md-8 col-md-offset-2">
		  			<h1>Simulation de température unitaire</h1>
					<form class="form-horizontal" >
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
								<label for="temperature" class="col-sm-3" control-label">Température</label>
								<input class="col-sm-1" id="temperature" type="text" name="temperature" value="1" onkeypress="return isNumberKey(event)"/>
							</div>
							<div class="form-group">
								<label for="date" class="col-sm-3" control-label">Date et heure</label>
								<input class="col-sm-3"type="datetime-local" id="date" name="date"/>
							</div>
						</div>
						<input type="button" onClick="ajaxPost();" class="btn btn-success col-md-1 col-md-offset-11" value="Valider"/>
					</form>
		  		</div>
	 		</div>
	 		<div class="row">
				<div id="insertSucess" class="hide alert alert-success col-md-8 col-md-offset-2" role="alert">
      				<strong>Simulateur : </strong>La température a bien été enregistrée.
   				</div>
   			</div>
	 		<div class="row">
				<div id="missingFields" class="hide alert alert-danger col-md-8 col-md-offset-2" role="alert">
      				<strong>Simulateur : </strong>Tous les champs ne sont pas renseigné!
   				</div>
   			</div>
		</div>
		<script type="text/javascript">
			function ajaxPost(){
				var sonde = document.getElementById("sonde").value;
				var dateTime = $("#date").val();
				var temperature = parseFloat($("#temperature").val());
				if ((temperature === '') || (isNaN(temperature))  || (dateTime ==='') || (dateTime === null)){
					$('#missingFields').toggleClass('hide');
				 	setTimeout(function(){
				 		  $('#missingFields').toggleClass('hide');
				 	}, 2000);
				}else{
					$.post("http://localhost:8080/web/PostTempUni", {
						sonde : sonde,
						temperature : temperature,
						dateTime : dateTime
					}); 
				 	$('#insertSucess').toggleClass('hide');
				 	$('#temperature').val('');
					$("#date").val('');
					$("#sonde").val('1'); 
				 	setTimeout(function(){
				 		  $('#insertSucess').toggleClass('hide');
					}, 2000);
				}
			}
			
			function isNumberKey(evt){
			   var charCode = (evt.which) ? evt.which : evt.keyCode;
			   if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
			      return false;
			   return true;
			}
		</script>
	</body>
</html>