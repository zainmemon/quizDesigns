<?php
 
/*
 * Following code will fetch category
 * All user details are read from HTTP Post Request
 */
 
// array for JSON response
$response = array();
 

 
      // include db connect class
    require_once __DIR__ . '/db_connect.php';
 // connecting to db
    $db = new DB_CONNECT();
    // mysql inserting a new row
    // get a category from categorys table
    $result = mysql_query("SELECT * FROM category")or die(mysql_error());
 
// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // products node
          $response["category"] = array();
 

 
    while ($row = mysql_fetch_array($result)) {
 
            $category = array();
            $category["id"] = $row["id"];
            $category["name"] = $row["name"];
            
        // push single product into final response array

        array_push($response["category"], $category);
    }
 
  // success
    $response["success"] = 1;

   
    // echoing JSON response
   echo json_encode($response);
	
} else {
    // no category found
    $response["success"] = 0;
    $response["message"] = "No category found";
 
    // echo no users JSON
    echo json_encode($response);
}
?>