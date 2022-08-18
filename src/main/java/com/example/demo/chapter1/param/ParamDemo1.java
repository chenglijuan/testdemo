package com.example.demo.chapter1.param;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/18  16:47
 * @Decription:
 * @Modified:
 */
// 参数化的第一种方式
public class ParamDemo1 {

    @Test(dataProvider = "datap")
    public void test1(String name,int age){
        System.out.println("name = "+name +"; age="+age);
    }

    @DataProvider(name = "datap")
    public Object[][] dataP(){

        Object[][] objects = new Object[][]{
                {"zhangsan",1},{"lisi",2},{"wangwu",6}
        };

        return objects;
    }


}
