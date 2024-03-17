package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceImplSpyTest {
    @Autowired
    private StudentService studentService;

    @SpyBean
    private StudentDao studentDao;

    @Test
    public void insert() {
        Mockito.doReturn(100).when(studentDao).insert(Mockito.any());

        Student student = new Student();
        student.setName("Mock");
        student.setScore(100.0);
        student.setGraduate(true);
        Integer id = studentService.insert(student);

        assertEquals(100, id);
    }

    @Test
    public void getById() {
        Student student = studentService.getById(3);
        assertNotNull(student);
        assertEquals("Judy", student.getName());
        assertEquals(3, student.getId());
    }



}