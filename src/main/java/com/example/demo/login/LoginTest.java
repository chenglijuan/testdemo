package com.example.demo.login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/2  17:25
 * @Decription:
 * @Modified:
 */
public class LoginTest {

    @BeforeMethod
    public void login(){
        System.out.println("托管系统登录成功");
    }
}
