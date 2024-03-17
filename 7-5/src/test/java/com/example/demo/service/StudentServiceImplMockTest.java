package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceImplMockTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentDao studentDao;


    @BeforeEach
    public void beforeEach() {
        Student mockStudent = new Student();
        mockStudent.setId(20);
        mockStudent.setName("Mock");
        // 有人呼叫就回去假的資料
        Mockito.when(studentDao.getById(Mockito.any())).thenReturn(mockStudent);
    }

    @Test
    public void getById() {
        Student student = studentService.getById(2);
        assertNotNull(student);
        assertEquals("Mock", student.getName());
        assertEquals(20, student.getId());
    }

    @Test
    public void getById2() {
        Student student = studentService.getById(2);
        assertNotNull(student);
        assertEquals("Mock", student.getName());
        assertEquals(20, student.getId());
    }


}