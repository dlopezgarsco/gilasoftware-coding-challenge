DROP SCHEMA IF EXISTS notifications CASCADE;
CREATE SCHEMA notifications;
SET search_path TO notifications;

CREATE TABLE users(
    user_id serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone_number VARCHAR(52) NOT NULL
);

CREATE TABLE categories(
    category_id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE channels(
    channel_id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE users_categories(
    user_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (user_id, category_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (category_id) REFERENCES categories (category_id)
);

CREATE TABLE users_channels(
    user_id INT NOT NULL,
    channel_id INT NOT NULL,
    PRIMARY KEY (user_id, channel_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (channel_id) REFERENCES channels (channel_id)
);
