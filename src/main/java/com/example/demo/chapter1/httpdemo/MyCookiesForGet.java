package com.example.demo.chapter1.httpdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
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

    private CookieStore cookieStore;


    //在测试方法之前加载路径
    @BeforeTest
    public void geturl(){
        //读取文件   设置字符集
        resourceBundle = ResourceBundle.getBundle("application", Locale.CHINA);
        baseUrl = resourceBundle.getString("base.url");
    }

    //携带cookie访问
    @Test
    public void test1(){
        HttpGet get = new HttpGet(baseUrl + resourceBundle.getString("get.cookie.url"));
        DefaultHttpClient client = new DefaultHttpClient();
        try {
           HttpResponse response = client.execute(get);
           HttpEntity entity = response.getEntity();
           String result = EntityUtils.toString(entity);
           System.out.println(result);

           //获取cookies
            cookieStore = client.getCookieStore();
            List<Cookie> cookiesList = cookieStore.getCookies();

            for (Cookie cookie: cookiesList) {
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test(dependsOnMethods = "test1")
    public void test2(){
        HttpGet httpGet = new HttpGet(baseUrl + resourceBundle.getString("get.cookie"));
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.cookieStore);
        try {
           HttpResponse response = client.execute(httpGet);
           //获取响应码
            System.out.println(response.getStatusLine().getStatusCode());
           String result  = EntityUtils.toString(response.getEntity(),"utf-8");
           System.out.println("result="+result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
