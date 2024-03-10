package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getById(Integer id) {
        return studentDao.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
         studentDao.deleteById(id);
    }

    @Override
    public void insertList(List<Student> studentList) {
         studentDao.insertList(studentList);
    }

    @Override
    public void insert(Student student) {
         studentDao.insert(student);
    }
}
