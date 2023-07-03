package com.divya.dao;

import com.divya.dto.Student;

public interface IStudentDAO {
	String save(Student student); // Creating a record

	Student findById(Integer sid); // Reading a record

	String updateById(Student student);// Updating a record

	String deleteById(Integer sid);// Deleting a record
}
