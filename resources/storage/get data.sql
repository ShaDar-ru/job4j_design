select * from gearbox left outer join car on gearbox.id = car.gearbox_id
where gearbox.id = 3;
select * from gearbox left outer join car on gearbox.id = car.gearbox_id
where gearbox.id = 4;
select * from body left outer join car on body.id = car.body_id
where body.id = 3;