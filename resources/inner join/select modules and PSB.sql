select 
    mo.module_name as Модуль,
    ps.psb_name as Плата
from
    PSB_Modules as psbm inner join modules as mo on psbm.psb_id = mo.psb_id
    inner join PSB as ps on psbm.module_id = ps.module_id;