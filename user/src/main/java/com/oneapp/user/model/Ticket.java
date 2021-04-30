package com.oneapp.user.model;

import lombok.Data;

@Data
public class Ticket {
    private int id;
    private int price; // 单位：分
    private String name;
    private String serial;
}
