package com.example.demo;


import org.junit.jupiter.api.*;

public class MyTest {

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

    @Test
    public void test1() {
        System.out.println("TEST1");
    }

    @Test
    public void test2() {
        System.out.println("TEST2");
    }
}
