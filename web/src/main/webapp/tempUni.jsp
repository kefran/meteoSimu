<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simulation Température</title>
</head>
<body>
	<a href="#">Simulation aléatoire</a>
	<h1>Simulation de température ponctuelle</h1>
	<form method="POST" action="tempuni">
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