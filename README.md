# Student Management System (Java + JDBC)

A console-based Student Management System built using Java and JDBC.
This project performs basic CRUD operations on a PostgreSQL database.

## Features
- Add new student
- Update student details
- View all students
- Delete student by ID
- JDBC connection pooling

## Tech Stack
- Java
- JDBC
- PostgreSQL

## Project Structure
- entity → Student model
- service → Business logic & DB operations
- util → Database connection pool
- driver → Main application (menu-driven)

## Database Schema
```sql
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);
