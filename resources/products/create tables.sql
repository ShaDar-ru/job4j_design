create table product(
    id serial primary key,
    name varchar(255),
    type_id int,
    expired_date date,
    price numeric
);

create table type(
    id serial primary key,
    name varchar(255)
);