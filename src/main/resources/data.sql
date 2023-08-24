INSERT INTO student (cnp, first_name, last_name, created_at, updated_at)
VALUES (1234567890123, 'Razvan', 'Joita', NOW(), NOW());

INSERT INTO student (cnp, first_name, last_name, created_at, updated_at)
VALUES (9876543210987, 'Vila', 'Bogdan', NOW(), NOW());

INSERT INTO student (cnp, first_name, last_name, created_at, updated_at)
VALUES (5555555555555, 'Rat', 'Adrian', NOW(), NOW());

-- Insert Roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_MODERATOR');

-- Insert Users
INSERT INTO users (username, email, password) VALUES ('user1', 'user1@example.com', 'password1');
INSERT INTO users (username, email, password) VALUES ('admin1', 'admin1@example.com', 'password1');

-- Insert User-Roles Mapping
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
