<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student CRUD</title>
<link rel="stylesheet" href="student.css">
<script>
var CONTEXT_PATH = "<%=request.getContextPath()%>";
</script>
<script type="text/javascript" src="common.js"></script>
<script type="text/javascript" src="add.js"></script>
<script type="text/javascript" src="view.js"></script>
<script type="text/javascript" src="view-all.js"></script>
</head>
<body>

	<div class="container">
		<h1>Student CRUD Operations</h1>

		<!-- Menu -->
		<div class="menu">
			<button onclick="showSection('add')">Add</button>
			<button onclick="showSection('view')">View</button>
			<button onclick="showSection('viewAll')">View All</button>
			<button onclick="showSection('update')">Update</button>
			<button onclick="showSection('delete')">Delete</button>
		</div>

		<!-- ADD -->
		<div id="add" class="section">
			<h2>Add Student</h2>
			<form id="addStudentForm" onsubmit="return addStudent()">
				<input type="text" name="id" id="id" placeholder="Student ID"
					required> <input type="text" name="name" id="name"
					placeholder="Student Name" required> <input type="text"
					name="course" id="course" placeholder="Course" required> <input
					type="submit" value="Add Student">
			</form>
			<div id="add-result"></div>
		</div>

		<!-- VIEW -->
		<div id="view" class="section">
			<h2>View Student</h2>
			<form id="viewStudentForm" onsubmit="return viewStudent()">
				<input type="text" name="id" id="searchId" placeholder="Student ID"
					required> <input type="submit" value="View Student">
			</form>
			<div id="view-student-result"></div>
		</div>

		<!-- VIEW ALL -->
		<div id="viewAll" class="section">
			<h2>View All Students</h2>
			<form id="viewAllStudentForm" onsubmit="return viewAllStudent()">
				<input type="submit" value="Load Students">
			</form>
			<div id="view-all-student-result"></div>
		</div>

		<!-- UPDATE -->
		<div id="update" class="section">
			<h2>Update Student</h2>
			<form action="StudentServlet" method="post">
				<input type="hidden" name="action" value="update"> <input
					type="text" name="id" placeholder="Student ID" required> <input
					type="text" name="name" placeholder="New Name"> <input
					type="text" name="course" placeholder="New Course"> <input
					type="submit" value="Update Student">
			</form>
		</div>

		<!-- DELETE -->
		<div id="delete" class="section">
			<h2>Delete Student</h2>
			<form action="StudentServlet" method="post">
				<input type="hidden" name="action" value="delete"> <input
					type="text" name="id" placeholder="Student ID" required> <input
					type="submit" value="Delete Student">
			</form>
		</div>

	</div>

</body>
</html>
