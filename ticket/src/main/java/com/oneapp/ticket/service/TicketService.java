package com.oneapp.ticket.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @SentinelResource("print")
    public void print() {
        System.out.println("ticket service");
    }
}
