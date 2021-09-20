select 
	cp.comp_name as Компонент,
	mo.module_name as Модуль
from
	comp_to_module inner join modules as mo on comp_to_module.module_id = mo.id 
	inner join components as cp on comp_to_module.component_id = cp.id;