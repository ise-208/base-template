CREATE TABLE users(
    id varchar(30),
    name varchar(30),
    password varchar(120),
    role varchar(30)
);

CREATE TABLE roles(
    id varchar(30),
    name varchar(30),
    users varchar(120)
);