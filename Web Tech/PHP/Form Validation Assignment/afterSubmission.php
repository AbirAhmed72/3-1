<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Form Confirmation</title>
  <style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
    }

    .container {
        max-width: 800px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        border-radius: 10px;
    }

    h1 {
        font-size: 32px;
        margin-top: 0;
    }

    img {
        max-width: 100%;
        margin-bottom: 20px;
    }

    dl {
        display: grid;
        grid-template-columns: repeat(2, 1fr);
        grid-gap: 20px;
        margin: 0;
    }

    dt {
        font-weight: bold;
    }

    @media (max-width: 768px) {
        .container {
            padding: 10px;
            border-radius: 0;
        }

        h1 {
            font-size: 24px;
        }

        dl {
            grid-template-columns: 1fr;
        }
    }
  </style>
</head>
<body>
  <div class="container">
    <!-- <h1>Form Confirmation</h1> -->

    <?php

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

        $sql = "INSERT INTO Form (Fname, Lname, Email, Address) 
                VALUES ('$_POST[firstName]', '$_POST[lastName]', '$_POST[email]', '$_POST[address]')";

        if ($conn->query($sql) === TRUE) {
        echo '<h1>Form Confirmation</h1>';
        } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
        }

        $conn->close();

        $imageName = $_FILES['picture']['name'];
        $tempName = $_FILES['picture']['tmp_name'];
        $uploadLoc = './'.$imageName;
        move_uploaded_file($tempName, $uploadLoc);

        echo '<dl>';
        echo '<dt>Full Name</dt><dd>' . $_POST['firstName'], " ", $_POST['lastName'] . '</dd>';
        echo '<dt>Email</dt><dd>' . $_POST['email'] . '</dd>';
        echo '<dt>Address</dt><dd>' . $_POST['address'] . '</dd>';
        echo '</dl>';
        echo "<img src='$uploadLoc'>";

    ?>
  </div>
</body>
</html>