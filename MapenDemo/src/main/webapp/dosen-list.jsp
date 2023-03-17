<%@ page import="com.prodemy.web.model.Dosen"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dosen</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="assets/css/style.css">
	
</head>
<body>
	<div class="container">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-8"><h2>Daftar Dosen</h2></div>
						<div class="col-sm-4 text-right">
						
							<a href="/MapenDemo/MyServlet?action=new">
								<button type="button" class="btn btn-info"><i class="fa fa-plus"></i> Add New</button>
							</a>
							
						</div>
					</div>
				</div>
				
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Kode</th>
							<th>Nama</th>
							<th>Action</th>
						</tr>		
					</thead>
					<tbody>
						<c:forEach var="dosen" items="${daftarDosen}">
							<tr>
								<td bgcolor="#ccc"><c:out value="${dosen.id}" /></td>
								<td bgcolor="#ccc"><c:out value="${dosen.nama}" /></td>
								<td>
									<a class="edit" title="Edit" href="/MapenDemo/MyServlet?action=edit&id=<c:out value="${dosen.id}" />">
										<i class="fa fa-pencil" aria-hidden="true"></i>
									</a>
									<a class="delete" title="Delete" href="/MapenDemo/MyServlet?action=delete&id=<c:out value="${dosen.id}" />"
										onclick="return confirm('Anda yakin ingin menghapus data ini?')">
										<i class="fa fa-trash" aria-hidden="true"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<!--  
	<a href="new">Add new user</a>
		<table border="1" cellpadding="10" cellspacing="0">
			<thead>
				<tr>
					<th>Kode</th>
					<th>Nama</th>
					<th>Action</th>
				</tr>		
			</thead>
			<tbody>
				<c:forEach var="dosen" items="${daftarDosen}">
					<tr>
						<td bgcolor="#ccc"><c:out value="${dosen.id}" /></td>
						<td bgcolor="#ccc"><c:out value="${dosen.nama}" /></td>
						<td>
							<a href="edit?id=<c:out value="${dosen.id}" />">Edit</a>
							<a href="delete?id=<c:out value="${dosen.id}" />">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	-->
</body>
</html>