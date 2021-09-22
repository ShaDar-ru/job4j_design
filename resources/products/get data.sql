select * from product where type_id = 1; 
--аналогично первому, если мы не знаем ID сыра
select * from product inner join type on type_id = type.id
where type.name ilike '%сыр%';
select * from product where name ilike '%мороженое%';
select * from product where expired_date < current_date;
select type.name, count(type.id) from type inner join product
on type.id = product.type_id group by type.name;
select name, price from product where price = (select max(price) from product);
select * from product inner join type on type_id=type.id where type.name
ilike '%сыр%' or type.name ilike '%молоко%';
select type.name, count(type_id) from product inner join type on type_id=type.id
 group by type.name having count(type_id) < 10;