package com.khadri.student.crud;

import java.io.IOException;

import com.khadri.student.crud.dao.StudentDao;
import com.khadri.student.crud.form.StudentForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/add/student" })
public class AddStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String course = req.getParameter("course");
		
		StudentForm form = new StudentForm();
		form.setStdId(Integer.valueOf(id));
		form.setStdName(name);
		form.setStdCourse(course);

		StudentDao dao = new StudentDao();
		int count = dao.addStudent(form);
		
		 resp.getWriter().print(count);
	}
}
