package com.example.demo.chapter1.httpdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/24  15:23
 * @Decription:
 * @Modified:
 */
public class MyCookiesForGet {

    private String baseUrl = "";
    private ResourceBundle resourceBundle;


    //在测试方法之前加载路径
    @BeforeTest
    public void geturl(){
        //读取文件   设置字符集
        resourceBundle = ResourceBundle.getBundle("application", Locale.CHINA);
        baseUrl = resourceBundle.getString("base.url");
    }

    @Test
    public void test1(){
        HttpGet get = new HttpGet(baseUrl + resourceBundle.getString("get.cookie.url"));
        HttpClient client = new DefaultHttpClient();
        try {
           HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
           String result = EntityUtils.toString(entity);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
