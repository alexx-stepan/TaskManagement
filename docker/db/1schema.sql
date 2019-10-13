CREATE SCHEMA IF NOT EXISTS tm AUTHORIZATION tm_user;

CREATE TABLE IF NOT EXISTS tm.EMPLOYEES (
    id serial PRIMARY KEY,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(25) not null,
    phone varchar(15) not null
);

CREATE TABLE IF NOT EXISTS tm.TASK_STATUSES (
    id serial PRIMARY KEY,
    description varchar(20)
);

CREATE TABLE IF NOT EXISTS tm.TASKS (
    id serial PRIMARY KEY,
    parent_task_id int,
    performer_id int NOT NULL,
    status_id int NOT NULL ,
    description varchar(100),

    CONSTRAINT FK_parent_task FOREIGN KEY (parent_task_id) REFERENCES tm.TASKS (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT FK_performer FOREIGN KEY (performer_id) REFERENCES tm.EMPLOYEES (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT FK_task_status FOREIGN KEY (status_id) REFERENCES tm.TASK_STATUSES (id)
    	ON DELETE RESTRICT
        ON UPDATE CASCADE
);
