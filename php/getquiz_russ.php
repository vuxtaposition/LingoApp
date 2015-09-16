<?php
    include_once "lingoConnect.php";


$result = mysql_query("SELECT * FROM question_russ ") or die('Errant query:');
       

$rows = mysql_num_rows($result);

$return_arr = Array();
    while($row2 = mysql_fetch_assoc($result)){
       
				 
				 $return_arr[] = $row2;
}

echo json_encode($return_arr);



?>	