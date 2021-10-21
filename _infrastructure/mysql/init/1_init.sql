CREATE DATABASE flip;
CREATE USER 'flip_user'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON flip.* TO 'flip_user'@'localhost';