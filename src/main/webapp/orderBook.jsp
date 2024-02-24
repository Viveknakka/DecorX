<%@ page import="java.sql.*, java.io.*, java.util.*, java.text.*" %>
<%@ page import="java.time.LocalDateTime, java.util.Date" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OrderBooking</title>
    <!-- Add any additional styles or scripts here -->
</head>
<body>

<form method="post" action="OrderBookServlet">
<h1>OrderDetails</h1>
    <label for="date">EventDate:</label>
    <input type="date" id="date" name="date" required><br>

    <label for="time">EventTime:</label>
    <input type="time" id="time" name="time" required><br>
    <br>
    Address:
    <input type="text" name="address">
    <!-- Add other form fields if needed -->

    <input type="submit">
</form>

</body>
</html>
