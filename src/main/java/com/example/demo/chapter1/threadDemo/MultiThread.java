package com.example.demo.chapter1.threadDemo;

import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/17  下午10:05
 * @Decription:
 * @Modified:
 */
public class MultiThread {

    //parallel ="method" 方法级别的
    @Test
    public void test1(){
        System.out.println(" Thread id=" +Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.println(" Thread id=" +Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.println(" Thread id=" +Thread.currentThread().getId());
    }

    @Test
    public void test4(){
        System.out.println(" Thread id=" +Thread.currentThread().getId());
    }
}
