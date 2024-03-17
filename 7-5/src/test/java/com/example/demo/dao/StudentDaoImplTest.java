package com.example.demo.dao;

import com.example.demo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static javax.swing.text.html.HTML.Tag.S;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class StudentDaoImplTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void getById() {
        Student student = studentDao.getById(1);

        assertNotNull(student);
        assertEquals("Amy", student.getName());
        assertEquals(90.3, student.getScore());
        assertTrue(student.isGraduate());
        assertNotNull(student.getCreateDate());
    }

    @Transactional
    @Test
    public void delectById() {
        studentDao.deleteById(3);

        Student student = studentDao.getById(3);
        assertNull(student);
    }

    @Test
    @Transactional
    public void insert() {
        Student student = new Student();
        student.setName("Tom");
        student.setScore(80.5);
        student.setGraduate(false);

        Integer id = studentDao.insert(student);

        Student newStudent = studentDao.getById(id);

        assertNotNull(newStudent);
        assertEquals("Tom", newStudent.getName());
        assertEquals(80.5, newStudent.getScore());
        assertFalse(newStudent.isGraduate());
        assertNotNull(newStudent.getCreateDate());
    }


    @Test
    @Transactional
    public void update() {
        Student newStudent = studentDao.getById(3);
        newStudent.setName("Tom");
        studentDao.update(newStudent);

        Student student = studentDao.getById(3);
        assertNotNull(student );
        assertEquals("Tom", student.getName());
    }
}