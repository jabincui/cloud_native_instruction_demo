package com.oneapp.user.controller;

import com.oneapp.user.model.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;

// value参数是需代理的微服务模块名
@FeignClient(value = "ticket", fallback = TicketControllerImp.class)
@Primary
public interface TicketController {
    @GetMapping(value = "/ticket")
    Ticket getTicket();
}
