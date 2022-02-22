<?php

require ('connect.php');

// $username = "ali";
// $password = "ali123";
// $manager = 1;
// $j_date = "12-09-2020";


$username = $_POST["un"];
$password = $_POST["ps"];
$phone = $_POST["ph"];
$email = $_POST["em"];
$profile_image = $_POST["im"];

$filename = "IMG".rand().".jpeg";
file_put_contents("profiles/".$filename,base64_decode($profile_image));


// $username = "ali";
// $password = "ali123";
// $phone = 3123;
// $address = "adas";
// $email = "adas";
// $type = "dsf";


// $sql = "INSERT INTO register ( uname , email, password , phone , image) VALUES ('$username'  , '$email' ,  '$password', '$phone' , '$filename' )";
$sql = "INSERT INTO register ( uname , email, password , phone, image) VALUES ('$username'  , '$email' ,  '$password', '$phone', '$filename' )";
$result = mysqli_query($conn , $sql) or die ("Regsiter Failed");

if ($result) {
  echo "Registered";
} else {
  echo "Register-Failed";
}
?>