DO
$do$
BEGIN
    IF NOT EXISTS (
        SELECT
        FROM pg_catalog.pg_roles
        WHERE rolname = 'tm_user') THEN
    CREATE USER tm_user WITH PASSWORD 'passwd';
    END IF;
END
$do$;

DROP DATABASE IF EXISTS tm_database;

CREATE DATABASE tm_database OWNER tm_user;
