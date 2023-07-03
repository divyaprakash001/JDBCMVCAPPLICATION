package com.divya.service;

import com.divya.dto.Student;

public interface IStudentService {
	String save(Student student); // Creating a record

	Student findById(Integer sid); // Reading a record

	String updateById(Student student);// Updating a record

	String deleteById(Integer sid);// Deleting a record
}
