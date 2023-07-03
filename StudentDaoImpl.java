package com.divya.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.divya.dto.Student;
import com.divya.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDAO {

	Connection connection;

	@Override
	public String save(Student student) {
		String sqlinsertquery = "insert into students (`sname`,`sage`,`saddr`) values(?,?,?)";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlinsertquery);
			if (pstmt != null) {
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSaddr());
				
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		String sqlSelectquery = "select sid,sname,sage,saddr from  students where sid=?";
		PreparedStatement pstmt = null;
		Student student = null;
		String status = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectquery);
			if (pstmt != null) {
				pstmt.setInt(1, sid);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
//					copy the resultSet data to studentDTo and transfer to view
					student = new Student();
					student.setSid(rs.getInt(1));
					student.setSname(rs.getString(2));
					student.setSage(rs.getInt(3));
					student.setSaddr(rs.getString(4));
					
				}

			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;

	}

//	update
	@Override
	public String updateById(Student student) {
		String sqlUpdatequery = "update students set sname=?,sage=?,saddr=? where sid=?";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdatequery);
			if (pstmt != null) {
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSaddr());
				pstmt.setInt(4, student.getSid());
				
				int rowAffected = pstmt.executeUpdate();
				
				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "failure";
				}

			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}

		
		
		
		return status;
	}

//	delete
	@Override
	public String deleteById(Integer sid) {
		String sqlDeletequery = "delete from students where sid=?";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			Student student = findById(sid);
			if (student != null) {
				connection = JdbcUtil.getJdbcConnection();
				if (connection != null)
					pstmt = connection.prepareStatement(sqlDeletequery);
				if (pstmt != null) {
					pstmt.setInt(1, sid);

					int rowAffected = pstmt.executeUpdate();
					if (rowAffected == 1) {
						status = "success";
					}
				}
			} else {
				status = "not available";
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		return status;

	}

}
