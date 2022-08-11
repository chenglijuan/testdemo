package com.example.demo.chapter1;

import org.testng.annotations.*;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/11  10:25
 * @Decription:
 * @Modified:
 */
public class SuitConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite:测试套件之前");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite:测试套件之前");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("suiteConfig: beforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("suiteConfig:AfterTest");
    }


}
