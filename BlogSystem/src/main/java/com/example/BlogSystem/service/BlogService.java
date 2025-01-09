package com.example.BlogSystem.service;

import com.example.BlogSystem.dto.BlogDTO;
import com.example.BlogSystem.exception.AlreadyExistBlog;
import com.example.BlogSystem.exception.BlogNotFoundException;
import com.example.BlogSystem.model.Blog;
import com.example.BlogSystem.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> fetchAllBlogs() {
        return blogRepository.findAll();
    }


    public Blog findBlogById(Long blogId) {

        return blogRepository.findById(blogId)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found by this id " + blogId.toString()));

    }

    public Blog saveBlog(Blog blog) {

        if (blogRepository.existsById(blog.getBlogId())) {
            throw new AlreadyExistBlog("Already exist a Blog id" + blog.getBlogId());
        }
        return blogRepository.save(blog);
    }

    public Blog updateBlog(BlogDTO blog, Long blogId) {

        return blogRepository.findById(blogId).map(bl -> {
            bl.setBlogTitle(blog.getBlogTitle());
            bl.setBlogMessage(blog.getBlogMessage());
            return blogRepository.save(bl);
        }).orElseThrow(() -> new BlogNotFoundException("Blog not found by this id " + blogId.toString()));


    }

    public String delete(Long blogId) {

        if (!blogRepository.existsById(blogId)) {
            throw new BlogNotFoundException("Blog not found by this id " + blogId.toString());
        }
        blogRepository.deleteById(blogId);
        return "Blog deleted with id " + blogId.toString();
    }
}
