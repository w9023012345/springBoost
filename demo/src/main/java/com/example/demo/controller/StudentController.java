package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.StudnetRowMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public String insert(@RequestBody Student student) {
        return studentService.insert(student);
    }

    @PostMapping("/students/batch")
    public String inserList(@RequestBody List<Student> studentList) {
        return studentService.insertList(studentList);
    }


    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return studentService.deleteById(studentId);
    }


    @GetMapping("/students/{studentId}")
    public Student select(@PathVariable Integer studentId) {
        return studentService.getById(studentId);
    }


}
