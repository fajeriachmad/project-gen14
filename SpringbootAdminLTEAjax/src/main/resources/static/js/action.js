/**
 * @author Fajri Rahman
 */

// a function to control the modal behaviour when data record successfully added, including the success message
function queryStatus(state) {
	if (state == "insert") {
		$(".status-msg").html("<span style='color: green'>Data added successfully</span>");
	}
	else if (state == "update") {
		$(".status-msg").html("<span style='color: green'>Data updated successfully</span>");		
	}
	$('.input-form').hide();
	$('.modal-footer').hide();
	setTimeout(function() {
		$('#editModal').modal('hide');
		$('#addModal').modal('hide');
		$('.status-msg').html("");
		$('input').val('');
	}, 1000);
	setTimeout(function() {
		$('.input-form').show();
		$('.modal-footer').show();
	}, 1500);
	showData();
}
// end of status result function

// a function to show the data based on keyword in real time
function showData() {
	$('#customerTable').empty();
	var urlPath = "";
	if ($('#table_search').val() == "") {
		urlPath = "http://localhost:8080/customer";
	}
	else {
		urlPath = "http://localhost:8080/customer/search/" + $('#table_search').val();
	}
	$.getJSON(urlPath, function(json) {
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
		tr.push('<tbody>');
		for (var i = 0; i < json.length; i++) {
			tr.push('<tr>');
			tr.push('<td>' + json[i].id + '</td>');
			tr.push('<td>' + json[i].name + '</td>');
			tr.push('<td>' + json[i].email + '</td>');
			tr.push('<td>' + json[i].city + '</td>');
			tr.push('<td><a class=\'btn btn-outline-warning edit\' id=' + json[i].id + '><i class="fas fa-edit"> Edit</i></a>&nbsp; | &nbsp;<a class=\'btn btn-outline-danger delete\' id=' 
				+ json[i].id + '><i class="fas fa-trash-alt"> Delete</i></a></td>');
			tr.push('</tr>');
		}
		tr.push('</tbody>');
		$('#customerTable').append($(tr.join('')));
	});
}

$(document).ready(function() {
	// show data on table
	showData();
	// end show data
	
	// show filtered data based on table_search keyword
	$('#table_search').on('keyup', function() {
		showData();
	});
	// end filtered data
	
	// insert new data with validation
	$('#insert-form').validate({
		// input field restriction
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
		// error messages on each field
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
		// if all input is valid, data will be transfered to REST controller
		submitHandler: function() {
			$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				url: "http://localhost:8080/customer/save",
				data: JSON.stringify({ 'name': $('#name').val(), 'email': $('#email').val(), 'city': $('#city').val() }),
				cache: false,
				success: function() {
					queryStatus("insert");					
				},
				error: function() {
					$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error inserting record').fadeIn().fadeOut(4000, function() {
						$(this).remove();
					});
				}
			})
		},
		// if there is any blank input, show the message below the input field using invalid-feedback class from bootstrap
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
	// end insert data

	// delete data by id
	$(document).delegate('.delete', 'click', function() {
		if (confirm('Are you sure to delete this data?')) {
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
	// end delete data

	// show the modal to edit data
	$(document).delegate('.edit', 'click', function() {
		$('#editModal').modal('show');
		var id = $(this).attr('id');
		$.getJSON('http://localhost:8080/customer/update/' + id, function(json) {
			$('#customerId').val(id);
			$('#eName').val(json.name);
			$('#eEmail').val(json.email);
			$('#eCity').val(json.city);
		});
	});
	// end of show edit modal

	// update selected data with validation
	$('#update-form').validate({
		// input field restriction
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
		// error messages on each field
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
		// if all input is valid, data will be transfered to REST controller
		submitHandler: function() {
			$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				url: "http://localhost:8080/customer/save",
				data: JSON.stringify({ 'id': $('#customerId').val(), 'name': $('#eName').val(), 'email': $('#eEmail').val(), 'city': $('#eCity').val() }),
				cache: false,
				success: function() {
					queryStatus("update");
				},
				error: function() {
					$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error inserting record').fadeIn().fadeOut(4000, function() {
						$(this).remove();
					});
				}
			})
		},
		// if there is any blank input, show the message below the input field using invalid-feedback class from bootstrap
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
	// end of data update
});