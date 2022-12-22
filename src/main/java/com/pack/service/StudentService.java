package com.pack.service;

import java.util.List;

import com.pack.model.Student;

public interface StudentService {
  
	Student saveStudent(Student student);
	List<Student> getAllStudent();
	Student getStudentById(long id);
	Student updateStudent(Student student,long id);
	void deleteStudent(long id);
	
}
