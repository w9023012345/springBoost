package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class MyConfiguration {

    public Printer myPrinter() {
        return new HpPrinter();
    }



}
