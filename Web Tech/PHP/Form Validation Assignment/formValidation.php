<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nysite</title>

    <style>
        form {
            width: 500px;
            margin: 0 auto;
            background-color: #f5f5f5;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            font-size: 16px;
        }

        input[type="text"],
        input[type="email"],
        input[type="file"] {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: none;
            margin-bottom: 10px;
            font-size: 16px;
        }

        input[type="file"] {
            background-color: #f5f5f5;
            cursor: pointer;
        }

        .form-buttons {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        input[type="submit"],
        button[type="button"] {
            background-color: #2ecc71;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        input[type="submit"]:hover,
        button[type="button"]:hover {
            background-color: #27ae60;
        }

        button[type="button"] {
            background-color: #e74c3c;
            transition: all 0.3s ease;
        }

        button[type="button"]:hover {
            background-color: #c0392b;
        }

        @media (max-width: 500px) {
            form {
                width: 100%;
            }
        }


    </style>
</head>

<body>
    <form action="afterSubmission.php" method="post" enctype="multipart/form-data">
    <label for="first-name">First Name:</label>
    <input type="text" id="first-name" name="firstName" required>

    <label for="last-name">Last Name:</label>
    <input type="text" id="last-name" name="lastName" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required>

    <label for="picture">Photo:</label>
    <input type="file" id="picture" name="picture" required>

    <div class="form-buttons">
        <input type="submit" value="Submit">
        <button type="button" id="cancel-btn">Cancel</button>
    </div>
    </form>

    <script>
        const cancelButton = document.getElementById('cancel-btn');
        const form = document.querySelector('form');

        cancelButton.addEventListener('click', () => {
            form.reset();
        });

    </script>

</body>
    
</html>

