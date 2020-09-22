<?php
header("Content-Type: text/html; charset=UTF-8");
$conn= new mysqli("localhost", "root", "1234", "subway");
mysqli_query($conn, 'SET NAMES utf8');

$str= $_POST['str'];
$end= $_POST['end'];
$hour= $_POST['hour'];
$min= $_POST['min'];

$h = (int)$hour;
$m = (int)$min;

$sql_str= "SELECT station_num FROM subwayinfo WHERE station='$str'";
$res_str= $conn->query($sql_str);

$sql_end= "SELECT station_num FROM subwayinfo WHERE station='$end'";
$res_end= $conn->query($sql_end);

$row_str = mysqli_fetch_array($res_str);
$row_end = mysqli_fetch_array($res_end);

$subway_num = 1;
if($row_str['station_num']>$row_end['station_num']){
    $subway_num = 23;
}

$sql= "SELECT * FROM subwayinfo WHERE station='$str' AND subway_num >= $subway_num AND hour>=$h";
$res= $conn->query($sql);

$response= array();
$response["success"]=false;

$num= 0;
while($row=mysqli_fetch_array($res)){
    if($num==3){
        break;
    }
    $response["number"]=$num;
    $numstr = (string)$num;
    if($h==$row["hour"]){
        if($m<$row["min"]){
            $response["start$numstr"]=$row["station"];
            $response["hour$numstr"]=$row["hour"];
            $response["min$numstr"]=$row["min"];
            $num++;
        }
    }
    else{
        $response["start$numstr"]=$row["station"];
        $response["hour$numstr"]=$row["hour"];
        $response["min$numstr"]=$row["min"];
        $num++;
    }
    $response["success"]=true;
}


echo json_encode($response);
?>