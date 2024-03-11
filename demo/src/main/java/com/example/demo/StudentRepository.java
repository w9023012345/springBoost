package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer>{

    List<Student> findByName(String name);

    Student findByIdAndName(Integer id, String name);

    @Query(value = "SELECT id,name from student WHERE id = ?1 AND name = ?2", nativeQuery = true)
    Student test1(Integer id, String name);
}
