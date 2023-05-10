package com.example.demo.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private int postId;
    private int id;
    private String body;
    private String name;
    private String email;

}
