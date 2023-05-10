package com.example.demo.services;

import com.example.demo.dto.*;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @SneakyThrows
    public List<UserAlbumDTO> getUserAlbums(Integer num){
        String url = "https://jsonplaceholder.typicode.com/users/" +num+ "/albums";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JavaType albumListType = mapper.getTypeFactory().constructCollectionType(List.class, UserAlbumDTO.class);
        List<UserAlbumDTO> albums = mapper.readValue(response, albumListType);
        return albums;
    }
@SneakyThrows
    public List<UserToDoDTO> getUserToDos(Integer num){
        String url = "https://jsonplaceholder.typicode.com/users/" +num+ "/todos";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JavaType todoListType = mapper.getTypeFactory().constructCollectionType(List.class, UserToDoDTO.class);
        List<UserToDoDTO> todos = mapper.readValue(response, todoListType);
        return todos;
    }
    @SneakyThrows
    public List<UserPostDTO> getUserPosts(Integer num){
        String url = "https://jsonplaceholder.typicode.com/users/" +num+ "/posts";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JavaType postListType = mapper.getTypeFactory().constructCollectionType(List.class, UserPostDTO.class);
        List<UserPostDTO> posts = mapper.readValue(response, postListType);
        return posts;
    }
}

