package com.example.demo.chapter1.dataprovride;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/17  下午8:58
 * @Decription:
 * @Modified:
 */
//第一种方式 通过配置文件的方式
public class DataTest1 {

    //1、测试方法
    //2、配置文件设置parameter标签
    //3、方法上新增@Parameters注解
    //4、


    @Test
    @Parameters({"name","age"})
    public void test1(String name,int age){
        System.out.println("name="+name +"; age="+age);
    }

}
