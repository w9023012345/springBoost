package com.example.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class StudentController {

    //    @RequestMapping(value = "/students", method = RequestMethod.POST)
    @PostMapping("/students")
    public String creat(@RequestBody @Valid Student student) {
        return "資料庫 creat";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable @Min(100) Integer studentId ) {
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
