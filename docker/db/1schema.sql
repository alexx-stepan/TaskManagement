CREATE SCHEMA IF NOT EXISTS tm AUTHORIZATION tm_user;

CREATE TABLE IF NOT EXISTS tm.EMPLOYEES (
                              id serial PRIMARY KEY,
                              first_name varchar(20) not null,
                              last_name varchar(20) not null,
                              email varchar(25) not null,
                              phone varchar(15) not null
);
