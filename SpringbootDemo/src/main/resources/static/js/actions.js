/**
 * 
 */

$(document).ready(function() {
	$.getJSON('http://localhost:8081/customer', function(json) {
		var tr = [];
		for (var i = 0; i < json.length; i++) {
			tr.push('<tr>');
			tr.push('<td>' + json[i].id + '</td>');
			tr.push('<td>' + json[i].name + '</td>');
			tr.push('<td>' + json[i].email + '</td>');
			tr.push('<td>' + json[i].city + '</td>');

			tr.push('<td><a class=\'edit\'><i class="fa-solid fa-pen-to-square"></i></a><a class=\'delete\' id=' + json[i].id + '><i class="fa-regular fa-trash-can"></i></a></td>');
			tr.push('</tr>');
		}
		$('table').append($(tr.join('')));
	});

	$(document).delegate('#addNew', 'click', function(event) {
		event.preventDefault();

		var name = $('#name').val();
		var email = $('#email').val();
		var city = $('#city').val();

		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: "http://localhost:8081/customer/save",
			data: JSON.stringify({ 'name': name, 'email': email, 'city': city }),
			cache: false,
			success: function(result) {
				$("#msg").html("<span style='color: green'>Company added successfully</span>");
				window.setTimeout(function() { location.reload() }, 500)
			},
			error: function(err) {

			}
		});
	});

	$(document).delegate('.delete', 'click', function() {
		if (confirm('Do you really want to delete record?')) {
			var id = $(this).attr('id');
			var parent = $(this).parent().parent();
			$.ajax({
				type: "DELETE",
				url: "http://localhost:8081/customer/delete/" + id,
				cache: false,
				success: function() {
					parent.fadeOut('slow', function() {
						$(this).remove();
					});
					location.reload(true)
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

		name.html("<input type='text' id='name' value='" + name.html() + "'/>");
		email.html("<input type='text' id='email' value='" + email.html() + "'/>");
		city.html("<input type='text' id='city' value='" + city.html() + "'/>");

		buttons.html("<a id='save'><i class='fa-solid fa-floppy-disk'></i></a><a class='delete' id='" + id.html() + "'><i class='fa-regular fa-trash-can'></i></a>");
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
			url: "http://localhost:8081/customer/save",
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
				buttons.html("<a class='edit' id='" + id.html() + "'><i class='fa-solid fa-pen-to-square'></i></a><a class='delete' id='" + id.html() + "'><i class='fa-regular fa-trash-can'></i></a>");
			},
			error: function() {
				$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error updating record').fadeIn().fadeOut(4000, function() {
					$(this).remove();
				});
			}
		});
	});

});