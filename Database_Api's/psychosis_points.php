<?php

require ('connect.php');


$points = $_POST["p"];
$rid = $_POST["rid"];

$rrid = (int)$rid;

$sql = "UPDATE point set anxiety_points = '$points' , r_id = '$rrid' where r_id = '$rrid'";
$result = mysqli_query($conn , $sql) or die ("Regsiter Failed");

if ($result) {
  echo "Registered";
} else {
  echo "Register-Failed";
}
?>