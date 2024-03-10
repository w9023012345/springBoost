package com.example.demo.dao;

import com.example.demo.Student;
import com.example.demo.StudnetRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Student getById(Integer id) {
        String countSql = "SELECT count(*) FROM student";

        Map<String,Object> countMap = new HashMap<>();

        // 傳換成integer類型
        Integer count = namedParameterJdbcTemplate.queryForObject(countSql, countMap, Integer.class);

        System.out.println("student table總數 = " + count);

        // 不要用*號拿全部資料，浪費效能
        String sql = "SELECT id,name FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", id);

        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudnetRowMapper());

        return list.size() > 0 ? list.get(0) : null;
    }
}
