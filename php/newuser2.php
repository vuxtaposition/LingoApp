<?php
    include_once "lingoConnect.php";


$progress = $_POST['countVariable'];
$email = $_POST['email'];


mysql_query("UPDATE users SET progress = $progress WHERE email = '$email' ")or die('did not enter any rocords '.mysql_error());	



     
    






?>
