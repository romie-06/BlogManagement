package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog getBlogById(String id) {
        Optional<Blog> optionalBlog = this.blogRepository.findById(id);
        return optionalBlog.orElse(null);
    }

    public List<Blog> getBlogByName(String name) {
        return this.blogRepository.findByName(name);
    }

    public Blog addNewBlog(Blog blog) {
        return this.blogRepository.save(blog);
    }

    public Blog updateBlog(Blog blog) {
        Optional<Blog> existingBlog = this.blogRepository.findById(blog.getId());
        if(existingBlog.isEmpty()) {
            throw new RuntimeException("Blog not found");
        }
        return this.blogRepository.save(blog);
    }

    public String approveBlog(String id) {
        Optional<Blog> existingBlog = this.blogRepository.findById(id);
        if(existingBlog.isEmpty()) {
            throw new RuntimeException("Blog not found");
        }
        Blog blog = existingBlog.get();
        blog.setApproved(true);
        this.blogRepository.save(blog);
        return "Blog approved successfully";
    }
}
