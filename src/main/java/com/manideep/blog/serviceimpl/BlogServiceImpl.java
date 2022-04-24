package com.manideep.blog.serviceimpl;

import com.manideep.blog.common.SpellCheckerJazzy;
import com.manideep.blog.model.Blog;
import com.manideep.blog.model.BlogStatus;
import com.manideep.blog.repository.BlogRepository;
import com.manideep.blog.repository.BlogStatusRepository;
import com.manideep.blog.service.BlogService;
import com.swabunga.spell.event.SpellChecker;
import com.swabunga.spell.event.StringWordTokenizer;
import com.swabunga.spell.event.TeXWordFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    BlogStatusRepository blogStatusRepository;

    @Override
    public HashMap<String, String> createBlog(Blog blog) {
        HashMap<String,String> response = new HashMap<>();
        BlogStatus blogStatus = new BlogStatus();
        SpellCheckerJazzy spellCheckerJazzy = new SpellCheckerJazzy();
        blog.setCreatedAt(new Date());
        blog.setCreatedAt(new Date());
        Blog b = blogRepository.save(blog);
        List<String> l = spellCheckerJazzy.getMisspelledWords(blog.getBlogContent());
        if(l.size()==0){
            blogStatus.setBlogId(b.getBlogId());
            blogStatus.setStatus(1);
            blogStatus.setComments("Spell check passed");
            BlogStatus bl = blogStatusRepository.save(blogStatus);
            response = sendForExpertReview(blog,bl.getBlogStatusId(),b.getBlogId());
//            response.put("message","Stage 1 Approved");
            return response;
        }else {
            blogStatus.setBlogId(b.getBlogId());
            blogStatus.setStatus(2);
            blogStatus.setComments("Spell check failed");
            blogStatusRepository.save(blogStatus);
            response.put("message", "Request Rejected because of Spelling Mistakes");
            return response;
        }
    }

    public HashMap<String,String> sendForExpertReview(Blog blog, Integer blogStatusId, Integer blogId){
        boolean isApproved = false;
        BlogStatus blogStatus = new BlogStatus();
        HashMap<String,String> response = new HashMap<>();
//        Blog bl=blogRepository.getById(blogStatusId);
        if(!isApproved){
            blogStatus.setBlogId(blogId);
            blogStatus.setStatus(5);
            blogStatus.setComments("Expert Rejected");
            blogStatusRepository.save(blogStatus);
            response.put("message","Expert Reject");
            return response;
        }else {
            blogStatus.setStatus(4);
            blogStatus.setComments("Expert Accepted");
            blogStatus.setBlogStatusId(blogStatusId);
            blogStatusRepository.save(blogStatus);
            response.put("message", "Expert Accepted");
            return response;
        }
    }

}
