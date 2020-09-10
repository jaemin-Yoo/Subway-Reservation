<?php
header("Content-Type: text/html; charset=UTF-8");
$conn= new mysqli("localhost", "root", "1234", "subway");
mysqli_query($conn, 'SET NAMES utf8');

$start = $_POST['start'];
$end = $_POST['end'];
$hour = $_POST['hour'];
$min = $_POST['min'];
$block_num = $_POST['block_num'];
$seat_num = $_POST['seat_num'];

$sql_sel = "SELECT * FROM subwayinfo WHERE station='$start' AND hour=$hour AND min=$min";
$res_sel = $conn->query($sql_sel);

$subway_num = 0;
while($row=mysqli_fetch_array($res_sel)){
    $subway_num = $row['subway_num'];
}

$sql_ins = "INSERT INTO reservation(subway_num, start, end, hour, min, block_num, seat_num) VALUES($subway_num, '$start', '$end', $hour, $min, $block_num, $seat_num)";
$res_ins = $conn->query($sql_ins);

$response = array();
$response['success']=true;

echo json_encode($response);
?>