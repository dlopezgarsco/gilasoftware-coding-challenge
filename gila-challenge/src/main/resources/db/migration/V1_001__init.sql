CREATE TABLE users(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone_number VARCHAR(52) NOT NULL
);

CREATE TABLE categories(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE channels(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE users_categories(
    user_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (user_id, category_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE users_channels(
    user_id INT NOT NULL,
    channel_id INT NOT NULL,
    PRIMARY KEY (user_id, channel_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (channel_id) REFERENCES channels (id)
);