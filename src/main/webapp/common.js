function showSection(id) {
	let sections = document.getElementsByClassName("section");
	for (let i = 0; i < sections.length; i++) {
		sections[i].style.display = "none";
	}
	document.getElementById(id).style.display = "block";
}