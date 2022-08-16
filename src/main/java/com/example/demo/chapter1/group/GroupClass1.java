package com.example.demo.chapter1.group;

import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/16  10:05
 * @Decription:
 * @Modified:
 */
@Test(groups = "GroupClass")
public class GroupClass1 {

    public void test1(){
        System.out.println("GroupClass1==========>test1");
    }

    public void test2(){
        System.out.println("GroupClass1==========>test2");
    }

}
