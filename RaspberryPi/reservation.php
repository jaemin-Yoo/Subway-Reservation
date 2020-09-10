<?php
header("Content-Type: text/html; charset=UTF-8");
$conn= new mysqli("localhost", "root", "1234", "subway");
mysqli_query($conn, 'SET NAMES utf8');

$start = $_POST['start'];
$end = $_POST['end'];
$hour = $_POST['hour'];
$min = $_POST['min'];
$station_num = $_POST['station_num'];
$seat_num = $_POST['seat_num'];

$sql = "INSERT INTO reservation(start, end, hour, min, station_num, seat_num) VALUES('$start', '$end', $hour, $min, $station_num, $seat_num)";
$res = $conn->query($sql);


?>