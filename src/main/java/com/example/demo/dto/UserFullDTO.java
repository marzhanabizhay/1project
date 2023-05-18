package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserFullDTO {
    private UserDTO userDTO;
    private List<UserAlbumDTO> userAlbumDTO;
    private List<UserPostDTO> userPostDTO;
    private List<UserToDoDTO> userToDoDTO;


}
