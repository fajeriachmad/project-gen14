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
	<h2> Update Dosen </h2>
	
	<!--  -->
	
	<form action="/MapenDemo/MyServlet?action=update" method="post">		
		<label>ID Dosen : </label>
		<input type="text" value='<c:out value="${dosen.id}"></c:out>' name="id" readonly/><br>
		
		<label>Nama Dosen : </label> 
		<input type="text" value='<c:out value="${dosen.nama}"></c:out>' name="nama" required="required"><br>
	
		<Input value="Simpan" type="submit">
	</form>
</body>
</html>