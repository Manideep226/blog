package com.manideep.blog.controller;

import com.manideep.blog.model.Blog;
import com.manideep.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @PostMapping("/create")
    public HashMap<String,String> createBlog(@RequestBody Blog blog){
        HashMap<String,String> response = blogService.createBlog(blog);
        return response;
    }
}
