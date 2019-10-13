INSERT INTO tm.EMPLOYEES(first_name, last_name, email, phone) VALUES ('Ivan', 'Ivanov', 'ivanov@gmail.com', '123456789');
INSERT INTO tm.EMPLOYEES(first_name, last_name, email, phone) VALUES ('Petr', 'Petrov', 'petrov@gmail.com', '567891235');

INSERT INTO tm.TASK_STATUSES(description) VALUES ('New');
INSERT INTO tm.TASK_STATUSES(description) VALUES ('In progress');
INSERT INTO tm.TASK_STATUSES(description) VALUES ('Resolved');
INSERT INTO tm.TASK_STATUSES(description) VALUES ('Reopened');

INSERT INTO tm.TASKS (parent_task_id, performer_id, status_id, description) VALUES (null, 1, 1, 'Create report on performance of your subordinates');
INSERT INTO tm.TASKS (parent_task_id, performer_id, status_id, description) VALUES (null, 2, 1, 'Implement LoginController');
INSERT INTO tm.TASKS (parent_task_id, performer_id, status_id, description) VALUES (2, 2, 1, 'Include Security module into project');
