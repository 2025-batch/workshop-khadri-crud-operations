package com.khadri.student.crud.context.listener;

import com.khadri.student.crud.connection.DBConnection;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class ServletContextListenerImpl implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		ServletContext sc = sce.getServletContext();
		String un = sc.getInitParameter("username");
		String password = sc.getInitParameter("password");
		String url = sc.getInitParameter("url");
		String driver = sc.getInitParameter("driver");

		DBConnection.createConnection(driver, url, un, password);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		DBConnection.close();
	}

}
