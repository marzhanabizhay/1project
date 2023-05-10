package com.example.demo;

import com.example.demo.dto.AlbumPhotoDTO;
import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.PostDTO;
import com.example.demo.dto.UserAlbumDTO;
import com.example.demo.services.AlbumService;
import com.example.demo.services.PostService;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	PostService postService;
	@Autowired
	UserService userService;
	@Autowired
	AlbumService albumService;
	@Test
	void contextLoads() {
		List<PostDTO> allPosts = postService.getAllPosts();
		for(PostDTO post : allPosts){
			System.out.println(post.getBody()+"\n");
		}
	}

	@Test
	void getPostByID(){
		PostDTO post = postService.getPostById(1);
		System.out.println(post.getBody());
	}

	@Test
	void getCommentByPostId(){
		List<CommentDTO> comments = postService.getPostComment(1);
		for(CommentDTO comment : comments ){
			System.out.println(comment.getBody()+"\n");
		}
	}

	@Test
	void getUserAlbums(){
		List<UserAlbumDTO> albums = userService.getUserAlbums(1);
		for(UserAlbumDTO album : albums) {
			System.out.println(album.getTitle() + "\n");
		}
	}

	@Test
	void getAllAlbums(){
		List<UserAlbumDTO> albums = albumService.getAllAlbums();
		for(UserAlbumDTO album:albums){
			System.out.println(album.getTitle()+"\n");
		}
	}

	@Test
	void getAlbumPhoto(){
		List<AlbumPhotoDTO> photos = albumService.getAlbumPhotos(2);
		for(AlbumPhotoDTO photo:photos){
			System.out.println(photo.getThumbnailUrl()+"\n");
		}
	}


}
