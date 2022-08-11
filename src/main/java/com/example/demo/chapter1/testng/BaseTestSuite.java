package com.example.demo.chapter1.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTestSuite {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("这是beforeSuite语句");
    }
    @AfterSuite
    public void afterSuite(){
            System.out.println("这是afterSuite语句");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BaseTestSuite类中的@BeforeClass");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("BaseTestSuite类中的@AfterClass");
    }
}