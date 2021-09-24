create table engine(
	id serial primary key,
	model varchar(255)
);

create table gearbox(
	id serial primary key,
	model varchar(255)
);

create table body(
	id serial primary key,
	model varchar(255)
);

create table Car(
	id serial primary key,
	name varchar(255),
	gearbox_id int references gearbox(id),
	engine_id int references engine(id),
	body_id int references body(id)
);

insert into engine(model) values ('carburetor');
insert into engine(model) values ('injector');
insert into engine(model) values ('Wankel engine');
insert into engine(model) values ('Stirlings engine');

insert into gearbox(model) values ('mechanical');
insert into gearbox(model) values ('planetary');
insert into gearbox(model) values ('hydromechanical');
insert into gearbox(model) values ('variator');

insert into body(model) values ('sedan');
insert into body(model) values ('hatchback');
insert into body(model) values ('pickup');
insert into body(model) values ('station wagon');