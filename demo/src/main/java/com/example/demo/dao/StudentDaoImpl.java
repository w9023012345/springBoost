package com.example.demo.dao;

import com.example.demo.Student;
import com.example.demo.StudnetRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", id);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void insertList(List<Student> studentList) {
        String sql = "INSERT INTO student (name) VALUE (:studentName)";

        MapSqlParameterSource[] parametersSources = new MapSqlParameterSource[studentList.size()];

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            parametersSources[i] = new MapSqlParameterSource();
            parametersSources[i].addValue("studentName", student.getName());
        }

        namedParameterJdbcTemplate.batchUpdate(sql, parametersSources);

    }

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO student (name) VALUE (:studentName)";

        Map<String, Object> map = new HashMap<>();
        map.put("studentName", student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成 id = " + id);


    }
}
