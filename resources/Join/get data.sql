select * from departments left join employers on departments.id=department_id;
select * from departments right join employers on departments.id=department_id;
select * from departments cross join employers;

select * from employers left join departments on departments.id=department_id;

select * from employers left join departments on departments.id=department_id;
select * from departments right join employers on departments.id=department_id;