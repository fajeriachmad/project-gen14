/**
 * 
 */

function validateInsertForm() {
//	const nama = document.getElementById("nama")
	var nama = document.forms["insertForm"]["nama"].value
	var regex = /^[a-zA-Z]+$/
	
	if (nama.value == "") {
		alert("Field nama tidak boleh kosong!")
		return false
	}
	if (!nama.match(regex)) {
		alert("Field nama tidak mengandung angka atau character!")
		return false
	}
	alert("Data dosen berhasil ditambahkan")
	return true
}

function validateUpdateForm() {
//	const nama = document.getElementById("nama")
	var nama = document.forms["updateForm"]["nama"].value
	var regex = /^[a-zA-Z]+$/
	if (nama.value == "") {
		alert("Field nama tidak boleh kosong!")
		return false
	}
	if (!nama.match(regex)) {
		alert("Field nama tidak mengandung angka atau character!")
		return false
	}
	alert("Data dosen berhasil diubah")
	return true
}