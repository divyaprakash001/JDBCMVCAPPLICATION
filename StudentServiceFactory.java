package com.divya.factory;

import com.divya.service.IStudentService;
import com.divya.service.StudentServiceImpl;

public class StudentServiceFactory {

	private static IStudentService studentService = null;

	private StudentServiceFactory() {
	}

	public static IStudentService getStudentService() {

		if (studentService == null)
			studentService = new StudentServiceImpl();

		return studentService;
	}

}
