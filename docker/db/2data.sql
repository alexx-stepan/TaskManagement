INSERT INTO tm.EMPLOYEES(first_name, last_name, email, phone) VALUES ('Ivan', 'Ivanov', 'ivanov@gmail.com', '123456789');
INSERT INTO tm.EMPLOYEES(first_name, last_name, email, phone) VALUES ('Petr', 'Petrov', 'petrov@gmail.com', '567891235');

INSERT INTO tm.TASKS (parent_task_id, assignee_id, title, description, priority) VALUES (null, 1, 'Create report on performance of your subordinates', 'some description', 'High');
INSERT INTO tm.TASKS (parent_task_id, assignee_id, title, description, priority) VALUES (null, 2, 'Implement LoginController', 'some description', 'Low');
INSERT INTO tm.TASKS (parent_task_id, assignee_id, title, description, priority) VALUES (2, 2, 'Include Security module into project', 'some description', 'Medium');

INSERT INTO tm.TASK_UPDATES (related_task_id, message, assignee_old_id, assignee_new_id, update_performer_id) VALUES (1, 'Some question for clarification', 1, 2, 1);
INSERT INTO tm.TASK_UPDATES (related_task_id, message, assignee_old_id, assignee_new_id, update_performer_id) VALUES (1, 'Clarifying answer', 2, 1, 2);
INSERT INTO tm.TASK_UPDATES (related_task_id, status_old, status_new, update_performer_id) VALUES (1, 'New', 'In progress', 1);
