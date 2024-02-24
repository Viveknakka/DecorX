<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin home</title>
<link rel="stylesheet" href="./css/home.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
<style>
 .container{
    display:flex;
    align-items:center;
    
    
 }
 .item{
     margin:2%;
     padding:1%;
 }
</style>
</head>
<body>
<div class='container'>
        <form action="PUpdateServlet" method="post"> 
        <input type="submit" value="view" name="view"> 
        <input type="submit" value="add" name="add">
        <input type="submit" value="delete" name="delete">
        <input type="submit" value="update" name="update">
        <input type="submit" value="logout" name="logout">
        </form>
        
</div>
</body>
</html>