insert into devices(name, price) values ('PC1', 10000);
insert into devices(name, price) values ('PC2', 12000);
insert into devices(name, price) values ('PC3', 15000);
insert into devices(name, price) values ('Laptop', 8000);
insert into devices(name, price) values ('Scanner', 2000);
insert into devices(name, price) values ('Cofemachine', 25000);

insert into people(name) values ('Vanya');
insert into people(name) values ('Dima');
insert into people(name) values ('Vasya');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (4, 1);
insert into devices_people(device_id, people_id) values (2, 2);
insert into devices_people(device_id, people_id) values (5, 2);
insert into devices_people(device_id, people_id) values (3, 3);
insert into devices_people(device_id, people_id) values (6, 3);