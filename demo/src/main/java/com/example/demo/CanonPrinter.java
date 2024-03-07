package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CanonPrinter implements Printer, InitializingBean {

    public int count;


    @Override
    public void print(String message) {
        count--;
        System.out.println("剩餘使用次數" + count);
        System.out.println("canon印表機" + message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        count = 5;
    }
}
