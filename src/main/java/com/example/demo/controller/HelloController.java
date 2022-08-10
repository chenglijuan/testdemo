package com.example.demo.controller;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: chenglijuan
 * @Data: 2022/1/17  15:46
 * @Decription:
 * @Modified:
 */
@RestController
public class HelloController {

    private static String url = "http://localhost:1080/WebTours/";


    @Test
    public void test(){
        //配置
        System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //设置窗口最大化
        driver.manage().window().maximize();
        driver.get(url);

        //切换到指定的frame  frame 里面有frameset的时候需要进行层层切换
        driver.switchTo().frame("body");
        driver.switchTo().frame("info");


        //添加断言可以判断是否走到指定的步骤
        Boolean welcomeResult = driver.findElement(By.tagName("body")).getText().contains("Welcome to the Web Tours site.\n");
//        if(welcomeResult){
//            System.out.println("进入下一步");
//        }

        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");
        //切换到指定的frame以后查找
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("1");
        //点击登录按钮
        driver.findElement(By.name("login")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //恢复到最外边的frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");
        driver.findElement(By.xpath("//img[@alt=\"Search Flights Button\"]")).click();


        List<FlightAddress> addressList = new ArrayList<FlightAddress>();
        //获取地址
        addressList = getAdds();
        if(addressList != null && addressList.size() > 0){
            for (FlightAddress address: addressList) {
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
                String flight = driver.findElements(By.name("outboundFlight")).get(2).getAttribute("value").substring(0,3);
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

                //Boolean confirmResult = driver.findElement(By.tagName("body")).getText().contains("Flight "+flight+" leaves "+address.getFromAdd()+" for "+address.getToAdd());
                String confirmResult = driver.findElement(By.tagName("body")).getText();
//                System.out.println(confirmResult);
                //Flight 242 leaves London for Paris.
                if(confirmResult.contains(flight) && confirmResult.contains(address.getFromAdd()) && confirmResult.contains(address.getToAdd())){
                    System.out.println("");
                    driver.findElement(By.name("Book Another")).click();
                }else{
                    System.out.println("订票失败");
                }


            }
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //退出
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");
        driver.findElement(By.xpath("//img[@alt=\"SignOff Button\"]")).click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();


    }


    public static List getAdds(){
        List<FlightAddress> addressList = new ArrayList<FlightAddress>();

        File file = new File("e:\\flight.txt");
        FileReader fileReader;
        FlightAddress address = null;
        try {
            //读成字节
            fileReader = new FileReader(file);
            //二进制转换成字符
            BufferedReader reader = new BufferedReader(fileReader);
            String row = "";
            while ((row = reader.readLine()) != null){
//                System.out.println(row);
                address = new FlightAddress();
                String [] adds = row.split(";");
                address.setFromAdd(adds[0]);
                address.setToAdd(adds[1]);
                addressList.add(address);
            }
            reader.close();
//            for (FlightAddress add: addressList) {
//                System.out.println(add.getFromAdd()+ "\t" + add.getToAdd());
//            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return addressList;
    }


}
