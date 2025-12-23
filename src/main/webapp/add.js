function addStudent() { 
		var addResultDiv = document.getElementById('add-result');

		// read data frm form
		var id = document.getElementById('id').value;
		var name = document.getElementById('name').value;
		var course = document.getElementById('course').value;
		
		// prepare http request
		//AJAX Asynchronus JavaScript XML
		var xhr = new XMLHttpRequest();
//		xhr.open("POST", "<%=request.getContextPath()%>/add/student?id="+id+"&name="+name+"&course="+course, true);
		xhr.open("POST", CONTEXT_PATH+"/add/student?id="+id+"&name="+name+"&course="+course, true);
		 
		
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var count = xhr.responseText;
				if(count == "1"){
					addResultDiv.innerHTML = "<span style='color:green'>Student added successfully.</span>";
				}else{
					addResultDiv.innerHTML = "<span style='color:red'>Student not added.</span>";
				}
			}
		}

		xhr.send();

		return false;

	}