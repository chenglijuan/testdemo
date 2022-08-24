package com.example.demo.chapter1.dataprovride;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/17  下午9:06
 * @Decription:
 * @Modified:
 */
public class DataTest2 {

    @Test(dataProvider = "test1")
    public void test1(String name,int age){
        System.out.println("name="+name +"; age="+age);
    }


    @DataProvider(name = "test1")
    public Object[][] dataProvide(){
        Object[][] objects = new Object[][]{
                {"zhangsan",12},
                {"lisi",16},
                {"wangwu",20},
        };
        return objects;
    }




}
