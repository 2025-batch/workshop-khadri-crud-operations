function viewAllStudent() {
	var viewAllStudentResult = document.getElementById('view-all-student-result');

	var xhr = new XMLHttpRequest();
	xhr.open("GET", CONTEXT_PATH + "/view/all/student", true);


	xhr.onreadystatechange = function() {
		
		if (xhr.readyState == 4 && xhr.status == 200) {

		      var response = JSON.parse(xhr.responseText);

		      var html = "<table border='2' width='100%'>";
		      html += "<tr><th>ID</th><th>NAME</th><th>COURSE</th></tr>";

		      for (var i = 0; i < response.length; i++) {
		          html += "<tr>"
		                + "<td>" + response[i].stdId + "</td>"
		                + "<td>" + response[i].stdName + "</td>"
		                + "<td>" + response[i].stdCourse + "</td>"
		                + "</tr>";
		      }

		      html += "</table>";

		      viewAllStudentResult.innerHTML = html;
			
		}
	}

	xhr.send();

	return false;

}