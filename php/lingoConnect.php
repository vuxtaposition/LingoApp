<?php 
// creating a connect page to make it easier to change host
$db_host = "mysql10.000webhost.com";

$db_username = "a2262307_fran"; 

$db_pass = "floyd1992";

$db_name = "a2262307_lingo";

mysql_connect("$db_host","$db_username","$db_pass") or die('you have a problem connection '.mysql_error());

//slecting which database to use
mysql_select_db("$db_name") or die("no database by that name".msql_error());


?>