CREATE TABLE users (
                       username VARCHAR(50) NOT NULL PRIMARY KEY,
                       password VARCHAR(100) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             FOREIGN KEY (username) REFERENCES users(username)
);


INSERT INTO users (username, password, enabled) VALUES ('admin', '0000', true);
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO users (username, password, enabled) VALUES ('admin1', 'admin1', true);
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');

INSERT INTO users (username, password, enabled) VALUES ('user', '1234', true);
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
