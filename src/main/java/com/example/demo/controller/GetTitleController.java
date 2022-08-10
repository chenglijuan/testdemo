package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: chenglijuan
 * @Data: 2022/1/25  17:02
 * @Decription:
 * @Modified:
 */
@RestController
public class GetTitleController {

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "E:\\testing\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //打开链接
        driver.get("https://weibo.com/newlogin?tabtype=weibo&gid=102803&url=https%3A%2F%2Fweibo.com%2F");
        //获取标题
        String title = driver.getTitle();
        System.out.println("标题是："+title);
        //设置窗口最大化
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[text()=' 同城 ']")).click();

        //歇5秒
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //刷新
        driver.navigate().refresh();

        //打开微博
        driver.get("https://weibo.com/newlogin?tabtype=weibo&gid=102803&url=https%3A%2F%2Fweibo.com%2F");
        //停留5秒
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //后退
        driver.navigate().back();

    }
}
