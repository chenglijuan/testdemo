package com.example.demo.chapter1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/11  10:19
 * @Decription:
 * @Modified:
 */
public class PayTest {

    @Test
    public void payTest(){
        System.out.println("支付测试：payTest");
    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("PayTest: beforeTest");
    }

}
