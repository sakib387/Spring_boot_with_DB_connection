package com.example.BlogSystem.dto;

public class BlogDTO {

    private String blogTitle;
    private String blogMessage;

    public BlogDTO(String blogTitle, String blogMessage) {
        this.blogTitle = blogTitle;
        this.blogMessage = blogMessage;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogMessage() {
        return blogMessage;
    }

    public void setBlogMessage(String blogMessage) {
        this.blogMessage = blogMessage;
    }
}
