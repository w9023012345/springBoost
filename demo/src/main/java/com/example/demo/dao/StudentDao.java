package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentDao {

    Student getById(Integer id);

    void deleteById(Integer id);

    void insertList(List<Student> studentList);

    void insert(Student student);
}
