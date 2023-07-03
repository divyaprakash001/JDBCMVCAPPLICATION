package com.divya.factory;

import com.divya.dao.IStudentDAO;
import com.divya.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static IStudentDAO studentDao = null;

	private StudentDaoFactory() {

	}

	public static IStudentDAO getStudentDao() {
		if (studentDao == null)
			studentDao = new StudentDaoImpl();

		return studentDao;
	}

}
