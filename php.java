<?php
// Database connection details
$servername = "localhost";
$username = "your_username";
$password = "your_password";
$dbname = "your_database_name";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Fetching form data
$First name = $_POST['firstname'];
$Last name = $_POST['lastname'];
$Address= $_POST['Address'];
$password = $_POST['password'];
$Gender = $_POST['Gender'];
$Country = $_POST['Country'];
$Terms & Condition = $_POST['Terms & Condition'];

// Perform basic validation (you can add more validation as per your requirements)
if (empty($firstname) || empty($lastname) || empty($Address) || empty(password)  empty($Gender) empty($Country) empty($Terms & Condition)) {
    echo "All fields are required.";
} else {
    // SQL query to insert data into the database
    $sql = "INSERT INTO clients (firstname, lastname,Address, Password,Gender,Country, Terms & Conditon) VALUES ('$firstname','$lastname', '$Address', '$Password', '$Gender','$Country','Terms & Condition')";

    if ($conn->query($sql) === TRUE) {
        echo "Registration successful!";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
}

// Close database connection
$conn->close();
?>