package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer>{

    List<Student> findByName(String name);

    Student findByIdAndName(Integer id, String name);
}
