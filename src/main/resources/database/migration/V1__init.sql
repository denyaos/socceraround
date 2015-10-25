CREATE TABLE user (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(50) NOT NULL,
  enabled BOOLEAN NOT NULL
);

CREATE TABLE authority (
  id TINYINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE user_authority (
  user_id BIGINT NOT NULL,
  authority_id TINYINT NOT NULL,
  PRIMARY KEY (user_id, authority_id),
  FOREIGN KEY (user_id) REFERENCES user (id),
  FOREIGN KEY (authority_id) REFERENCES authority (id)
);

CREATE TABLE player (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  email VARCHAR(255),
  user_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user (id)
);

INSERT INTO authority (name) VALUES ('ROLE_ADMIN');
INSERT INTO authority (name) VALUES ('ROLE_PLAYER');

INSERT INTO user (username, password, enabled) VALUES ('admin', 'pass', TRUE);
INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO player (user_id) VALUES (1);

INSERT INTO user (username, password, enabled) VALUES ('user', 'pass', TRUE);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);
INSERT INTO player (user_id) VALUES (2);

INSERT INTO user (username, password, enabled) VALUES ('viktor', 'pass', TRUE);
INSERT INTO user_authority (user_id, authority_id) VALUES (3, 2);
INSERT INTO player (first_name, last_name, email, user_id) VALUES ('Viktor', 'Budny', 'vbudny@q.q', 3);

INSERT INTO user (username, password, enabled) VALUES ('vitaly', 'pass', TRUE);
INSERT INTO user_authority (user_id, authority_id) VALUES (4, 2);
INSERT INTO player (first_name, last_name, email, user_id) VALUES ('Vitaly', 'Sewick', 'vsewick@q.q', 4);

INSERT INTO user (username, password, enabled) VALUES ('yevheniy', 'pass', TRUE);
INSERT INTO user_authority (user_id, authority_id) VALUES (5, 2);
INSERT INTO player (first_name, last_name, email, user_id) VALUES ('Yevheniy', 'Kohut', 'ykohut@q.q', 5);

INSERT INTO user (username, password, enabled) VALUES ('mykhaylo', '1', TRUE);
INSERT INTO user_authority (user_id, authority_id) VALUES (6, 2);
INSERT INTO player (first_name, last_name, email, user_id) VALUES ('Mykhaylo', 'Kozel', 'mkozel@q.q', 6);

INSERT INTO user (username, password, enabled) VALUES ('kostyantyn', '1', TRUE);
INSERT INTO user_authority (user_id, authority_id) VALUES (7, 2);
INSERT INTO player (first_name, last_name, email, user_id) VALUES ('Kostyantyn', 'Chownyk', 'kchownyk@q.q', 7);

INSERT INTO user (username, password, enabled) VALUES ('wasyl', '1', TRUE);
INSERT INTO user_authority (user_id, authority_id) VALUES (8, 2);
INSERT INTO player (first_name, last_name, email, user_id) VALUES ('Wasyl', 'Shwetz', 'wshwetz@q.q', 8);

INSERT INTO user (username, password, enabled) VALUES ('nataliya', '1', TRUE);
INSERT INTO user_authority (user_id, authority_id) VALUES (9, 2);
INSERT INTO player (first_name, last_name, email, user_id) VALUES ('Nataliya', 'Stasiuk', 'nstasiuk@q.q', 9);

INSERT INTO user (username, password, enabled) VALUES ('yaroslav', '1', TRUE);
INSERT INTO user_authority (user_id, authority_id) VALUES (10, 2);
INSERT INTO player (first_name, last_name, email, user_id) VALUES ('Yaroslav', 'Zelenko', 'yzelenko@q.q', 10);

INSERT INTO user (username, password, enabled) VALUES ('oksana', '1', TRUE);
INSERT INTO user_authority (user_id, authority_id) VALUES (11, 2);
INSERT INTO player (first_name, last_name, email, user_id) VALUES ('Oksana', 'Gavrilyuk', 'ogavrilyuk@q.q', 11);

