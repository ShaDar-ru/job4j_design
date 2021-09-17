insert into modules(module_name, psb_id) values ('uzel silovoi', 1);
insert into modules(module_name, psb_id) values ('uzel_upravleniya', 2);

insert into PSB(PSB_name, module_id) values ('plata_uz_sil', 1);
insert into PSB(PSB_name, module_id) values ('plata_uz_upravl', 2);

insert into PSB_Modules(psb_id, module_id) values (1, 1);
insert into psb_modules(psb_id, module_id) values (2, 2);

insert into technologies(technology_name) values ('payka');
insert into technologies(technology_name) values ('posadka na kley');

insert into components(comp_name, technology_id) values ('Rezistor 0603', 1);
insert into components(comp_name, technology_id) values ('Rezistor 0804', 1);
insert into components(comp_name, technology_id) values ('Kondensator 1206', 1);
insert into components(comp_name, technology_id) values ('transformator', 2);

insert into comp_to_module(module_id, component_id) values (1, 1);
insert into comp_to_module(module_id, component_id) values (1, 2);
insert into comp_to_module(module_id, component_id) values (1, 3);
insert into comp_to_module(module_id, component_id) values (1, 4);
insert into comp_to_module(module_id, component_id) values (2, 1);
insert into comp_to_module(module_id, component_id) values (2, 2);
insert into comp_to_module(module_id, component_id) values (2, 3);
