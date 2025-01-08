# BlogSystem

A Spring Boot application for managing a simple blogging system. This application provides RESTful APIs to perform CRUD operations on blog posts.

## Features

- **Create a blog post**: Add a new blog post with title and content.
- **Read blog posts**:
  - Fetch all blog posts.
  - Fetch a single blog post by its ID.
- **Update a blog post**: Edit the details of an existing blog post.
- **Delete a blog post**: Remove a blog post by its ID.

## Technologies Used

- **Java**: Backend logic.
- **Spring Boot**: Framework for building the application.
- **Spring Web**: For creating RESTful APIs.
- **Spring Validation**: To validate request bodies.
- **Spring Data JPA**: For database interactions.
- **H2 Database**: In-memory database for testing.

## API Endpoints
GET /api/blogs           - Fetch all blogs.
GET /api/blogs/{blogId}  - Fetch a blog by ID.
POST /api/blogs          - Create a new blog.
PUT /api/blogs/{blogId}  - Update a blog.
DELETE /api/blogs/{blogId} - Delete a blog.

