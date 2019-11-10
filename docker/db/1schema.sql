CREATE SCHEMA IF NOT EXISTS tm AUTHORIZATION tm_user;

CREATE TABLE IF NOT EXISTS tm.EMPLOYEES (
    id serial PRIMARY KEY,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(25) not null,
    phone varchar(15) not null
);

CREATE TYPE tm.TASK_STATUS as ENUM ('New', 'In progress', 'Resolved', 'Closed', 'Re-opened');

CREATE TYPE tm.PRIORITY as ENUM ('Low', 'Medium', 'High', 'Immediate', 'Urgent');

CREATE TABLE IF NOT EXISTS tm.TASKS (
    id serial PRIMARY KEY,
    parent_task_id int,
    assignee_id int NOT NULL,
    status tm.TASK_STATUS NOT NULL,
    title varchar(100),
    description varchar(300),
    priority tm.PRIORITY NOT NULL,

    CONSTRAINT FK_parent_task FOREIGN KEY (parent_task_id) REFERENCES tm.TASKS (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT FK_assignee FOREIGN KEY (assignee_id) REFERENCES tm.EMPLOYEES (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);
