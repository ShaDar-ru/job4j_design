select avg(price) from devices;

select people.name, avg(price) from devices_people as d inner join people on people.id=d.people_id 
inner join devices on devices.id=d.device_id 
group by people.name;

select people.name, avg(price) from devices_people as d inner join people on people.id=d.people_id 
inner join devices on devices.id=d.device_id 
group by people.name having avg(price) > 5000;

--Для убеждения, что функция верна введем дополнительный вывод данных с срюценой больше 10к--
select people.name, avg(price) from devices_people as d inner join people on people.id=d.people_id 
inner join devices on devices.id=d.device_id 
group by people.name having avg(price) > 10000;