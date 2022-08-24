package com.example.demo.chapter1.group;

import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/16  10:05
 * @Decription:
 * @Modified:
 */
@Test(groups = "GroupClass")
public class GroupClass2 {

    @Test
    public void test1(){
        System.out.println("GroupClass2==========>test1");
    }
    @Test
    public void test2(){
        System.out.println("GroupClass2==========>test2");
    }

}
