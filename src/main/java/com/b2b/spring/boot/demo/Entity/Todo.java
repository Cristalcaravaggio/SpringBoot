package com.b2b.spring.boot.demo.Entity;

import lombok.Data;

@Data
public class Todo {
    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;

}
