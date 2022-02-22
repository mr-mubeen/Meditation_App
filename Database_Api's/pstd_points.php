<?php

require ('connect.php');


$points = $_POST["p"];
$rid = $_POST["rid"];

$rrid = (int)$rid;

$sql = "INSERT INTO point ( pstd_points, r_id) VALUES ('$points' , '$rrid')";
$result = mysqli_query($conn , $sql) or die ("Regsiter Failed");

if ($result) {
  echo "Registered";
} else {
  echo "Register-Failed";
}
?>