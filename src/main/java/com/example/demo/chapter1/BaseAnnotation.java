package com.example.demo.chapter1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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


}
