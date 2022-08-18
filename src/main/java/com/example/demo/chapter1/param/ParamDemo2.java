package com.example.demo.chapter1.param;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/18  16:50
 * @Decription:
 * @Modified:
 */
public class ParamDemo2 {

    @Test
    @Parameters({"name","age"})
    public void test1(String name,int age){
        System.out.println("name = "+name +"; age="+age);
    }

}
