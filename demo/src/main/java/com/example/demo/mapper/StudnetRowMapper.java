package com.example.demo.mapper;

import com.example.demo.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudnetRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//        // 從資料庫中取得數據
//        Integer a = rs.getInt("id");
//        String b = rs.getString("name");
//
//        // 將數據轉為 java object
//        Student student = new Student();
//        student.setId(rs.getInt("id"));
//        student.setName( rs.getString("name"));

        // 選到的類型會依照sql語法而改變
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));

        return student;
    }
}
