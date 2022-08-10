package com.example.demo.controller;

import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/7/29  16:35
 * @Decription:
 * @Modified:
 */
public class TestNgDemo2 {

    @Test(dependsOnMethods = "method2",alwaysRun = true)
    public void method1(){
        System.out.println("这是方法一");
    }

    @Test
    public void method2(){
        System.out.println("这是方法二");
    }




}
