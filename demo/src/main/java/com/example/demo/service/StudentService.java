package com.example.demo.service;

import com.example.demo.Student;

import java.util.List;

public interface StudentService {

    Student getById(Integer id);

    String deleteById(Integer id);

    String insertList(List<Student> studentList);

    String insert(Student student);
}
