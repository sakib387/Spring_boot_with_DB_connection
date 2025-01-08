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

### 1. Fetch All Blogs
**GET** `/api/blogs`  
Returns a list of all blog posts.

#### Response Example:
```json
[
  {
    "id": 1,
    "title": "My First Blog",
    "content": "This is the content of the first blog post."
  },
  {
    "id": 2,
    "title": "My Second Blog",
    "content": "This is the content of the second blog post."
  }
]
