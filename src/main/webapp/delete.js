function deleteStudent() {
    var deleteStudentResult = document.getElementById('delete-student-result');
    var id = document.getElementById('deleteId').value;

    if (!id) {
        deleteStudentResult.innerHTML = "Please enter an ID!";
        return false;
    }

    var xhr = new XMLHttpRequest();
    xhr.open("POST", CONTEXT_PATH + "/delete/student", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // Show message based on response
                deleteStudentResult.innerHTML = xhr.responseText == 1
                    ? "Student deleted successfully!"
                    : "Student not found!";
            } else {
                deleteStudentResult.innerHTML = "Error: " + xhr.status;
            }
        }
    };

    xhr.send("id=" + encodeURIComponent(id));
    return false;
}
