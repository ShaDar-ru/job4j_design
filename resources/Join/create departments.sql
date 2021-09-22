create table departments(
	id serial primary key,
	name varchar(255)
);

create table employers(
	id serial primary key,
	name varchar(255),
	department_id int
);