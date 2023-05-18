package com.example.demo.services;

import com.example.demo.dto.*;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    @SneakyThrows
    public UserDTO getUserById(Integer num) {
        String url = "https://jsonplaceholder.typicode.com/users/" +num;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        UserDTO user = mapper.readValue(response, UserDTO.class);
        return user;
    }
    @SneakyThrows
    public AddressDTO getUserAddressById(Integer num) {
        String url = "https://jsonplaceholder.typicode.com/users/" +num;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        UserDTO user = mapper.readValue(response, UserDTO.class);
        return user.getAddress();
    }
@SneakyThrows
    public List<UserDTO> getAllUsers(){
        String url = "https://jsonplaceholder.typicode.com/users/";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JavaType userListType = mapper.getTypeFactory().constructCollectionType(List.class, UserDTO.class);
        List<UserDTO> users = mapper.readValue(response, userListType);
        return users;
    }

    @SneakyThrows
    public UserFullDTO getFullInfoById(Integer num){
        UserDTO user = getUserById(num);
        List<UserAlbumDTO> album = getUserAlbums(num);
        List<UserPostDTO> post = getUserPosts(num);
        List<UserToDoDTO> todo = getUserToDos(num);
        UserFullDTO userFull = new UserFullDTO();
        userFull.setUserDTO(user);
        userFull.setUserAlbumDTO(album);
        userFull.setUserPostDTO(post);
        userFull.setUserToDoDTO(todo);
        return userFull;


    }
}

