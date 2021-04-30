package com.oneapp.user.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private int id;
    private String email;
    private String password;

    public User() {
        this(0, "abc@111.com", "123456");
    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
