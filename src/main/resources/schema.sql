
-- Create Student Table
CREATE TABLE student (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         cnp BIGINT NOT NULL,
                         first_name VARCHAR(255),
                         last_name VARCHAR(255),
                         created_at TIMESTAMP,
                         updated_at TIMESTAMP
);

-- Create Role Table
CREATE TABLE roles (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(20)
);

-- Create User Table
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(20) NOT NULL,
                       email VARCHAR(50) NOT NULL,
                       password VARCHAR(120) NOT NULL
);

-- Create User-Roles Many to many table
CREATE TABLE user_roles (
                            user_id BIGINT,
                            role_id INT,
                            FOREIGN KEY (user_id) REFERENCES users (id),
                            FOREIGN KEY (role_id) REFERENCES roles (id)
);
