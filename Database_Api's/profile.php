<?php

require "connect.php";

$rid = $_POST['rid'];
$query="SELECT * FROM point RIGHT JOIN register ON point.r_id = register.r_id where register.r_id = '$rid'";

$result= mysqli_query($conn,$query);

while($row=mysqli_fetch_assoc($result))
{
	$data[]=$row;
}

print(json_encode($data));

?>