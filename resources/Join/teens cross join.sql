select t1.name as t1, t2.name as t2, (t1.gender != t2.gender) as "couple"
 from teens t1 cross join teens t2 where t1.gender != t2.gender;

--Можно уточнить запрос, чтобы избавиться от дубликатов--
select t1.name, t2.name, (t1.gender != t2.gender) as couple
 from teens t1 cross join teens t2 where t1.gender = true
 and t1.gender != t2.gender;