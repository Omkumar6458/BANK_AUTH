


-- Tables
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(200),
    enabled BOOLEAN DEFAULT TRUE,
    branch_id VARCHAR(20),
    employee_code VARCHAR(50)
);

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

--  Insert default roles (IMPORTANT)
INSERT INTO roles(name) VALUES ('ADMIN');
INSERT INTO roles(name) VALUES ('USER');

-- Insert default roles (IMPORTANT)
INSERT INTO roles(name) VALUES ('ROLE_ADMIN');
INSERT INTO roles(name) VALUES ('ROLE_BANKER');
-- Insert default roles (IMPORTANT)
INSERT INTO roles(name) VALUES ('ROLE_CUSTOMER');















