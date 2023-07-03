package com.divya.service;

import com.divya.dao.IStudentDAO;
import com.divya.dto.Student;
import com.divya.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {

	IStudentDAO stdDao;

	@Override
	public String save(Student student) {
		// TODO Auto-generated method stub
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.save(student);
	}

	@Override
	public Student findById(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteById(sid);
	}

}
