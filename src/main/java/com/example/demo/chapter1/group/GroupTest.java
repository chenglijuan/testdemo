package com.example.demo.chapter1.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/16  下午8:22
 * @Decription:
 * @Modified:
 */
public class GroupTest {

    @Test(groups = "server")
    public void servertest1(){
        System.out.println("servertest1");
    }

    @Test(groups = "server")
    public void servertest2(){
        System.out.println("servertest2");
    }

//    @Test(groups = "client")
//    public void clienttest1(){
//        System.out.println("clienttest1");
//    }
//
//    @Test(groups = "client")
//    public void clienttst2(){
//        System.out.println("clienttst2");
//    }

    @BeforeGroups("server")
    public void  beforeServerTest1(){
        System.out.println("beforeServerTest1======");
    }

    @AfterGroups("server")
    public void  afterServerTest1(){
        System.out.println("afterServerTest1======");
    }


}
