package com.example.demo.chapter1;

import org.testng.annotations.*;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/10  17:03
 * @Decription:
 * @Modified:
 */
public class BaseAnnotation {

    //最基本的注解，用来表示方法是测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是我的第一个接口自动化测试方法");
    }

    @Test
    public void testCase2(){
        System.out.println("这是我的第二个接口自动化测试方法");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod:在测试方法之前");
    }


    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod:在测试方法之前");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass: 在类运行之前BeforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass: 在类运行之前AfterClass");
    }

    //测试套件   在类之前运行，一个测试套件可以包含多个类
    @BeforeSuite(groups = "base")
    public void beforeSuite(){
        System.out.println("beforeSuite: 测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite:测试套件");
    }


}
