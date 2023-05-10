package com.example.demo.services;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.PostDTO;
import com.example.demo.dto.UserPostDTO;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostService {
    @SneakyThrows
    public List<PostDTO> getAllPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
//        list
        JavaType postListType = mapper.getTypeFactory().constructCollectionType(List.class, PostDTO.class);

        List<PostDTO> posts = mapper.readValue(response, postListType);
        //System.out.println(response);

        return posts;
    }
    @SneakyThrows
    public PostDTO getPostById(Integer num){
        String url = "https://jsonplaceholder.typicode.com/posts/"+num;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        PostDTO post = mapper.readValue(response, PostDTO.class);
        return post;
    }
    @SneakyThrows
    public List<CommentDTO> getPostComment(Integer num){
        String url = "https://jsonplaceholder.typicode.com/posts/"+num+"/comments";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JavaType postListType = mapper.getTypeFactory().constructCollectionType(List.class, CommentDTO.class);
        List<CommentDTO> comments = mapper.readValue(response, postListType);
        return comments;
    }
// methods get all posts
//            get post by ID
//            get post comments
}
