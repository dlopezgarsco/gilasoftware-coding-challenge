CREATE TABLE notifications_log(
    notification_log_id serial PRIMARY KEY,
    notification_id INT NOT NULL,
    user_id INT NOT NULL,
    channel_id INT NOT NULL,
    success BOOLEAN NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (notification_id) REFERENCES notifications (notification_id),
    FOREIGN KEY (channel_id) REFERENCES channels (channel_id)
);
