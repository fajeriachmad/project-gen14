<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
<!-- 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"> -->
	<link rel="stylesheet" href="assets/css/form.css">
</head>
<body>
	<div class="container">
		<form action="/MapenDemo/MyServlet?action=insert" method="post" name="insertForm" id="insertForm" onsubmit="return validateInsertForm()">	
			<h2> Tambah Dosen </h2>
			<div class="form-group">
				<label for="nama">Nama Dosen : </label> 
				<input type="text" name="nama" class="form-control" placeholder="Masukkan nama dosen..." id="nama"><br>
			</div>
			
			<button type="submit" class="btn">Simpan</button><br><br>
			<a href="/MapenDemo/MyServlet?action=list"><button type="button" class="btn">Kembali</button></a>
			
		</form>
	</div>

	<script type="text/javascript" src="assets/js/config.js"></script>
</body>
</html>