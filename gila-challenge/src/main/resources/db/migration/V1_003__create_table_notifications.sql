CREATE TABLE notifications(
    notification_id serial PRIMARY KEY,
    message VARCHAR(MAX) NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories (category_id)
);
