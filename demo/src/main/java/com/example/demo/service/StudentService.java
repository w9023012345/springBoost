package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    Student getById(Integer id);

    void deleteById(Integer id);

    void insertList(List<Student> studentList);

    void insert(Student student);
}
