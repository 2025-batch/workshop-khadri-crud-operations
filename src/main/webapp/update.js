function updateStudent() {
	var updateStudentResult = document.getElementById('update-student-result');

	var id = document.getElementById('updateId').value;
	var name = document.getElementById('updateName').value;
	var course = document.getElementById('updateCourse').value;

	var xhr = new XMLHttpRequest();
	xhr.open("POST", CONTEXT_PATH + "/update/student", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			updateStudentResult.innerHTML = xhr.responseText;
		}
	};

	var data = "id=" + id + "&name=" + name + "&course=" + course;
	xhr.send(data);

	return false;
}
