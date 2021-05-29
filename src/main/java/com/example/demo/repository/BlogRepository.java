package com.example.demo.repository;

import com.example.demo.entity.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends CrudRepository<Blog, String> {

    List<Blog> findByName(String name);
}
