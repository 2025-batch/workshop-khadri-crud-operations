package com.khadri.student.crud;

import java.io.IOException;

import com.khadri.student.crud.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete/student")
public class DeleteStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String id = req.getParameter("id");

		StudentDao dao = new StudentDao();
		int count = dao.deleteStudent(Integer.valueOf(id));

		resp.getWriter().print(count);
	}
}

