package com.example.demo.chapter1.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;


public class GroupTest {

    @Test(groups = "server")
    public void test1(){
        System.out.println("server测试方法1======》test1");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("server测试方法2======》test2");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("client测试方法3======》test3");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("client测试方法4======》test4");
    }

    @BeforeGroups("server")
    public void serverBeforeGroup(){
        System.out.println("serverBeforeGroup=====>");
    }
    @AfterGroups("server")
    public void serverAfterGroups(){
        System.out.println("serverAfterGroups=====>");
    }
    @BeforeGroups("client")
    public void clientBeforeGroup(){
        System.out.println("clientBeforeGroup=====>");
    }
    @AfterGroups("client")
    public void clientAfterGroup(){
        System.out.println("clientAfterGroup=====>");
    }

}
