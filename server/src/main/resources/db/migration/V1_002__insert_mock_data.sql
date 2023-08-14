INSERT INTO users (name, email, phone_number)
VALUES
    ('John', 'john@email.com', '+35-4334-3443'),
    ('Wick', 'wick@email.com', '+86-322-123'),
    ('Keanu', 'keanu@email.com', '+27-3211-323'),
    ('Reaves', 'reaves@email.com', '+72-287-243');

INSERT INTO categories (name)
VALUES
    ('Sports'),
    ('Finance'),
    ('Movies');

INSERT INTO channels (name)
VALUES
    ('SMS'),
    ('E-mail'),
    ('Push Notification');

INSERT INTO users_categories
VALUES
    (1,1),
    (1,2),
    (1,3),
    (2,1),
    (2,2),
    (3,1),
    (4,1),
    (4,2);

INSERT INTO users_channels
VALUES
    (1,1),
    (1,2),
    (1,3),
    (2,2),
    (3,3),
    (4,1),
    (4,3);
