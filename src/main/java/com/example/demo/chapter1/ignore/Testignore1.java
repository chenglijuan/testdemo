package com.example.demo.chapter1.ignore;

import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/11  11:14
 * @Decription:
 * @Modified:
 */
public class Testignore1 {

    @Test
    public void ignore1(){
        System.out.println("ignore1======> ");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2======> ");
    }




}
