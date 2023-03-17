<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="assets/css/form.css">
</head>
<body>
	<div class="container">
		<form action="/MapenDemo/MyServlet?action=update" method="post" id="updateForm" onsubmit="return validateUpdateForm()">		
		<h2> Update Dosen </h2>
			<label>ID Dosen : </label>
			<div class="form-group">
				<input type="text" class="form-control" value='<c:out value="${dosen.id}"></c:out>' name="id" readonly/><br>
				
				<label>Nama Dosen : </label> 
				<input type="text" class="form-control" value='<c:out value="${dosen.nama}"></c:out>' id="nama" name="nama"><br>			
			</div>
		
			<button type="submit" class="btn">Simpan</button><br><br>
			<a href="/MapenDemo/MyServlet?action=list"><button type="button" class="btn">Kembali</button></a>
		</form>
	</div>
	
	<script type="text/javascript" src="assets/js/config.js"></script>
</body>
</html>