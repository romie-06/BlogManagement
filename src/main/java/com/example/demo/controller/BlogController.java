package com.example.demo.controller;

import com.example.demo.entity.Blog;
import com.example.demo.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<Blog> add(@RequestBody Blog blog) {
        Blog savedBlog = this.blogService.addNewBlog(blog);
        return ResponseEntity.ok(savedBlog);
    }

    @PostMapping("/{blogId}")
    public ResponseEntity<String> approveBlog(@PathVariable String blogId) {
        String response = this.blogService.approveBlog(blogId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update")
    public ResponseEntity<Blog> updateBlog(@RequestBody  Blog blog) {
        Blog updatedBlog = this.blogService.updateBlog(blog);
        return ResponseEntity.ok(updatedBlog);
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<Blog> getBlog(@PathVariable String blogId){
        Blog blog = this.blogService.getBlogById(blogId);
        return ResponseEntity.ok(blog);
    }
}
