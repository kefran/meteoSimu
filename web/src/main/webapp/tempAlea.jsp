<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simulation Température Aléatoir</title>
</head>
<body>
	<a href="GetTempUni">Simulation unitaire</a>
	<br>
	<h1>Simulation de température aleatoire</h1>
	<form method="POST" action="PostTempAlea">
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
		<h4>Données à simuler</h4>
		<p> 
			Température minimale 
			<input type="text" name="temperatureMin"/>
		</p>
		<p>
			Température maximale
			<input type="text" name="temperatureMax">	 
		</p>
		<p>
		Intervale 
		<select name="interval" size="1">
			<option>Seconde</option>
			<option>Minute</option>
			<option>Heure</option>
		</select>
		</p>
		<input type="button" value="Start"/>
		<input type="button" value="stop"/>
	</form>
</body>
</html>