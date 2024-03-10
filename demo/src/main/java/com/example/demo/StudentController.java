package com.example.demo;

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
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/students")
    public String insert(@RequestBody Student student) {
        String sql = "INSERT INTO student (name) VALUE (:studentName)";

        Map<String, Object> map = new HashMap<>();
        map.put("studentName", student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成 id = " + id);

        return "執行insert sql ";
    }

    @PostMapping("/students/batch")
    public String inserList(@RequestBody List<Student> studentList) {
        String sql = "INSERT INTO student (name) VALUE (:studentName)";

        MapSqlParameterSource[] parametersSources = new MapSqlParameterSource[studentList.size()];

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            parametersSources[i] = new MapSqlParameterSource();
            parametersSources[i].addValue("studentName", student.getName());
        }

        namedParameterJdbcTemplate.batchUpdate(sql, parametersSources);
        return "執行一批 insert sql ";
    }


    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        String sql = "DELETE FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        namedParameterJdbcTemplate.update(sql, map);

        return "執行delete sql ";
    }


    @GetMapping("/students/{studentId}")
    public Student select(@PathVariable Integer studentId) {

        String countSql = "SELECT count(*) FROM student";

        Map<String,Object> countMap = new HashMap<>();

        // 傳換成integer類型
        Integer count = namedParameterJdbcTemplate.queryForObject(countSql, countMap, Integer.class);

        System.out.println("student table總數 = " + count);

        // 不要用*號拿全部資料，浪費效能
        String sql = "SELECT id,name FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudnetRowMapper());

        return list.size() > 0 ? list.get(0) : null;
    }


}
