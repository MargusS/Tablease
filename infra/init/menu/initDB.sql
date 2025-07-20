CREATE DATABASE tablease_menu;

CREATE ROLE admin_user WITH LOGIN PASSWORD 'admin_password';
CREATE ROLE developer_user WITH LOGIN PASSWORD 'developer_password';
CREATE ROLE flyway_user WITH LOGIN PASSWORD 'flyway_password';

GRANT CONNECT ON DATABASE tablease_menu TO admin_user, developer_user, flyway_user;

ALTER ROLE flyway_user CREATEDB;
GRANT CREATE ON DATABASE tablease_menu TO flyway_user;

CREATE EXTENSION IF NOT EXISTS "pgcrypto";