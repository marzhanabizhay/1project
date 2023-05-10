package com.example.demo.dto;

import lombok.Data;

@Data
public class UserToDoDTO {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

}
