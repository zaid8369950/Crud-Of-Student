package com.pack.service.impl;



import java.util.List;

import org.springframework.stereotype.Service;

import com.pack.exception.ResourceNotFoundException;
import com.pack.model.Student;
import com.pack.repository.StudentRepository;
import com.pack.service.StudentService;

@Service
public class StudentImpl implements StudentService {
   
	private StudentRepository studentRepository;

	public StudentImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
				return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(long id) {
				return  studentRepository.findById(id).orElseThrow(()
						-> new ResourceNotFoundException("Student","id",id));
	}

	@Override
	public Student updateStudent(Student student, long id) {
       Student existStudent = studentRepository.findById(id).orElseThrow(()
    		   -> new ResourceNotFoundException("Student","id",id));
       
       existStudent.setFirstName(student.getFirstName());
       existStudent.setLastName(student.getLastName());
       existStudent.setEmail(student.getEmail());
       
       studentRepository.save(existStudent);
       return existStudent;
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Student","id",id));
		studentRepository.deleteById(id);
		
	}
	
	
   
	
}
