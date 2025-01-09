package com.example.BlogSystem.service;

import com.example.BlogSystem.dto.BlogDTO;
import com.example.BlogSystem.exception.AlreadyExistBlog;
import com.example.BlogSystem.exception.BlogNotFoundException;
import com.example.BlogSystem.model.Blog;
import com.example.BlogSystem.repository.BlogRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class BlogServiceTest {

    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogService blogService;

    public BlogServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void fetchAllBlogs() {

        Blog blog1 = new Blog(1L, "Title1", "Message1");
        Blog blog2 = new Blog(2L, "Title2", "Message2");
        when(blogRepository.findAll()).thenReturn(Arrays.asList(blog1, blog2));
        var result = blogService.fetchAllBlogs();
        assertEquals(2, result.size());
        assertEquals("Title1", result.get(0).getBlogTitle());


    }


    @Test
    void findBlogById() {

        Blog blog = new Blog(1L, "Title1", "Message1");
        when(blogRepository.findById(1L)).thenReturn(Optional.of(blog));

        var result = blogService.findBlogById(1L);

        assertNotNull(result);
        assertEquals("Title1", result.getBlogTitle());
    }

    @Test
    void findBlogByIdButNotFound() {

        when(blogRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(BlogNotFoundException.class, () -> blogService.findBlogById(1L));
    }

    @Test
    void saveBlog() {

        Blog blog = new Blog(1L, "Title1", "Message1");
        when(blogRepository.existsById(1L)).thenReturn(false);
        when(blogRepository.save(blog)).thenReturn(blog);

        var result = blogService.saveBlog(blog);

        assertNotNull(result);
        assertEquals("Title1", result.getBlogTitle());
    }

    @Test
    void saveBlogAlreadyExists() {

        Blog blog = new Blog(1L, "Title1", "Message1");
        when(blogRepository.existsById(1L)).thenReturn(true);


        assertThrows(AlreadyExistBlog.class, () -> blogService.saveBlog(blog));

    }

    @Test
    void updateBlog() {

        Blog existingBlog = new Blog(1L, "OldTitle", "OldMessage");
        BlogDTO updatedBlogDTO = new BlogDTO("NewTitle", "NewMessage");
        when(blogRepository.findById(1L)).thenReturn(Optional.of(existingBlog));
        when(blogRepository.save(existingBlog)).thenReturn(existingBlog);

        var result = blogService.updateBlog(updatedBlogDTO, 1L);

        assertNotNull(result);
        assertEquals("NewTitle", result.getBlogTitle());
        assertEquals("NewMessage", result.getBlogMessage());
    }

    @Test
    void delete() {
        when(blogRepository.existsById(1L)).thenReturn(true);

        var result = blogService.delete(1L);

        assertEquals("Blog deleted with id 1", result);
    }
}