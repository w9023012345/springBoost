package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer{

//    @Value("${printer.name}")
//    private String name;
//
//
//    @Value("${printer.count:20}")
//    private  int count;

// 初始化bean方法
//    @PostConstruct
//    public void init() {
//        count = 5;
//    }

//    @Override
//    public void print(String message) {
//        count--;
//        System.out.println("剩餘次數" + count);
//        System.out.println(name + ":" + message);
//
//    }

    @Override
    public void print(String message) {
        System.out.println("HP印表機:" + message);
    }
}
