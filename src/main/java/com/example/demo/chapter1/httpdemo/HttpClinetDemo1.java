package com.example.demo.chapter1.httpdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/24  14:49
 * @Decription:
 * @Modified:
 */
public class HttpClinetDemo1 {


    @Test
    public void test1(){
        HttpGet get = new HttpGet("https://www.baidu.com/");
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity,"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        HttpGet get = new HttpGet("http://localhost:8888/get/with/cookie");
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity,"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
