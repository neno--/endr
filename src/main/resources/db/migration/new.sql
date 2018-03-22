CREATE SEQUENCE hibernate_sequence
  START WITH 1
  INCREMENT BY 1;

CREATE TABLE collaboration ``
  (
     todo_list_id BIGINT NOT NULL,
     user_id      BIGINT NOT NULL,
     created_at   TIMESTAMP,
     privilege    VARCHAR(255),
     PRIMARY KEY (todo_list_id, user_id)
  );

CREATE TABLE todo_item
  (
     id           BIGINT NOT NULL,
     complete     BOOLEAN NOT NULL,
     completed_at TIMESTAMP,
     created_at   TIMESTAMP,
     description  VARCHAR(255),
     name         VARCHAR(255),
     todo_list_id BIGINT,
     PRIMARY KEY (id)
  );

CREATE TABLE todo_list
  (
     id   BIGINT NOT NULL,
     name VARCHAR(255),
     PRIMARY KEY (id)
  );

CREATE TABLE USER
  (
     id              BIGINT NOT NULL,
     nick            VARCHAR(255) NOT NULL,
     user_account_id BIGINT,
     PRIMARY KEY (id)
  );

CREATE TABLE user_account
  (
     id            BIGINT NOT NULL,
     email         VARCHAR(255),
     password      VARCHAR(255),
     registered_at TIMESTAMP,
     PRIMARY KEY (id)
  );

CREATE TABLE user_account_roles
  (
     user_account_id BIGINT NOT NULL,
     name            VARCHAR(255)
  );
