package com.khadri.student.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.khadri.student.crud.connection.DBConnection;
import com.khadri.student.crud.form.StudentForm;

public class StudentDao {

	public int addStudent(StudentForm form) {

		int count = 0;
		Connection con = DBConnection.getConnection();

		try (PreparedStatement ps = con
				.prepareStatement("INSERT INTO student(std_id, std_name, course) VALUES (?, ?, ?)")) {

			ps.setInt(1, form.getStdId());
			ps.setString(2, form.getStdName());
			ps.setString(3, form.getStdCourse());

			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;

	}
	public List<StudentForm> viewStudent(int id) {
		
		List<StudentForm> resultList = new ArrayList<>();
		Connection con = DBConnection.getConnection();
		
		try (PreparedStatement ps = con
				.prepareStatement("SELECT * FROM STUDENT WHERE std_id=?")) {
			
			ps.setInt(1, id); 
			
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				StudentForm resultData  = new StudentForm();
				resultData.setStdId(resultSet.getInt(1));
				resultData.setStdName(resultSet.getString(2));
				resultData.setStdCourse(resultSet.getString(3));
				resultList.add(resultData);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
		
	}
	public List<StudentForm> viewAllStudent() {
		
		List<StudentForm> resultList = new ArrayList<>();
		Connection con = DBConnection.getConnection();
		
		try (PreparedStatement ps = con
				.prepareStatement("SELECT * FROM STUDENT")) {
			
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				StudentForm resultData  = new StudentForm();
				resultData.setStdId(resultSet.getInt(1));
				resultData.setStdName(resultSet.getString(2));
				resultData.setStdCourse(resultSet.getString(3));
				resultList.add(resultData);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
		
	}
	public int updateStudent(StudentForm form) {

		int count = 0;
		Connection con = DBConnection.getConnection();

		try (PreparedStatement ps = con.prepareStatement(
				"UPDATE student SET std_name=?, course=? WHERE std_id=?")) {

			ps.setString(1, form.getStdName());
			ps.setString(2, form.getStdCourse());
			ps.setInt(3, form.getStdId());

			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public int deleteStudent(int id) {

		int count = 0;
		Connection con = DBConnection.getConnection();

		try (PreparedStatement ps = con.prepareStatement(
				"DELETE FROM STUDENT WHERE std_id=?")) {

			ps.setInt(1, id);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
