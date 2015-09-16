<?php
    include_once "lingoConnect.php";


$password =  $_POST['password'];
$email =  $_POST['email'];

     
       $result = mysql_query("SELECT * FROM users WHERE email = '$email' AND password='$password'") or die('Errant query:');
       

//$rows = mysql_num_rows($result);

$return_arr = Array();
    while($row2 = mysql_fetch_assoc($result)){
       
				 
				 $return_arr[] = $row2;
}

echo json_encode($return_arr);









?>	