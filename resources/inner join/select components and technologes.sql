select
    c.comp_name as Компонент,
    t.technology_name as Технология
from components as c inner join technologies as t on c.technology_id = t.id;