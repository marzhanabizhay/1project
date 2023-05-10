package com.example.demo.dto;

import lombok.Data;

@Data
public class AlbumPhotoDTO {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
