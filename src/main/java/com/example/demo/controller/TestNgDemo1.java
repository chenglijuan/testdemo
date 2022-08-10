package com.example.demo.controller;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


/**
 * @Author: chenglijuan
 * @Data: 2022/5/6  16:01
 * @Decription:
 * @Modified:
 */
@SpringBootTest
@Listeners({com.example.demo.util.ExtentTestNGIReporterListener.class})
public class TestNgDemo1 extends AbstractTestNGSpringContextTests {

    private static String url = "http://localhost:1080/WebTours/";

    private WebDriver driver;

    //打开浏览器 做一次
    @BeforeClass
    public void startExplorer() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //设置窗口最大化
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("打开浏览器");
//        Assert.assertTrue();  //添加断言
    }

    @Test(description = "登录", priority = 0)
    public void loginMethod() {
        System.out.println("登录");
        //切换到指定的frame  frame 里面有frameset的时候需要进行层层切换
        driver.switchTo().frame("body");
        driver.switchTo().frame("info");


        //添加断言可以判断是否走到指定的步骤
        Boolean welcomeResult = driver.findElement(By.tagName("body")).getText().contains("Welcome to the Web Tours site.\n");
        //添加断言
        Assert.assertTrue(welcomeResult);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");
        //切换到指定的frame以后查找
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("1");
        //点击登录按钮
        driver.findElement(By.name("login")).click();

    }

    @Test(description = "订票", priority = 1,dataProvider = "getAddress",dataProviderClass = ParamPro.class)
    public void bookTicket(Object adds) {

        FlightAddress address = (FlightAddress) adds;

        System.out.println("开始订票:从"+address.getFromAdd() +"到"+address.getToAdd());
        //恢复到最外边的frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");
        driver.findElement(By.xpath("//img[@alt=\"Search Flights Button\"]")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("info");
        //单选列表获取方法
        // 单选列表设置指定的Text进行勾选
        new Select(driver.findElement(By.name("depart"))).selectByVisibleText(address.getFromAdd());
        new Select(driver.findElement(By.name("arrive"))).selectByVisibleText(address.getToAdd());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //点击继续按钮
        driver.findElement(By.name("findFlights")).click();
        //切换到默认frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("info");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //单选 radio 选中
        driver.findElements(By.name("outboundFlight")).get(2).click();
        String flight = driver.findElements(By.name("outboundFlight")).get(2).getAttribute("value").substring(0, 3);
        System.out.println(flight);

        driver.findElement(By.xpath("//input[@name=\"reserveFlights\"]")).click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("info");
        driver.findElement(By.name("buyFlights")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //确认个人信息
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("info");

        String confirmResult = driver.findElement(By.tagName("body")).getText();

        if (confirmResult.contains(flight) && confirmResult.contains(address.getFromAdd()) && confirmResult.contains(address.getToAdd())) {
            System.out.println("订票成功");
            driver.findElement(By.name("Book Another")).click();
        } else {
            System.out.println("订票失败");
        }
//            }
//        }
        System.out.println("结束订票");
    }

    @Test(description = "注销", priority = 2)
    public void loginOut() {
        System.out.println("注销");
        //退出
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");
        driver.findElement(By.xpath("//img[@alt=\"SignOff Button\"]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // 每个方法结束以后 等待3秒
    @AfterMethod(description = "等待3秒钟")
    public void sleep2s() {
        System.out.println("等待3秒钟");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass(description = "关闭浏览器")
    public void quitExprolor() {
        System.out.println("关闭浏览器");
        driver.quit();
    }

}
