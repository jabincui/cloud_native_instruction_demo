package com.oneapp.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //能处理请求
public class HelloController {

    @ResponseBody // 这样hello()的返回值成为响应
    @RequestMapping("/hello") // 这样hello()响应"/hello"请求
    public String hello() {
        return "Hello World!";
    }

}
