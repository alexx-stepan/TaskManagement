CREATE SCHEMA IF NOT EXISTS tm AUTHORIZATION tm_user;

CREATE TABLE IF NOT EXISTS tm.EMPLOYEES (
    id serial PRIMARY KEY,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(25) not null,
    phone varchar(15) not null
);

CREATE TYPE tm.TASK_STATUS as ENUM ('New', 'In progress', 'Resolved', 'Closed', 'Reopened');

CREATE TYPE tm.PRIORITY as ENUM ('Low', 'Medium', 'High', 'Immediate', 'Urgent');

CREATE TABLE IF NOT EXISTS tm.TASKS (
    id serial PRIMARY KEY,
    parent_task_id int,
    assignee_id int NOT NULL,
    status tm.TASK_STATUS NOT NULL DEFAULT 'New',
    title varchar(100),
    description varchar(500),
    priority tm.PRIORITY NOT NULL,

    CONSTRAINT FK_parent_task FOREIGN KEY (parent_task_id) REFERENCES tm.TASKS (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT FK_assignee FOREIGN KEY (assignee_id) REFERENCES tm.EMPLOYEES (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS tm.TASK_UPDATES (
    id serial PRIMARY KEY,
    related_task_id int NOT NULL,
    message varchar(500),
	status_old tm.TASK_STATUS,
	status_new tm.TASK_STATUS,
    assignee_old_id int,
    assignee_new_id int,
    priority_old tm.PRIORITY,
	priority_new tm.PRIORITY,
	update_performer_id int NOT NULL,

	CONSTRAINT FK_update_performer FOREIGN KEY (update_performer_id) REFERENCES tm.EMPLOYEES(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,

	CONSTRAINT FK_related_task FOREIGN KEY (related_task_id) REFERENCES tm.TASKS(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,

	CONSTRAINT FK_assignee_old FOREIGN KEY (assignee_old_id) REFERENCES tm.EMPLOYEES (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT FK_assignee_new FOREIGN KEY (assignee_new_id) REFERENCES tm.EMPLOYEES (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE OR REPLACE FUNCTION tm.refresh_task_update_history() RETURNS TRIGGER
    AS $$
    <<fn>>
    DECLARE
		status_old tm.TASK_STATUS := NULLIF(OLD.status, NEW.status)::tm.TASK_STATUS;
		status_new tm.TASK_STATUS := NULLIF(NEW.status, OLD.status)::tm.TASK_STATUS;

		assignee_old_id int := NULLIF(OLD.assignee_id, NEW.assignee_id);
		assignee_new_id int := NULLIF(NEW.assignee_id, OLD.assignee_id);

		priority_old tm.PRIORITY := NULLIF(OLD.priority, NEW.priority)::tm.PRIORITY;
		priority_new tm.PRIORITY := NULLIF(NEW.priority, OLD.priority)::tm.PRIORITY;
    BEGIN
        INSERT INTO tm.TASK_UPDATES(related_task_id, status_old, status_new, assignee_old_id, assignee_new_id, priority_old, priority_new, update_performer_id)
        VALUES (OLD.id, fn.status_old, fn.status_new, fn.assignee_old_id, fn.assignee_new_id, fn.priority_old, fn.priority_new, 1);

		RETURN NEW;
    END;
    $$ LANGUAGE plpgsql;

CREATE TRIGGER task_updates_audit AFTER UPDATE ON tm.TASKS FOR EACH ROW EXECUTE PROCEDURE tm.refresh_task_update_history();
