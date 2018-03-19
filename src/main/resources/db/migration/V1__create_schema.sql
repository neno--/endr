CREATE SEQUENCE hibernate_sequence
  START WITH 1
  INCREMENT BY 1;

CREATE TABLE collaboration
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
     todolist_id  BIGINT,
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
     id         BIGINT NOT NULL,
     first_name VARCHAR(255),
     last_name  VARCHAR(255),
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

ALTER TABLE collaboration
  ADD CONSTRAINT fk_collaboration_user FOREIGN KEY (user_id) REFERENCES
  USER;

ALTER TABLE collaboration
  ADD CONSTRAINT fk_collaboration_todolist FOREIGN KEY (todolist_id)
  REFERENCES todo_list;

ALTER TABLE todo_item
  ADD CONSTRAINT fk_todo_item_todo_list FOREIGN KEY (todolist_id)
  REFERENCES todo_list;

ALTER TABLE user_account_roles
  ADD CONSTRAINT fh_user_account_roles_user_account FOREIGN KEY (user_account_id)
  REFERENCES user_account;
