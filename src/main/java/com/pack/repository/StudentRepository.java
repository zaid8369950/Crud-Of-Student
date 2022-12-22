package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
