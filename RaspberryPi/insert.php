<?php
header("Content-Type: text/html; charset=UTF-8");
$conn= new mysqli("localhost", "root", "1234", "subway");
mysqli_query($conn, 'SET NAMES utf8');


$station= array("영남대","임당","정평","사월","신매","고산","대공원","연호","담티","만촌","수성구청","범어","대구은행","경대병원","반월당","청라언덕","반고개","내당","두류","감삼","죽전","용산","이곡","성서산업단지","계명대"
,"강창","대실","다사","문양");

$subway_num = 23;
$hour = 6;
$min = 0;
$cnt = 1;

for ($i = 28; $i >= 0; $i--)
{
	while ($hour < 24)
	{
        $sql= "insert into subwayinfo(station_num, subway_num, station, hour, min) values($i, $subway_num, '$station[$i]', '$hour', '$min')";
        $res= $conn->query($sql);
		$min += 50;
		if ($min >= 60)
		{
			$min = $min - 60;
			$hour++;
		}
		$subway_num++;
	}
	$subway_num = 23;
	$hour = 6;
	$min = $cnt*2;
	$cnt++;
}
?>