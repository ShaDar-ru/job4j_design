select * from gearbox left outer join car on gearbox.id = car.gearbox_id
where car.gearbox_id isnull;

select * from body left outer join car on body.id = car.body_id
where car.body_id isnull;