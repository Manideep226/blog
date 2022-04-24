package com.manideep.blog.service;

import com.manideep.blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface BlogService {
    HashMap<String,String> createBlog(Blog blog);
}
