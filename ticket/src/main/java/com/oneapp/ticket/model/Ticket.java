package com.oneapp.ticket.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Ticket {
    private int id;
    private int price; // 单位：分
    private String name;
    private String serial;

    public Ticket() {
        this.id = 0;
        this.price = 10000;
        this.name = "场馆1";
        this.serial = UUID.randomUUID().toString();
    }
}
