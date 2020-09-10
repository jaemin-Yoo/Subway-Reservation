<?php
header("Content-Type: text/html; charset=UTF-8");
$conn= new mysqli("localhost", "root", "1234", "subway");
mysqli_query($conn, 'SET NAMES utf8');

$str1= $_POST['str1'];
$hour= $_POST['hour'];
$min= $_POST['min'];

$h = (int)$hour;
$m = (int)$min;

$sql= "SELECT * FROM subwayinfo WHERE station='$str1' AND hour>=$h";
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