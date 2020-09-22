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

$sql_ist = "SELECT station_num FROM subwayinfo WHERE station='$start' LIMIT 1";
$res_ist = $conn->query($sql_ist);
$row_ist=mysqli_fetch_array($res_ist);
$sql_ied = "SELECT station_num FROM subwayinfo WHERE station='$end' LIMIT 1";
$res_ied = $conn->query($sql_ied);
$row_ied=mysqli_fetch_array($res_ied);

$sql_sel = "SELECT subway_num FROM subwayinfo WHERE station='$start' AND hour=$hour AND min=$min";
$res_sel = $conn->query($sql_sel);

$response = array();

$subway_num = 0;
while($row0=mysqli_fetch_array($res_sel)){
    $subway_num = $row0['subway_num'];
}

$sql_sel2 = "SELECT * FROM reservation";
$sql_sel3 = "SELECT * FROM reservation";
$res_sel2 = $conn->query($sql_sel2);
$res_sel3 = $conn->query($sql_sel3);

if(mysqli_fetch_row($res_sel2)==NULL){
    $response['success'] = true;
}
else{
    while($row=mysqli_fetch_array($res_sel3))
    {
        if($row['subway_num']==$subway_num && $subway_num < 23){
            $r_str = $row['start'];
            $r_end = $row['end'];
            $sql_str = "SELECT station_num FROM subwayinfo WHERE station = '$r_str' LIMIT 1";
            $res_str = $conn->query($sql_str);
            $row_str=mysqli_fetch_array($res_str);
            $sql_end = "SELECT station_num FROM subwayinfo WHERE station = '$r_end' LIMIT 1";
            $res_end = $conn->query($sql_end);
            $row_end=mysqli_fetch_array($res_end);
            
            if($row_ied>$row_str && $row_end>$row_ist && $row['block_num'] == $block_num && $row['seat_num'] == $seat_num){
                $response['success'] = false;
            break;
            }
            else{
                $response['success'] = true;
            }
        }

        elseif($row['subway_num']==$subway_num && $subway_num >= 23){
            $r_str = $row['start'];
            $r_end = $row['end'];
            $sql_str = "SELECT station_num FROM subwayinfo WHERE station = '$r_str' LIMIT 1";
            $res_str = $conn->query($sql_str);
            $row_str=mysqli_fetch_array($res_str);
            $sql_end = "SELECT station_num FROM subwayinfo WHERE station = '$r_end' LIMIT 1";
            $res_end = $conn->query($sql_end);
            $row_end=mysqli_fetch_array($res_end);
            
            if($row_ied<$row_str && $row_end<$row_ist && $row['block_num'] == $block_num && $row['seat_num'] == $seat_num){
                $response['success'] = false;
            break;
            }
            else{
                $response['success'] = true;
            }
        }

        else{
            $response['success'] = true;
        }
    }
}

if($response['success']==true){
    $sql_ins = "INSERT INTO reservation(subway_num, start_id, end_id, start, end, hour, min, block_num, seat_num) VALUES($subway_num, $row_ist[0], $row_ied[0], '$start', '$end', $hour, $min, $block_num, $seat_num)";
    $res_ins = $conn->query($sql_ins);
    $response['success'] = true;
}

echo json_encode($response);
?>