package com.Nahudev.application_blog_api_rest.controller;

import com.Nahudev.application_blog_api_rest.dto.PostEntityDTO;
import com.Nahudev.application_blog_api_rest.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostControllers {

    @Autowired
    private IPostService postService;

    @PostMapping("/create")
    public ResponseEntity<PostEntityDTO> createPost(@RequestBody PostEntityDTO postEntityDTO) {
        return new ResponseEntity<>(postService.createPost(postEntityDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<?> getAllPosts() {
        List<PostEntityDTO> postList = postService.getAllPost();

        if (postList != null) {
            return ResponseEntity.ok(postList);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getById/{post_id}")
    @ResponseBody
    public ResponseEntity<PostEntityDTO> getPostById(@PathVariable(name = "post_id") Long post_id) {
        return ResponseEntity.ok(postService.getPostById(post_id));
    }

    @PutMapping("/edit/{post_id}")
    public ResponseEntity<PostEntityDTO> editPost(@RequestBody PostEntityDTO postEntityDTO,
                                                  @PathVariable(name = "post_id") Long post_id) {

        PostEntityDTO postResponse = postService.editPost(postEntityDTO, post_id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{post_id}")
    public ResponseEntity<String> deletePost(@PathVariable Long post_id) {
        postService.deletePost(post_id);
        return new ResponseEntity<>("Posteo eliminado exitosamente!", HttpStatus.OK);
    }

}
