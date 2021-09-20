create table fauna(
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values('dolphine', 36500, date '1300-08-20');
insert into fauna(name, avg_age, discovery_date)
values('swordfish', 30000, date '1500-01-01');
insert into fauna(name, avg_age, discovery_date)
values('cat', 3650, null);
insert into fauna(name, avg_age, discovery_date)
values('batterfly', 100, null);
insert into fauna(name, avg_age, discovery_date)
values('monkey', 20000, null);