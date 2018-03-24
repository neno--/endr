CREATE TABLE collaboration
  (
     todo_list_id VARCHAR(255) NOT NULL,
     user_id      VARCHAR(255) NOT NULL,
     created_at   TIMESTAMP NOT NULL,
     privilege    VARCHAR(255) NOT NULL,
     PRIMARY KEY (todo_list_id, user_id)
  );

CREATE TABLE todo_item
  (
     id           VARCHAR(255) NOT NULL,
     complete     BOOLEAN NOT NULL,
     completed_at TIMESTAMP NOT NULL,
     created_at   TIMESTAMP NOT NULL,
     description  VARCHAR(255),
     name         VARCHAR(255) NOT NULL,
     todo_list_id VARCHAR(255) NOT NULL,
     user_id      VARCHAR(255) NOT NULL,
     PRIMARY KEY (id)
  );

CREATE TABLE todo_list
  (
     id   VARCHAR(255) NOT NULL,
     NAME VARCHAR(255) NOT NULL,
     PRIMARY KEY (id)
  );

CREATE TABLE user
  (
     id   VARCHAR(255) NOT NULL,
     nick VARCHAR(255) NOT NULL,
     PRIMARY KEY (id)
  );

CREATE TABLE user_account
  (
     id            VARCHAR(255) NOT NULL,
     email         VARCHAR(255) NOT NULL,
     password      VARCHAR(255) NOT NULL,
     registered_at TIMESTAMP NOT NULL,
     user_id       VARCHAR(255),
     PRIMARY KEY (id)
  );

CREATE TABLE user_account_roles
  (
     user_account_id VARCHAR(255) NOT NULL,
     name            VARCHAR(255) NOT NULL,
     PRIMARY KEY (user_account_id, NAME)
  );

ALTER TABLE user_account
  ADD CONSTRAINT uk_user_account_email UNIQUE (email);

ALTER TABLE user_account_roles
  ADD CONSTRAINT uk_user_account_roles_name UNIQUE (NAME);

ALTER TABLE collaboration
  ADD CONSTRAINT fk_collaboration_todolist FOREIGN KEY (todo_list_id)
  REFERENCES todo_list;

ALTER TABLE collaboration
  ADD CONSTRAINT fk_collaboration_user FOREIGN KEY (user_id) REFERENCES
  user;

ALTER TABLE todo_item
  ADD CONSTRAINT fk_todo_item_todo_list FOREIGN KEY (todo_list_id)
  REFERENCES todo_list;

ALTER TABLE user_account
  ADD CONSTRAINT fk_user_account_user FOREIGN KEY (user_id) REFERENCES
  user;

ALTER TABLE user_account_roles
  ADD CONSTRAINT fh_user_account_roles_user_account FOREIGN KEY (user_account_id)
  REFERENCES user_account;
