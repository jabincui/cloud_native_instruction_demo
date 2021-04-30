package com.oneapp.ticket.controller;


import com.oneapp.ticket.model.Ticket;
import com.oneapp.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TicketController {
    @Autowired
    TicketService service;

    @ResponseBody
    @GetMapping(value = "/ticket")
    public Ticket getTicket() {
        service.print();
        return new Ticket();
    }
}
