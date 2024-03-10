package com.example.demo.service;

import com.example.demo.Student;
import com.example.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getById(Integer id) {
        return studentDao.getById(id);
    }

    @Override
    public String deleteById(Integer id) {
        return studentDao.deleteById(id);
    }

    @Override
    public String insertList(List<Student> studentList) {
        return studentDao.insertList(studentList);
    }

    @Override
    public String insert(Student student) {
        return studentDao.insert(student);
    }
}
