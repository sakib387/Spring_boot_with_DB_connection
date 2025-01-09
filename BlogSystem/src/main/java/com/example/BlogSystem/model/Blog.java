package com.example.BlogSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.text.DateFormat;
import java.time.LocalDate;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @NotNull(message = "Id can not be null")
    private Long blogId;

    @Size(max = 50 )
    @NotEmpty(message = "Title can not be empty")
    private String blogTitle;


    private String blogMessage;

    @Column( updatable = false)
    private LocalDate createdAt;


    private LocalDate updatedAt;

    public Blog() {
    }

    public Blog(Long blogId, String blogTitle, String blogMessage) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogMessage = blogMessage;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public void setBlogMessage(String blogMessage) {
        this.blogMessage = blogMessage;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getBlogId() {
        return blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public String getBlogMessage() {
        return blogMessage;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    @PrePersist
    public void onCreate(){
        this.createdAt=LocalDate.now();
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedAt=LocalDate.now();
    }
}
