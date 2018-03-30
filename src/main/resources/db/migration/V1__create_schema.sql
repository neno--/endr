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
     NAME         VARCHAR(255) NOT NULL,
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

CREATE TABLE USER
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
     user_id       VARCHAR(255) NOT NULL,
     PRIMARY KEY (id)
  );

CREATE TABLE user_account_privileges
  (
     user_account_id VARCHAR(255) NOT NULL,
     NAME            VARCHAR(255)
  );

ALTER TABLE user_account
  ADD CONSTRAINT uk_my17tf2l7ojod9fu836oxcobn UNIQUE (user_id);

ALTER TABLE user_account
  ADD CONSTRAINT uk_hl02wv5hym99ys465woijmfib UNIQUE (email);

ALTER TABLE collaboration
  ADD CONSTRAINT fk1a5rhjhledyxlswsqj6m527jg FOREIGN KEY (todo_list_id)
  REFERENCES todo_list;

ALTER TABLE collaboration
  ADD CONSTRAINT fkcbpe4lra8sgo5mjwbr51kks8p FOREIGN KEY (user_id) REFERENCES
  USER;

ALTER TABLE todo_item
  ADD CONSTRAINT fkteq2m3pydjyfajp6msycpeac3 FOREIGN KEY (todo_list_id)
  REFERENCES todo_list;

ALTER TABLE todo_item
  ADD CONSTRAINT fk8lme8ctm4ksjby7ixlpid31vi FOREIGN KEY (user_id) REFERENCES
  USER;

ALTER TABLE user_account
  ADD CONSTRAINT fk4qaqge5ewvmfuwsp5eddfr4r2 FOREIGN KEY (user_id) REFERENCES
  USER;

ALTER TABLE user_account_privileges
  ADD CONSTRAINT fkqdmkecokryvyd4febj3n5wfmy FOREIGN KEY (user_account_id)
  REFERENCES user_account;
