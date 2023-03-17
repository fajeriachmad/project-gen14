<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Tambah Dosen</h2>
	<form action="/MapenDemo/MyServlet?action=insert" method="post">		
		<label>Nama Dosen : </label> 
		<input type="text" name="nama" required="required"><br>
	
		<Input value="Simpan" type="submit">
	</form>
</body>
</html>