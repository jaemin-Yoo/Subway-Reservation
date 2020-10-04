<?php
header("Content-Type: text/html; charset=UTF-8");
$conn = new mysqli("localhost", "root", "1234", "subway");
mysqli_query($conn, 'SET NAMES utf8');

$start = $_POST['start'];
$end = $_POST['end'];
$hour = $_POST['hour'];
$min = $_POST['min'];
$block_num = $_POST['block_num'];

$response = array();
$response['success'] = false;
$response['seat_num'] = 0;

$sql_ist = "SELECT station_num FROM subwayinfo WHERE station='$start' LIMIT 1";
$res_ist = $conn->query($sql_ist);
$row_ist=mysqli_fetch_array($res_ist);
$sql_ied = "SELECT station_num FROM subwayinfo WHERE station='$end' LIMIT 1";
$res_ied = $conn->query($sql_ied);
$row_ied=mysqli_fetch_array($res_ied);

//Gain subway_num
$sql_sub = "SELECT subway_num FROM subwayinfo WHERE station='$start' AND hour=$hour AND min=$min";
$res_sub = $conn->query($sql_sub);
$row_sub = mysqli_fetch_array($res_sub);
$subway_num = $row_sub['subway_num'];

//
$sql_res = "SELECT * FROM reservation WHERE subway_num=$subway_num";
$sql_res2 = "SELECT * FROM reservation WHERE subway_num=$subway_num";
$res_res = $conn->query($sql_res);
$res_res2 = $conn->query($sql_res2);


$cnt = 0;
if(mysqli_fetch_row($res_res)==NULL){
    $response['success'] = false;
}
else{
    while($row=mysqli_fetch_array($res_res2))
    {
        if($subway_num < 23){
            $r_str = $row['start'];
            $r_end = $row['end'];
            $sql_str = "SELECT station_num FROM subwayinfo WHERE station = '$r_str' LIMIT 1";
            $res_str = $conn->query($sql_str);
            $row_str=mysqli_fetch_array($res_str);
            $sql_end = "SELECT station_num FROM subwayinfo WHERE station = '$r_end' LIMIT 1";
            $res_end = $conn->query($sql_end);
            $row_end=mysqli_fetch_array($res_end);
            
            if($row_ied>$row_str && $row_end>$row_ist && $row['block_num'] == $block_num){
                $seat_num = $row['seat_num'];
                $cnt++;
                $response['success'] = true;
            }
            else{
                $response['success'] = false;
            }
        }

        elseif($subway_num >= 23){
            $r_str = $row['start'];
            $r_end = $row['end'];
            $sql_str = "SELECT station_num FROM subwayinfo WHERE station = '$r_str' LIMIT 1";
            $res_str = $conn->query($sql_str);
            $row_str=mysqli_fetch_array($res_str);
            $sql_end = "SELECT station_num FROM subwayinfo WHERE station = '$r_end' LIMIT 1";
            $res_end = $conn->query($sql_end);
            $row_end=mysqli_fetch_array($res_end);
            
            if($row_ied<$row_str && $row_end<$row_ist && $row['block_num'] == $block_num){
                $seat_num = $row['seat_num'];
                $cnt++;
                $response['success'] = true;
            break;
            }
            else{
                $response['success'] = false;
            }
        }

        else{
            $response['success'] = false;
        }
    }
}

if($response['success']==true && $cnt==1){
    $response['seat_num'] = $seat_num;
}

$response['cnt'] = $cnt;

echo json_encode($response);

?>