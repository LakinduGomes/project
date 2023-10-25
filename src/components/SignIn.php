<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Retrieve data from the request
    $patientName = $_POST['p_name'];
    $age = $_POST['age'];
    $gender = $_POST['gender'];
    $telephone = $_POST['tp'];
    $address = $_POST['p_add'];
    $email = $_POST['email'];

    // Database connection parameters
    $dbHost = 'localhost';
    $dbUsername = 'root';
    $dbPassword = ''; // Replace with your actual password
    $dbName = 'patient_service';

    // Create a database connection
    $conn = new mysqli($dbHost, $dbUsername, $dbPassword, $dbName);

    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    // Data validation (you can add more validation here)
    if (empty($patientName) || empty($age) || empty($gender) || empty($telephone) || empty($address) || empty($email)) {
        echo "All fields are required.";
    } else {
        // Insert data into the database using a prepared statement
        $sql = "INSERT INTO patient_tlb (p_name, age, gender, tp, p_add, email) VALUES (?, ?, ?, ?, ?, ?)";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("sissss", $patientName, $age, $gender, $telephone, $address, $email);

        if ($stmt->execute()) {
            echo "Patient data inserted successfully.";
        } else {
            echo "Error: " . $stmt->error;
        }

        // Close the database connection
        $stmt->close();
    }

    // Close the database connection
    $conn->close();
}

?>
