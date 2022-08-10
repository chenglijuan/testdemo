package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: chenglijuan
 * @Data: 2022/2/10  10:23
 * @Decription:
 * @Modified:
 */
@RestController
public class GetSizeController {

    @Test
    public void test(){

        //设置配置
        System.setProperty("webdriver.chrome.driver","E:\\testing\\chromedriver.exe");
        //实例化一个浏览器对象
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);


        // 设置配置
//        System.setProperty("webdriver.chrome.driver","E:\\testing\\chromedriver.exe");
//        //实例化一个浏览器加载器的
//        WebDriver driver = new ChromeDriver();
//        //
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //打开链接
        driver.get("http://work.czzhengtai.com:18001/HousePresell/admin/login.shtml");
        //获取标题
        String title = driver.getTitle();
        System.out.println("title="+title);
        //窗口最大化
        driver.manage().window().maximize();

        Dimension dimension= driver.findElement(By.xpath("*//input[1]")).getSize();

    }
}
