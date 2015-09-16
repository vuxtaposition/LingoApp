<?php
    include_once "lingoConnect.php";


$password =  $_POST['password'];
$email =  $_POST['email'];

if(!empty($email) ) { 
  }     
       $result = mysql_query("SELECT * FROM users WHERE email = '$email' AND password='$password'") or die('Errant query:');
       

$rows = mysql_num_rows($result);

if($rows == 0){
	echo "No such user, please try again!";
}else{
		echo "user found";
}