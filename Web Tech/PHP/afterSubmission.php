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
    <h1>Form Confirmation</h1>

    <?php
        // $full_name = isset($_POST['firstName']) ? $_POST['firstName'] : '';
        // $email = isset($_POST['email']) ? $_POST['email'] : '';
        // $address = isset($_POST['address']) ? $_POST['address'] : '';
        // $picture = isset($_POST['picture']) ? $_POST['picture'] : '';

        // if (empty($full_name) || empty($email) || empty($address)) {
        // echo '<p>Error: Please fill all required fields</p>';
        // } else {
        // echo '<img src="uploads/' . $picture . '" alt="User Picture">';
        // echo '<dl>';
        // echo '<dt>Full Name</dt><dd>' . $full_name . '</dd>';
        // echo '<dt>Email</dt><dd>' . $email . '</dd>';
        // echo '<dt>Address</dt><dd>' . $address . '</dd>';
        // echo '</dl>';
        // }

        if(isset($_POST['picture'])) {
            $target_dir = "uploads/";
            $target_file = $target_dir . basename($_FILES["image-upload"]["name"]);
            $uploadOk = 1;
            $imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));
            // Check if image file is a actual image or fake image
            $check = getimagesize($_FILES["image-upload"]["tmp_name"]);
            if($check !== false) {
                $uploadOk = 1;
            } else {
                echo "File is not an image.";
                $uploadOk = 0;
            }
            // Check if file already exists
            if (file_exists($target_file)) {
                echo "Sorry, file already exists.";
                $uploadOk = 0;
            }
            // Check file size
            if ($_FILES["image-upload"]["size"] > 500000) {
                echo "Sorry, your file is too large.";
                $uploadOk = 0;
            }
            // Allow certain file formats
            if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"
            && $imageFileType != "gif" ) {
                echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
                $uploadOk = 0;
            }
            // Check if $uploadOk is set to 0 by an error
            if ($uploadOk == 0) {
                echo "Sorry, your file was not uploaded.";
            // if everything is ok, try to upload file
            } else {
                if (move_uploaded_file($_FILES["image-upload"]["tmp_name"], $target_file)) {
                echo "The file ". htmlspecialchars( basename( $_FILES["image-upload"]["name"])). " has been uploaded.";
                } else {
                echo "Sorry, there was an error uploading your file.";
                }
            }

        }

        

        
        // echo '<img src="favicon.ico' . $_POST['picture'] . '" alt="User Picture">';
        echo '<dl>';
        echo '<dt>Full Name</dt><dd>' . $_POST['firstName'], " ", $_POST['lastName'] . '</dd>';
        echo '<dt>Email</dt><dd>' . $_POST['email'] . '</dd>';
        echo '<dt>Address</dt><dd>' . $_POST['address'] . '</dd>';
        echo '</dl>';
    ?>

    <img src="uploads/<?php echo basename($_FILES["image-upload"]["name"]); ?>" alt="Uploaded image">


    <!-- <p><a href="index.php">Go back to the form</a></p> -->
  </div>
</body>
</html>