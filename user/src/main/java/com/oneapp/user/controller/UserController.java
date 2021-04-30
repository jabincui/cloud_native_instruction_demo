package com.oneapp.user.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.oneapp.user.model.Ticket;
import com.oneapp.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;

@Controller
public class UserController {
    @Autowired
    private User user;
    @Autowired
    private TicketController ticketController;

    @ResponseBody
    @GetMapping(value = "/show_user")
    public String showUser() {
        return user.toString();
    }

    @ResponseBody
    @GetMapping(value = "/buy")
    @SentinelResource("buy_ticket")
    public String buyTicket(@RequestParam("userid") String id,
                            HttpServletRequest request) {
        Ticket ticket = ticketController.getTicket();
        if (ticket == null) {
            return "买票失败";
        }
        //绑定ticket主键和User主键...

        //查看请求的参数
        System.out.println("method: "+request.getMethod());
        System.out.println("request uri: "+request.getRequestURI());
        System.out.println("query string: "+request.getQueryString());
        System.out.println("context path: "+request.getContextPath());
        System.out.println("servlet path: "+request.getServletPath());
        System.out.println("remote addr: "+request.getRemoteAddr());
        System.out.println("remote host: "+request.getRemoteHost());
        System.out.println("remote port: "+request.getRemotePort());
        System.out.println("local addr: "+request.getLocalAddr());
        System.out.println("server port: "+request.getServerPort());
        System.out.println("request url: "+request.getRequestURL());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println("header names: "+s+":"+request.getHeader(s));
        }
        return "用户" + id + "已买票:" + ticket.getSerial();
    }

    @ResponseBody
    @GetMapping(value = "/")
    public String hello() {
        return "hello world";
    }
}