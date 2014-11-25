<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/tstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simulation Température</title>
</head>
<body>
	<a href="GetTempAlea">Simulation aléatoire</a>
	<br>
	<%=(String)request.getAttribute("todo")%>
	<h1>Simulation de température unitaire</h1>
	<form method="POST" action="PostTempUni">
		<p>
		<h4>Choix de la sonde</h4>
		<select name="zone" size="1">
			<option>Toto</option>
		</select> <select name="station" size="1">
			<option>Toto</option>
		</select> <select name="sonde" size="1">
			<option>Toto</option>
		</select>
		</p>
		<p>
			<h4>Données à simuler</h4>
			<span> 
				Température 
				<input type="text" name="temperature"/>
			 	<input type="date"	name="date">
				<input type="time" name="time">
			</span>
		</p>
		<input type="Submit" value="Valider"/>
	</form>
</body>
</html>