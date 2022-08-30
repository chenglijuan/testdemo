package com.example.demo.controller;


import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/30  下午8:26
 * @Decription:
 * @Modified:
 */
@RestController
@RequestMapping("/postDmo")
public class PostDemoController {

    /**
     * POST请求返回cookie
     * @return
     */
    @RequestMapping(value = "/postCookie",method = RequestMethod.POST)
    public String getCookie(HttpServletResponse response){
       Cookie cookie = new Cookie("login","true");
       response.addCookie(cookie);
        return "恭喜你获取cookie成功";
    }

    /**
     * POST 携带请求Cookie和参数方法1
     * @param response
     * @param request
     * @param userName
     * @param password
     * @return
     */

    @RequestMapping(value = "/postWithParam1",method = RequestMethod.POST)
    public String getWithParam1(HttpServletResponse response,HttpServletRequest request,
                                @RequestParam String userName,
                                @RequestParam String password){
        Cookie[] cookie = request.getCookies();
        if(Objects.isNull(cookie)){
            return "未携带cookie";
        }
        if(!("zhangsan".equals(userName) && "123456".equals(password))){
            return "用户名或密码错误";
        }
        return "恭喜你获取cookie成功";
    }

    /**
     * get请求携带cookie和参数的第二种方法
     * @param response
     * @param request
     * @return
     */

    @RequestMapping(value = "/postWithParam2",method = RequestMethod.POST)
    public String getWithParam2(HttpServletResponse response,HttpServletRequest request,
                                @RequestBody User user){
        Cookie[] cookie = request.getCookies();
        if(Objects.isNull(cookie)){
            return "未携带cookie";
        }
        System.out.println("name="+user.getName());
        System.out.println("userName="+user.getUserName());
        return "恭喜你登录成功";
    }

}
