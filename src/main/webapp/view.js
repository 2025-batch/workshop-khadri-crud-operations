function viewStudent() {
	var viewStudentResult = document.getElementById('view-student-result');

	var id = document.getElementById('searchId').value;

	var xhr = new XMLHttpRequest();
	xhr.open("GET", CONTEXT_PATH + "/view/student?id=" + id, true);


	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var response = JSON.parse(xhr.responseText);
			//alert(response);
			for (var i = 0; i < response.length; i++) {
				//alert('ID = ' + response[i].stdId + ' NAME =' + response[i].stdName + ' COURSE=' + response[i].stdCourse);

				var result = 
				            "<table border='2'>"+
							"<tr> <th> ID </th> <th> NAME </th> <th> COURSE  </th></tr>" +
					       "<tr> <td>" + response[i].stdId + " </td> <td>" + response[i].stdName + "  </td>  <td>" + response[i].stdCourse + " </td> </tr>"
						   + "</table>"

				viewStudentResult.innerHTML = result;
			}
		}
	}

	xhr.send();

	return false;

}