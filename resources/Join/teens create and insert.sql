create table teens(
	id serial primary key,
	gender boolean,
	name varchar(255)
);

insert into teens(name, gender) values('Masha', false);
insert into teens(name, gender) values('Sasha', true);
insert into teens(name, gender) values('Vera', false);
insert into teens(name, gender) values('Lesha', true);
insert into teens(name, gender) values('Dima', true);
