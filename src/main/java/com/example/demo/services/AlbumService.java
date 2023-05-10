package com.example.demo.services;

import com.example.demo.dto.AlbumPhotoDTO;
import com.example.demo.dto.UserAlbumDTO;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AlbumService {
    @SneakyThrows
    public List<UserAlbumDTO> getAllAlbums(){
        String url = "https://jsonplaceholder.typicode.com/albums";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JavaType albumListType = mapper.getTypeFactory().constructCollectionType(List.class, UserAlbumDTO.class);
        List<UserAlbumDTO> albums = mapper.readValue(response, albumListType);
        return albums;
    }

    @SneakyThrows
    public List<AlbumPhotoDTO> getAlbumPhotos(Integer num){
        String url = "https://jsonplaceholder.typicode.com/albums/"+num+"/photos";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JavaType photoListType = mapper.getTypeFactory().constructCollectionType(List.class, AlbumPhotoDTO.class);
        List<AlbumPhotoDTO> photos = mapper.readValue(response, photoListType);
        return photos;
    }
}
