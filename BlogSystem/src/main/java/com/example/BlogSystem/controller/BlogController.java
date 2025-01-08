package com.example.BlogSystem.controller;

import com.example.BlogSystem.model.Blog;
import com.example.BlogSystem.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return new ResponseEntity<>(blogService.fetchAllBlogs(), HttpStatus.OK);
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<Blog> findById(@PathVariable Long blogId) {
        return new ResponseEntity<>(blogService.findBlogById(blogId), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Blog> postBlog(@Valid @RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.saveBlog(blog), HttpStatus.CREATED);
    }

    @PutMapping("/{blogId}")
    public ResponseEntity<Blog> updateBlog(@Valid @RequestBody Blog blog, @PathVariable Long blogId) {
        return new ResponseEntity<>(blogService.updateBlog(blog, blogId), HttpStatus.OK);
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long blogId) {
        return new ResponseEntity<>(blogService.delete(blogId), HttpStatus.OK);
    }
}
