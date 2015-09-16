<?php
    include_once "lingoConnect.php";


       
       $result = mysql_query("SELECT * FROM users") or die('Errant query:');
       
      
$return_arr = Array();
    while($row2 = mysql_fetch_assoc($result)){
       
				 
				 $return_arr[] = $row2;
}

echo json_encode($return_arr);






?>