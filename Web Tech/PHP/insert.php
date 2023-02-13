<?php
if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "cw";

    // Create connection
    $conn = new mysqli($servername, $username, $password, $dbname);
    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = "INSERT INTO Item (name, price) 
            VALUES ('Abir', 999999999)";

    if ($conn->query($sql) === TRUE) {
        echo "New record created successfully";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }

    $conn->close();
}

?>