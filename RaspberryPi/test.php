<?php
$conn= mysqli_connect("SDI주소", "ID", "PW", "DB명");

if($conn){
    echo "success !";
}
else{
    echo "fail..";
}
?>