package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    //    @RequestMapping(value = "/students", method = RequestMethod.POST)
    @PostMapping("/students")
    public String creat(@RequestBody Student student) {
        return "資料庫 creat";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable Integer studentId ) {
        return "資料庫 read操作";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {
        return  "資料庫 update操作";
    }


    @DeleteMapping("/students/{studentsId}")
    public String delete(@PathVariable Integer studentsId) {
        return  "資料庫 delete操作";
    }

}
