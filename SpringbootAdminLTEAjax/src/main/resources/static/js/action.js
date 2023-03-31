/**
 * @author Fajri Rahman
 */

function saveDataStatus() {
	$("#msg").html("<span style='color: green'>Data added successfully</span>");
	$("#input-form").hide();
	setTimeout(function() {
		$("#addModal").modal('hide');
		$('#name').val('');
		$('#email').val('');
		$('#city').val('');
		$('#msg').html("");
	}, 1000);
	setTimeout(function() {
		$("#input-form").show();
	}, 1500);
	showData();
}

function showData() {
	$('#customerTable').empty();
	$.getJSON('http://localhost:8080/customer', {keyword: $('#table_search').val()}, function(json) {
		var tr = [];
		tr.push('<thead>');
		tr.push('<tr>');
		tr.push('<th>ID</th>');
		tr.push('<th>Name</th>');
		tr.push('<th>Email</th>');
		tr.push('<th>City</th>');
		tr.push('<th>Action</th>');
		tr.push('</tr>');
		tr.push('</thead>');
		for (var i = 0; i < json.length; i++) {
			tr.push('<tr>');
			tr.push('<td>' + json[i].id + '</td>');
			tr.push('<td>' + json[i].name + '</td>');
			tr.push('<td>' + json[i].email + '</td>');
			tr.push('<td>' + json[i].city + '</td>');

			tr.push('<td><a class=\'btn btn-outline-warning edit\'><i class="fas fa-edit"> Edit</i></a>&nbsp; | &nbsp;<a class=\'btn btn-outline-danger delete\' id='
				+ json[i].id +
				'><i class="fas fa-trash-alt"> Delete</i></a></td>');
			tr.push('</tr>');
		}
		$('#customerTable').append($(tr.join('')));
	});
}


$(document).ready(function() {
	// menampilkan table
	$('#table_search').on('keyup', function() {
		showData();
	});
	showData();
	$("#closeAdd, #closeModal").click(function (){
		setTimeout(function() {
			$('#msg').html("");
		}, 500);
	});
	$(document).delegate('#addNew', 'click', function(event) {
		// disable fungsi default dari tombol
		event.preventDefault();

		var name = $('#name').val();
		var email = $('#email').val();
		var city = $('#city').val();
		
		if (city == "") {
			$("#msg").html( "<span style='color: red'>City is requid</span>" );
		}
		if (email == "") {
			$("#msg").html( "<span style='color: red'>Email is required</span>" );
		}
		if (name == "") {
			$("#msg").html( "<span style='color: red'>Name is required</span>" );
		}
		if (name != "" && email != "" && city != "") {
				$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				url: "http://localhost:8080/customer/save",
				data: JSON.stringify({ 'name': name, 'email': email, 'city': city }),
				cache: false,
				success: saveDataStatus
			});	
		}
	});

	$(document).delegate('.delete', 'click', function() {
		if (confirm('Do you really want to delete record?')) {
			var id = $(this).attr('id');
			var parent = $(this).parent().parent();
			$.ajax({
				type: "DELETE",
				url: "http://localhost:8080/customer/delete/" + id,
				cache: false,
				success: function() {
					parent.fadeOut('slow', function() {
						$(this).remove();
					});
					showData();
				},
				error: function() {
					$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error deleting record').fadeIn().fadeOut(4000, function() {
						$(this).remove();
					});
				}
			});
		}
	});

	$(document).delegate('.edit', 'click', function() {
		var parent = $(this).parent().parent();

		var id = parent.children("td:nth-child(1)");
		var name = parent.children("td:nth-child(2)");
		var email = parent.children("td:nth-child(3)");
		var city = parent.children("td:nth-child(4)");
		var buttons = parent.children("td:nth-child(5)");

		name.html("<input type='text' class='form-control' id='name' value='" + name.html() + "'/>");
		email.html("<input type='text' class='form-control' id='email' value='" + email.html() + "'/>");
		city.html("<input type='text' class='form-control' id='city' value='" + city.html() + "'/>");

		buttons.html("<a class='btn btn-outline-success' id='save'><i class='fas fa-save'> Save</i></a>&nbsp; | &nbsp;<a class='btn btn-outline-danger delete' id='"
			+ id.html() +
			"'><i class='fas fa-trash-alt'> Delete</i></a>");
	});

	$(document).delegate('#save', 'click', function() {
		var parent = $(this).parent().parent();

		var id = parent.children("td:nth-child(1)");
		var name = parent.children("td:nth-child(2)");
		var email = parent.children("td:nth-child(3)");
		var city = parent.children("td:nth-child(4)");
		var buttons = parent.children("td:nth-child(5)");

		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: "http://localhost:8080/customer/save",
			data: JSON.stringify({
				'id': id.html(),
				'name': name.children("input[type=text]").val(),
				'email': email.children("input[type=text]").val(),
				'city': city.children("input[type=text]").val()
			}),
			cache: false,
			success: function() {
				name.html(name.children("input[type=text]").val());
				email.html(email.children("input[type=text]").val());
				city.html(city.children("input[type=text]").val());
				buttons.html("<a class='btn btn-outline-warning edit' id='" + id.html() + "'><i class='fas fa-edit'> Edit</i></a>&nbsp; | &nbsp;<a class='btn btn-outline-danger delete' id='"
					+ id.html() +
					"'><i class='fas fa-trash-alt'> Delete</i></a>");
			},
			error: function() {
				$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error updating record').fadeIn().fadeOut(4000, function() {
					$(this).remove();
				});
			}
		});
	});
	
	
//	$(document).delegate('.edit', 'click', function() {
//		var parent = $(this).parent().parent();
//	
//		var id = parent.children("td-child(1)");
//		var name = parent.children("td:n-child(2)");
//		var email = parent.children("td:n-child(3)");
//		var city = parent.children("td:n-child(4)");
//		var buttons = parent.children("td:n-child(5)");
//	
//		name.html("<input type='text' id='name' value='" + name.html + "'/>");
//		email.html("<input type='text' id='email' value='" + email.html() + "'/>");
//		city.html("<input type='text' id='city' value='" + city.html() + "'/>");
//	
//		buttons.html("<a id='save'><i class='fas fa-save' style='color:#28a745;cursor:pointer;'> Save</i></a>&nbsp; | &nbsp;<a class='delete' id='"
//			+ id.html() +
//			"'><i class='fas fa-trash-alt' style='color:#dc3545;cursor:pointer;'> Delete</i></a>");
//	});
//	$(document).delegate('#save', 'click', function() {
//		var parent = $(this).parent().parent();
//
//		var id = parent.children("td:nth-child(1)");
//		var name = parent.children("td:nth-child(2)");
//		var email = parent.children("td:nth-child(3)");
//		var city = parent.children("td:nth-child(4)");
//		var buttons = parent.children("td:nth-child(5)");
//
//		$.ajax({
//			type: "POST",
//			contentType: "application/json; charset=utf-8",
//			url: "http://localhost:8080/customer/save",
//			data: JSON.stringify({
//				'id': id.html(),
//				'name': name.children("input[type=text]").val(),
//				'email': email.children("input[type=text]").val(),
//				'city': city.children("input[type=text]").val()
//			}),
//			cache: false,
//			success: function() {
//				name.html(name.children("input[type=text]").val());
//				email.html(email.children("input[type=text]").val());
//				city.html(city.children("input[type=text]").val());
//				buttons.html("<a class='edit' id='" + id.html() + "'><i class='fas fa-edit' style='color:#ffc107;cursor:pointer;'> Edit</i></a>&nbsp; | &nbsp;<a class='delete' id='"
//					+ id.html() +
//					"'><i class='fas fa-trash-alt' style='color:#dc3545;cursor:pointer;'> Delete</i></a>");
//			},
//			error: function() {
//				$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error updating record').fadeIn().fadeOut(4000, function() {
//					$(this).remove();
//				});
//			}
//		});
//	});


});

/*$(function () {
  $.validator.setDefaults({
    submitHandler: function () {
      alert( "Form successful submitted!" );
    }
  });
  $('#quickForm').validate({
	  rules: {
		  name: {
			  required: true,
		  },
		  email: {
			  required: true,
			  email: true,
		  },
		  city: {
			  required: true
		  },
	  },
	  messages: {
		  name: {
			  required: "Please fill name input field",
		  },
		  email: {
			  required: "Please enter an email address",
			  email: "Please enter a valid email address"
		  },
		  city: {
			  required: "Please fill city input field",
		  },
	  },
	  errorElement: 'span',
	  errorPlacement: function(error, element) {
		  error.addClass('invalid-feedback');
		  element.closest('.form-group').append(error);
	  },
	  highlight: function(element, errorClass, validClass) {
		  $(element).addClass('is-invalid');
	  },
	  unhighlight: function(element, errorClass, validClass) {
		  $(element).removeClass('is-invalid');
	  }
  });
});*/