package com.khadri.student.crud;


import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.khadri.student.crud.dao.StudentDao;
import com.khadri.student.crud.form.StudentForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/view/student" })
public class ViewStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		StudentDao dao = new StudentDao();
		List<StudentForm> listStudentForms = dao.viewStudent(Integer.valueOf(id));

		Gson gson = new Gson();
		String json = gson.toJson(listStudentForms);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(json);

	}
}
