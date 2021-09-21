insert into type(name) values ('СЫР');
insert into type(name) values ('МОРОЖЕНОЕ');
insert into type(name) values ('МОЛОКО');
insert into type(name) values ('ТВОРОГ');

insert into product(name, type_id, expired_date, price) values ('Сыр плавленный',1, date '21-07-2021', 69.00);
insert into product(name, type_id, expired_date, price) values ('Сыр моцарелла',1,date '21-12-2021', 59.00);
insert into product(name, type_id, expired_date, price) values ('Молоко пастеризованное', 3, date '19-11-2021',78.00);
insert into product(name, type_id, expired_date, price) values ('Молоко сгущенное',3, date '18-11-2021', 60.00);
insert into product(name, type_id, expired_date, price) values ('Мороженое помбир',2, date '10-01-2022', 150.00);
insert into product(name, type_id, expired_date, price) values ('Мороженое рожок',2, date '10-02-2022', 45.00);
insert into product(name, type_id, expired_date, price) values ('Творожок',4, date '24-09-2021',15.00);