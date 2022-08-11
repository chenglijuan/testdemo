package com.example.demo.chapter1.testng;

import org.testng.annotations.*;

public class TestNGClass1 extends BaseTestSuite{
    @BeforeClass
    public void setUp(){
        System.out.println("beforeClass——>>>>>>来自TestNGClass1类");
    }
    @AfterClass
    public void tearDown(){
        System.out.println("afterClass——>>>>>>来自TestNGClass1类");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod——>>>>>>来自TestNGClass1类>>>>beforeMethod");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod——>>>>>>来自TestNGClass1类>>>>afterMethod");
    }
    @Test
    public void testAdd(){
        System.out.println("这是TestNGClass1类中的第一个测试方法------------->>>>>>");
    }
    @Test
    public void testMethod(){
        System.out.println("这是TestNGClass1类中的第二个测试方法------------->>>>>>");
    }
}