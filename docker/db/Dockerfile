FROM postgres:12.0-alpine

ENV PGDATA /var/lib/pgsql/data/
ENV POSTGRES_DB tm_database
ENV POSTGRES_USER tm_user
ENV POSTGRES_PASSWORD passwd

ADD 1schema.sql /docker-entrypoint-initdb.d/
ADD 2data.sql /docker-entrypoint-initdb.d/
