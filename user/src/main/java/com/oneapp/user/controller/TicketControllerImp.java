package com.oneapp.user.controller;

import com.oneapp.user.model.Ticket;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.stereotype.Component;

/**
 * 容错类
 */
@Component
public class TicketControllerImp implements TicketController {
    @Override
    public Ticket getTicket() throws NoFallbackAvailableException {
        return null;
    }
}