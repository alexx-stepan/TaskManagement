INSERT INTO tm.EMPLOYEES(first_name, last_name, email, phone) VALUES ('Ivan', 'Ivanov', 'ivanov@gmail.com', '123456789');
INSERT INTO tm.EMPLOYEES(first_name, last_name, email, phone) VALUES ('Petr', 'Petrov', 'petrov@gmail.com', '567891235');

INSERT INTO tm.TASKS (parent_task_id, assignee_id, status, title, description, priority) VALUES (null, 1, 'New', 'Create report on performance of your subordinates', 'some description', 'High');
INSERT INTO tm.TASKS (parent_task_id, assignee_id, status, title, description, priority) VALUES (null, 2, 'New', 'Implement LoginController', 'some description', 'Low');
INSERT INTO tm.TASKS (parent_task_id, assignee_id, status, title, description, priority) VALUES (2, 2, 'New', 'Include Security module into project', 'some description', 'Medium');
