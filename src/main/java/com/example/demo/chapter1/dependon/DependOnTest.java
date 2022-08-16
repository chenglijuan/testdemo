package com.example.demo.chapter1.dependon;

import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/12  15:59
 * @Decription:
 * @Modified:
 */
//依赖测试
public class DependOnTest {

    @Test
    public void test1(){
        System.out.println("测试方法1======>test1");
    }

    @Test(dependsOnMethods = "test1")
    public void test2(){
        System.out.println("测试方法2=====>test2");
    }



}
